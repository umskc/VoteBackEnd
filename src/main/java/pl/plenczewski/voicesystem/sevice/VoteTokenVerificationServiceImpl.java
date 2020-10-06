package pl.plenczewski.voicesystem.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.plenczewski.voicesystem.model.Inhabitant;
import pl.plenczewski.voicesystem.model.VoteTokenVerification;
import pl.plenczewski.voicesystem.repostory.InhabitantRepository;
import pl.plenczewski.voicesystem.repostory.VoteTokenVerificationRepository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class VoteTokenVerificationServiceImpl implements VoteTokenVerificationService {

    private VoteTokenVerificationRepository voteTokenVerificationRepository;
    private InhabitantRepository inhabitantRepository;

    @Autowired
    public VoteTokenVerificationServiceImpl(VoteTokenVerificationRepository voteTokenVerificationRepository, InhabitantRepository inhabitantRepository) {
        this.voteTokenVerificationRepository = voteTokenVerificationRepository;
        this.inhabitantRepository = inhabitantRepository;
    }

    @Transactional
    @Override
    public VoteTokenVerification generateVoteVerificationToken(Inhabitant inhabitant) {
        Inhabitant checkedInhabitant = checkInhabitantData(inhabitant);
        return checkedInhabitant != null ? generateToken(checkedInhabitant) : null;
    }

    private VoteTokenVerification generateToken(Inhabitant inhabitant) {
        VoteTokenVerification voteTokenVerification = new VoteTokenVerification(UUID.randomUUID().toString(), inhabitant);
        return voteTokenVerificationRepository.save(voteTokenVerification);
    }

    private Inhabitant checkInhabitantData(Inhabitant inhabitant) {
        boolean inhabitantCanVote = false;
        Optional<Inhabitant> findInhabitant = inhabitantRepository.findByNameAndSurnameAndStreetAndHomeNumberAndLocalNumber(inhabitant.getName(), inhabitant.getSurname(), inhabitant.getStreet(), inhabitant.getHomeNumber(), inhabitant.getLocalNumber());
        if (findInhabitant.isPresent()) {
            inhabitantCanVote = findInhabitant.get().isEnabled();
            if (!voteTokenVerificationRepository.findAllByInhabitant_Id(findInhabitant.get().getId()).isEmpty()) {
                voteTokenVerificationRepository.deleteAllByInhabitant_Id(findInhabitant.get().getId());
            }
        }
        return (findInhabitant.isPresent() && inhabitantCanVote) ? findInhabitant.get() : null;
    }
}

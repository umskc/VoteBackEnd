package pl.plenczewski.voicesystem.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.plenczewski.voicesystem.model.*;
import pl.plenczewski.voicesystem.repostory.GlobalProjectRepository;
import pl.plenczewski.voicesystem.repostory.LocalProjectRepository;
import pl.plenczewski.voicesystem.repostory.VoicesRepository;
import pl.plenczewski.voicesystem.repostory.VoteTokenVerificationRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VoiceMainService {

    @Value("${max.votes.local}")
    private static Integer MAX_VOTES_OF_LOCAL_PROJECT = 2;
    @Value("${max.votes.global}")
    private static Integer MAX_VOTES_OF_GLOBAL_PROJECT = 2;

    private GlobalProjectRepository globalProjectRepository;
    private LocalProjectRepository localProjectRepository;
    private VoteTokenVerificationRepository voteTokenVerificationRepository;
    private VoicesRepository voicesRepository;

    @Autowired
    public VoiceMainService(GlobalProjectRepository globalProjectRepository, LocalProjectRepository localProjectRepository, VoteTokenVerificationRepository voteTokenVerificationRepository, VoicesRepository voicesRepository) {
        this.globalProjectRepository = globalProjectRepository;
        this.localProjectRepository = localProjectRepository;
        this.voteTokenVerificationRepository = voteTokenVerificationRepository;
        this.voicesRepository = voicesRepository;
    }

    @Transactional
    public void processOneVoice(List<Long> idsOfGlobalProject, List<Long> idsOfLocalProjects, String token) {
        if (validateQuantityVote(idsOfGlobalProject, idsOfLocalProjects) && checkToken(token)) {
            voicesRepository.save(createVoicesToPersist(idsOfGlobalProject, idsOfLocalProjects, token));
            blockInhabitantByTokenValueAndDeleteToken(token);
        }
    }

    private Voices createVoicesToPersist(List<Long> idsOfGlobalProject, List<Long> idsOfLocalProjects, String token) {
        List<LocalProject> localProjects = localProjectRepository.findAllByIdIn(idsOfLocalProjects);
        List<GlobalProject> globalProjects = globalProjectRepository.findAllByIdIn(idsOfGlobalProject);
        return Voices.builder()
                .setGlobalProjects(globalProjects)
                .setLocalProjects(localProjects)
                .setInhabitant(voteTokenVerificationRepository.getByValue(token).get().getInhabitant())
                .build();
    }

    private void blockInhabitantByTokenValueAndDeleteToken(String value) {
        voteTokenVerificationRepository.getByValue(value).get().getInhabitant().setEnabled(false);
        voteTokenVerificationRepository.deleteByValue(value);
    }

    private boolean checkToken(String token) {
        return voteTokenVerificationRepository.getByValue(token).isPresent() ? true : false;
    }

    private boolean validateQuantityVote(List<Long> idsOfGlobalProject, List<Long> idsOfLocalProjects) {
        boolean checkIdsOfGlobalProject = idsOfGlobalProject.size() <= MAX_VOTES_OF_GLOBAL_PROJECT && idsOfGlobalProject.size() >= 0 ? true : false;
        boolean checkIdsOfLocalProject = idsOfLocalProjects.size() <= MAX_VOTES_OF_GLOBAL_PROJECT && idsOfGlobalProject.size() >= 0 ? true : false;
        return checkIdsOfGlobalProject && checkIdsOfLocalProject ? true : false;
    }
}

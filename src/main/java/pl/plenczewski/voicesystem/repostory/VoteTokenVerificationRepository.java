package pl.plenczewski.voicesystem.repostory;

import jdk.nashorn.internal.parser.Token;
import lombok.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.plenczewski.voicesystem.model.VoteTokenVerification;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteTokenVerificationRepository extends JpaRepository<VoteTokenVerification, Long> {

    List<VoteTokenVerification> findAllByInhabitant_Id(Long id);
    void deleteAllByInhabitant_Id(Long id);
    Optional<VoteTokenVerification> getByValue(String value);
    void deleteByValue(String token);
}

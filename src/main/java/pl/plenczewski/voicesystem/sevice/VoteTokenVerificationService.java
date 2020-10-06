package pl.plenczewski.voicesystem.sevice;

import pl.plenczewski.voicesystem.model.Inhabitant;
import pl.plenczewski.voicesystem.model.VoteTokenVerification;

public interface VoteTokenVerificationService {
    VoteTokenVerification generateVoteVerificationToken(Inhabitant inhabitant);

}

package pl.plenczewski.voicesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.plenczewski.voicesystem.model.Inhabitant;
import pl.plenczewski.voicesystem.model.VoteTokenVerification;
import pl.plenczewski.voicesystem.repostory.VoteTokenVerificationRepository;
import pl.plenczewski.voicesystem.sevice.VoteTokenVerificationService;

@RestController
public class VoteTokenController {

    private VoteTokenVerificationService voteTokenVerificationService;

    @Autowired
    public VoteTokenController(VoteTokenVerificationService voteTokenVerificationService) {
        this.voteTokenVerificationService = voteTokenVerificationService;
    }

    @CrossOrigin
    @PostMapping("/token")
    public VoteTokenVerification generateVoteTokenVerification(@RequestBody Inhabitant inhabitant){
        return voteTokenVerificationService.generateVoteVerificationToken(inhabitant);
    }

}

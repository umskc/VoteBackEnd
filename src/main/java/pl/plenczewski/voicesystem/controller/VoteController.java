package pl.plenczewski.voicesystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.plenczewski.voicesystem.model.*;
import pl.plenczewski.voicesystem.repostory.GlobalProjectRepository;
import pl.plenczewski.voicesystem.sevice.VoiceMainService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class VoteController {

    private VoiceMainService voiceMainService;

    @Autowired
    public VoteController(VoiceMainService voiceMainService) {
        this.voiceMainService = voiceMainService;
    }

    @PostMapping("/voice/vote")
    public void addOneVoice(@RequestBody VoteRequest voteRequest){
        voiceMainService.processOneVoice(voteRequest.getIdsOfGlobalprojects(), voteRequest.getIdsOfLocalprojects(), voteRequest.getToken());
    }

}

package com.project.appz.controller;

import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.entities.Poll;
import com.project.appz.service.PollManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poll")
public class PollController {

    private PollManager pollManager;

    public PollController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @GetMapping("/poll/{id}")
    public @ResponseBody Poll getPollForUserById(@PathVariable long id, @RequestParam(name = "userId") long userId) {
        return pollManager.findPollById(id, userId);
    }

    @PostMapping("/response")
    public ResponseEntity<Void> submitResponse(@RequestBody ResponseDto responseDto) {
        pollManager.savePollResults(responseDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
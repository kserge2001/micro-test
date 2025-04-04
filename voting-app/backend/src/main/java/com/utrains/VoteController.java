package com.utrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class VoteController {
    @Autowired
    private VoteRepository voteRepository;

    @PostMapping("/vote")
    public ResponseEntity<?> submitVote(@RequestBody Vote vote) {
        if (voteRepository.existsById(vote.getName())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("User " + vote.getName() + " has already voted."));
        }
        voteRepository.save(vote);
        return ResponseEntity.ok(new SuccessResponse("Vote recorded"));
    }
}

class ErrorResponse {
    private String error;
    public ErrorResponse(String error) { this.error = error; }
    public String getError() { return error; }
}

class SuccessResponse {
    private String message;
    public SuccessResponse(String message) { this.message = message; }
    public String getMessage() { return message; }
}
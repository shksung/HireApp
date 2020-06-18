package com.ezhire.controller;

import com.ezhire.dto.EzHireResumeDTO;
import com.ezhire.service.IEzHireEndUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
@CrossOrigin
public class EzHireEndUserController {

    @Autowired
    IEzHireEndUserService endUserService;

    @PostMapping(value="/resume/submit/{userId}")
    public ResponseEntity<?> submitResume(@RequestBody EzHireResumeDTO resumeDTO, @PathVariable Integer userId) {
        return new ResponseEntity<>(endUserService.submitResume(resumeDTO, userId), HttpStatus.OK);
    }

    @GetMapping(value = "/job/{jobId}/{userId}")
    public ResponseEntity<?> submitResumeForJob(@PathVariable Integer jobId, @PathVariable Integer userId) {
        endUserService.submitResumeForJob(jobId, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/job/fetch/{userId}")
    public ResponseEntity<?> fetchAppliedJobs(@PathVariable Integer userId) {
        return new ResponseEntity<>(endUserService.fetchAppliedJobs(userId), HttpStatus.OK);
    }
}

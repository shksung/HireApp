package com.ezhire.controller;

import com.ezhire.dto.EzHireJobDTO;
import com.ezhire.service.IEzHireAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EzHireAdminController {

    @Autowired
    private IEzHireAdminService service;

    @GetMapping(value="/job")
    public ResponseEntity<?> fetchAllJobs(){
        return new ResponseEntity<>(service.fetchAllJobs(), HttpStatus.OK);
    }

    @PostMapping(value="/job/post")
    public ResponseEntity<?> postJob(@RequestBody EzHireJobDTO jobDTO) {
        return new ResponseEntity<>(service.postJob(jobDTO), HttpStatus.OK);
    }

    @PutMapping(value="/job/edit")
    public ResponseEntity<?> editJob(@RequestBody EzHireJobDTO jobDTO) {
            return new ResponseEntity<>(service.editJob(jobDTO), HttpStatus.OK);
    }

    @GetMapping(value="/job/delete/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable Integer id) {
            service.deleteJob(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }
}

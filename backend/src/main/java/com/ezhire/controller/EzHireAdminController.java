package com.ezhire.controller;

import com.ezhire.dto.EzHireJobDTO;
import com.ezhire.dto.EzHireJobStatusInfoDTO;
import com.ezhire.entity.JobStatusInfo;
import com.ezhire.service.IEzHireAdminService;
import com.sun.tools.internal.ws.processor.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/admin/job")
@CrossOrigin
public class EzHireAdminController {

    @Autowired
    private IEzHireAdminService service;

    @GetMapping
    public ResponseEntity<?> fetchAllJobs(){
        return new ResponseEntity<>(service.fetchAllJobs(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postJob(@RequestBody EzHireJobDTO jobDTO) {
        return new ResponseEntity<>(service.postJob(jobDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> editJob(@RequestBody EzHireJobDTO jobDTO) {
            service.editJob(jobDTO);
            return new ResponseEntity<>(service.fetchAllJobs(), HttpStatus.OK);
    }

    @GetMapping(value="/delete/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable Integer id) {
            service.deleteJob(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/update-listing/{statusID}")
    public ResponseEntity<?> updateJobCandidateStatus(@RequestBody EzHireJobStatusInfoDTO statusInfoDTO) {
        return new ResponseEntity<>(service.updateJobCandidateStatus(statusInfoDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/candidates")
    public ResponseEntity<?> fetchCandidateListings(){
        return new ResponseEntity<>(service.fetchStatusInfo(), HttpStatus.OK);
    }

}

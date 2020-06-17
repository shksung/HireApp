package com.ezhire.controller;

import com.ezhire.dto.EzHireResumeDTO;
import com.ezhire.service.IEzHireEndUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return null;
    }
}

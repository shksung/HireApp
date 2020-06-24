package com.ezhire.controller;

import com.ezhire.dto.EzHireUserDTO;
import com.ezhire.service.IEzHireLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/login")
@CrossOrigin
public class EzHireLoginController {

    @Autowired
    IEzHireLoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody  EzHireUserDTO userDTO) {
        return new ResponseEntity<>(loginService.login(userDTO), HttpStatus.OK);
    }
}

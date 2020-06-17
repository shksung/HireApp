package com.ezhire.dto;

import com.ezhire.entity.Job;
import com.ezhire.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EzHireResumeDTO {
    private Integer id;

    private String vendor;

    private String vendorContact;

    private String vendorEmail;

    private Date submissionDate;

    private String experience;

    private User resumeUser;

    private Set<Job> jobs;
}

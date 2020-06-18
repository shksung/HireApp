package com.ezhire.service;

import com.ezhire.dto.EzHireJobDTO;
import com.ezhire.dto.EzHireResumeDTO;

import java.util.List;

public interface IEzHireEndUserService {
    EzHireResumeDTO submitResume(EzHireResumeDTO resumeDTO, Integer userId);
    void submitResumeForJob(Integer jobId, Integer userId);
    List<EzHireJobDTO> fetchAppliedJobs(Integer userId);
}

package com.ezhire.service;

import com.ezhire.dto.EzHireResumeDTO;

public interface IEzHireEndUserService {
    EzHireResumeDTO submitResume(EzHireResumeDTO resumeDTO, Integer userId);
}

package com.ezhire.service;

import com.ezhire.dto.EzHireResumeDTO;
import com.ezhire.entity.Resume;
import com.ezhire.entity.User;
import com.ezhire.repository.IEzHireResumeRepo;
import com.ezhire.repository.IEzHireUserRepo;
import com.ezhire.util.EzHireObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class EzHireEndUserService implements  IEzHireEndUserService {

    private IEzHireUserRepo userRepo;
    private IEzHireResumeRepo resumeRepo;

    @Autowired
    public EzHireEndUserService(IEzHireUserRepo userRepo, IEzHireResumeRepo resumeRepo) {
        this.userRepo = userRepo;
        this.resumeRepo = resumeRepo;
    }

    @Override
    public EzHireResumeDTO submitResume(EzHireResumeDTO resumeDTO, Integer userId) {
        Resume resume = EzHireObjectMapper.modelMapper.map(resumeDTO, Resume.class);
        User user = userRepo.getOne(userId);
        resume.setResumeUser(user);
        return EzHireObjectMapper.modelMapper.map(resumeRepo.saveAndFlush(resume), EzHireResumeDTO.class);
    }
}

package com.ezhire.service;

import com.ezhire.dto.EzHireJobDTO;
import com.ezhire.dto.EzHireResumeDTO;
import com.ezhire.entity.Job;
import com.ezhire.entity.JobStatusInfo;
import com.ezhire.entity.Resume;
import com.ezhire.entity.User;
import com.ezhire.repository.IEzHireJobRepo;
import com.ezhire.repository.IEzHireJobStatusInfoRepo;
import com.ezhire.repository.IEzHireResumeRepo;
import com.ezhire.repository.IEzHireUserRepo;
import com.ezhire.util.EzHireObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EzHireEndUserService implements  IEzHireEndUserService {

    private IEzHireUserRepo userRepo;
    private IEzHireResumeRepo resumeRepo;
    private IEzHireJobRepo jobRepo;
    private IEzHireJobStatusInfoRepo infoRepo;

    @Autowired
    public EzHireEndUserService(IEzHireUserRepo userRepo, IEzHireResumeRepo resumeRepo, IEzHireJobRepo jobRepo, IEzHireJobStatusInfoRepo infoRepo) {
        this.userRepo = userRepo;
        this.resumeRepo = resumeRepo;
        this.jobRepo = jobRepo;
        this.infoRepo = infoRepo;
    }

    @Override
    public EzHireResumeDTO submitResume(EzHireResumeDTO resumeDTO, Integer userId) {
        Resume resume = EzHireObjectMapper.modelMapper.map(resumeDTO, Resume.class);
        User user = userRepo.getOne(userId);
        resume.setResumeUser(user);
        return EzHireObjectMapper.modelMapper.map(resumeRepo.saveAndFlush(resume), EzHireResumeDTO.class);
    }

    @Override
    public void submitResumeForJob(Integer jobId, Integer userId) {
        User user = userRepo.getOne(userId);
        Job job = jobRepo.getOne(jobId);
        JobStatusInfo statusInfo = new JobStatusInfo();
        statusInfo.setJobUser(user);
        statusInfo.setJob(job);
        if(user.getResume() != null) {
            job.getResumes().add(user.getResume());
            jobRepo.save(job);
            infoRepo.save(statusInfo);
        }
    }

    @Override
    public List<EzHireJobDTO> fetchAppliedJobs(Integer userId) {
        User user = userRepo.getOne(userId);
        return EzHireObjectMapper.entityListToDTOList(user.getResume().getJobs(), EzHireJobDTO.class);
    }

    @Override
    public EzHireResumeDTO fetchResume(Integer userId) {
        User user = userRepo.getOne(userId);
        if(user.getResume() != null) {
            return EzHireObjectMapper.modelMapper.map(user.getResume(), EzHireResumeDTO.class);
        }
        return null;
    }
}

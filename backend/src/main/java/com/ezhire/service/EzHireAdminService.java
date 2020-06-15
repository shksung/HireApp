package com.ezhire.service;

import com.ezhire.dto.EzHireJobDTO;
import com.ezhire.entity.Job;
import com.ezhire.repository.IEzHireJobRepo;
import com.ezhire.util.EzHireObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EzHireAdminService implements IEzHireAdminService {

    private IEzHireJobRepo jobRepo;

    @Autowired
    public EzHireAdminService(IEzHireJobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    @Override
    public EzHireJobDTO postJob(EzHireJobDTO jobDTO) {
        Job jobEntity = EzHireObjectMapper.modelMapper.map(jobDTO,Job.class);
        return EzHireObjectMapper.modelMapper.map(jobRepo.saveAndFlush(jobEntity), EzHireJobDTO.class);
    }

    @Override
    public List<EzHireJobDTO> fetchAllJobs() {
        List<Job> jobs = jobRepo.findAll();
        return EzHireObjectMapper.entityListToDTOList(jobs, EzHireJobDTO.class);
    }

    @Override
    public EzHireJobDTO editJob(EzHireJobDTO jobDTO) {
        Job job = jobRepo.getOne(jobDTO.getId());
        job.setDescription(jobDTO.getDescription());
        job.setMaxWage(jobDTO.getMaxWage());
        job.setMinWage(jobDTO.getMinWage());
        job.setTitle(jobDTO.getTitle());
        return EzHireObjectMapper.modelMapper.map(jobRepo.saveAndFlush(job), EzHireJobDTO.class);
    }

    @Override
    public List<EzHireJobDTO> deleteJob(Integer id) {
        jobRepo.deleteById(id);
        return fetchAllJobs();
    }
}

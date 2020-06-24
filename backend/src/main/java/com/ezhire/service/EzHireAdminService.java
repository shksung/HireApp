package com.ezhire.service;

import com.ezhire.dto.EzHireJobDTO;
import com.ezhire.dto.EzHireJobStatusInfoDTO;
import com.ezhire.entity.Job;
import com.ezhire.entity.JobStatusInfo;
import com.ezhire.repository.IEzHireJobRepo;
import com.ezhire.repository.IEzHireJobStatusInfoRepo;
import com.ezhire.util.EzHireObjectMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EzHireAdminService implements IEzHireAdminService {

    private IEzHireJobRepo jobRepo;
    private IEzHireJobStatusInfoRepo jobStatusInfoRepo;

    @Autowired
    public EzHireAdminService(IEzHireJobRepo jobRepo, IEzHireJobStatusInfoRepo jobStatusInfoRepo) {
        this.jobRepo = jobRepo;
        this.jobStatusInfoRepo = jobStatusInfoRepo;
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
        return EzHireObjectMapper.modelMapper.map(jobRepo.save(job), EzHireJobDTO.class);
    }

    @Override
    public List<EzHireJobDTO> deleteJob(Integer id) {
        jobRepo.deleteById(id);
        return fetchAllJobs();
    }

    @Override
    public EzHireJobStatusInfoDTO updateJobCandidateStatus(EzHireJobStatusInfoDTO statusInfoDTO) {
        JobStatusInfo jobStatusInfo = jobStatusInfoRepo.getOne(statusInfoDTO.getId());
        EzHireObjectMapper.dtoToJobStatusInfo(statusInfoDTO, jobStatusInfo);
        return EzHireObjectMapper.modelMapper.map(jobStatusInfoRepo.saveAndFlush(jobStatusInfo), EzHireJobStatusInfoDTO.class);
    }

    @Override
    public List<EzHireJobStatusInfoDTO> fetchStatusInfo() {
        EzHireObjectMapper.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return EzHireObjectMapper.entityListToDTOList(jobStatusInfoRepo.findAll(), EzHireJobStatusInfoDTO.class);
    }
}

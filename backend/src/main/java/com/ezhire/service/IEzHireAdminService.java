package com.ezhire.service;

import com.ezhire.dto.EzHireJobDTO;

import java.util.List;

public interface IEzHireAdminService {
    EzHireJobDTO postJob(EzHireJobDTO jobDTO);
    List<EzHireJobDTO> fetchAllJobs();
    EzHireJobDTO editJob(EzHireJobDTO jobDTO);
    List<EzHireJobDTO> deleteJob(Integer id);
}

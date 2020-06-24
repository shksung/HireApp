package com.ezhire.repository;

import com.ezhire.entity.JobStatusInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEzHireJobStatusInfoRepo extends JpaRepository<JobStatusInfo, Integer> {
}

package com.ezhire.repository;

import com.ezhire.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEzHireJobRepo extends JpaRepository<Job, Integer> {
}

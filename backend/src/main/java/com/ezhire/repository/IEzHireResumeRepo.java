package com.ezhire.repository;

import com.ezhire.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEzHireResumeRepo extends JpaRepository<Resume, Integer> {
}

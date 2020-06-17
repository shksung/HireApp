package com.ezhire.repository;

import com.ezhire.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEzHireResumeRepo extends JpaRepository<Resume, Integer> {
}

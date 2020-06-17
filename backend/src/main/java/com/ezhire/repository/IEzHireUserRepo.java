package com.ezhire.repository;

import com.ezhire.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEzHireUserRepo extends JpaRepository<User, Integer> {
}

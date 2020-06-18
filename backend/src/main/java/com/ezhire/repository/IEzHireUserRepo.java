package com.ezhire.repository;

import com.ezhire.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEzHireUserRepo extends JpaRepository<User, Integer> {
}

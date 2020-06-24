package com.ezhire.repository;

import com.ezhire.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEzHireUserRepo extends JpaRepository<User, Integer> {
    @Query(value = "select u from User u where u.userName = :userName and u.passWord = :passWord ")
    public User login(String userName, String passWord);
}

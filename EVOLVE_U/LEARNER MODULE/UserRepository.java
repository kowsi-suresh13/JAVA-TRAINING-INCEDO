package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserBean, Integer> {
    UserBean findByEmailId(String emailId);
    UserBean findByUserIdAndPassword(Integer userId, String password);
    boolean existsByUserId(Integer userId);
    UserBean findByUserId(Integer userId);
    void deleteById(Integer userId);
}

package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM insuranceDB.user where email = :email AND password = :password", nativeQuery = true)
    User findByEmailIdAndPassword(String email, String password);
}

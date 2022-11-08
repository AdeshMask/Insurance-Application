package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM insuranceDB.user where email = :email AND password = :password", nativeQuery = true)
    User findByEmailIdAndPassword(String email, String password);

    @Query(value = "Select * from insuranceDB.user where date1= :date1 and date2=:date2",nativeQuery=true)
    List<User> findByDate(String date1, String date2);

    @Query(value="Select * from insuranceDB.user where health_condition = :healthcondition",nativeQuery = true)
    List<User> findByHealthCondition(String healthcondition);

    @Query(value="Select * from insuranceDB.user where vehicledata = :vehicledata",nativeQuery = true)
    List<User> findByVehicleData(String vehicledata);

    @Query(value = "select * from insuranceDB.user where full_name = :userName", nativeQuery = true)
    User findByName(String userName);


}

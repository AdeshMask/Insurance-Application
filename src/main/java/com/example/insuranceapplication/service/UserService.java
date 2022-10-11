package com.example.insuranceapplication.service;

import com.example.insuranceapplication.dto.LoginDto;
import com.example.insuranceapplication.dto.UserDTO;
import com.example.insuranceapplication.exceptionHandling.InsuranceExceptionHandler;
import com.example.insuranceapplication.model.User;
import com.example.insuranceapplication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepo userRepo;
    @Override
    public Object registerUser(UserDTO userDTO) {
        User user = new User(userDTO);
        return userRepo.save(user);
    }

    @Override
    public Object showAll() {
        return userRepo.findAll();
    }

    @Override
    public Object findById(Long id) {
       return userRepo.findById(id).orElseThrow(() -> new InsuranceExceptionHandler("User  with id " + id + " does not exist in database..!"));
    }

    @Override
    public Object update(Long id, UserDTO userDTO) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()){
            User newUser = new User(id, userDTO);
            User user1 = userRepo.save(newUser);
            return user1;
        }
        throw (new InsuranceExceptionHandler("User Not Found"));
    }

    @Override
    public String remove(Long id) {
        userRepo.deleteById(id);
        return "Record Deleted Successfully...";
    }

    @Override
    public Object login(LoginDto loginDto) {
        User user = userRepo.findByEmailIdAndPassword(loginDto.email, loginDto.password);
        return user;
    }
}

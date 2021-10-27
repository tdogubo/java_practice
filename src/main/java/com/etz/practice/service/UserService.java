package com.etz.practice.service;

import com.etz.practice.model.UserModel;
import com.etz.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserModel> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(UserModel user) {
        Optional<UserModel> userByEmail= userRepository.findUserModelByEmail(user.getEmail());
        if(userByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException("user with id:"+userId+" does not exist");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId,
                           String firstName,
                           String lastName){
        Optional<UserModel> user = userRepository.findById(userId);
        if(firstName != null &&
                Objects.equals(user.get().getFirstName(), firstName)){
        }
        user.get().setFirstName(firstName);

        if(lastName != null &&
                Objects.equals(user.get().getLastName(), lastName)){
        }
        user.get().setLastName(lastName);





    }
}

package com.varejo360.backend.service;

import com.varejo360.backend.dto.UserDto;
import com.varejo360.backend.model.User;
import com.varejo360.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private  final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(final UserDto userData){

        final User user = new User(userData.getName(), userData.getEmail(), userData.getPassword());

        return userRepository.save(user);
    }

    public List<User> readUsers() {
        return userRepository.findAll();
    }

    //(throws Exception) isso é necessário pelo "new Exception
    public User retrieveUser(final long id) throws Exception {

        //esse tipo de tratamento de erro fecha o app, vamos modifica-lo
        return userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));

    }

    public User updateUser(final UserDto userData, final long id) throws Exception {

        final User foundUser = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));

        foundUser.setName(userData.getName());
        foundUser.setEmail(userData.getEmail());
        foundUser.setPassword(userData.getPassword());

        return userRepository.save(foundUser);

    }

    public void deleteUser(final long id) throws Exception {

        final User foundUser = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));

        userRepository.delete(foundUser);

    }
}

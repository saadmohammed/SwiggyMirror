package com.example.SwiggyMirror.service;

import com.example.SwiggyMirror.exception.ResourceNotFoundException;
import com.example.SwiggyMirror.model.User;
import com.example.SwiggyMirror.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> findByPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public void create(User food) {
        userRepository.save(food);
    }

    public User updateUser(User user, Integer userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ", "id ", user));
        return userRepository.save(user);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

}

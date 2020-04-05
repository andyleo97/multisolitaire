package com.andyleo.multisolitaire.Services;

import com.andyleo.multisolitaire.Domain.User;
import com.andyleo.multisolitaire.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUserService(User user){
        User user1 = userRepository.save(user);
        return user1;
    }

}

package com.andyleo.multisolitaire.Services;

import com.andyleo.multisolitaire.Domain.User;
import com.andyleo.multisolitaire.Repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {



    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUserService(User user){
        User saved = userRepository.save(user);
        log.debug("Saved User: " + saved.getId());
        return saved;
    }

    public User getUserService(User user){
        return userRepository.findUserByEmail(user.getEmail());
    }
}

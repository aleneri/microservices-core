package com.nerisa.hroauth.services;

import com.nerisa.hroauth.entities.User;
import com.nerisa.hroauth.feignclients.UserFeingClient;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeingClient userFeingClient;

    public User findByEmail(String email){
       User user = userFeingClient.findByEmail(email).getBody();
       if(user == null){
           logger.info("Email not Found " + email);
           throw new IllegalArgumentException("Email not found");
       }
       logger.info("Email Found " + email);
       return user;
    }
}

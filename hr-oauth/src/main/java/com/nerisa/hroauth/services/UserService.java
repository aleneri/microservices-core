package com.nerisa.hroauth.services;

import com.nerisa.hroauth.entities.User;
import com.nerisa.hroauth.feignclients.UserFeingClient;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UserService implements UserDetailsService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeingClient userFeingClient;

    public User findByEmail(String email){
        return (User) this.loadUserByUsername(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userFeingClient.findByEmail(email).getBody();
        if(user == null){
            logger.info("Email not Found " + email);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("Email Found " + email);
        return user;
    }
}

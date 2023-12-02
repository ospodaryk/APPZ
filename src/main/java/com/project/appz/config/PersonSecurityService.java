package com.project.appz.config;

import com.project.appz.entities.User;
import com.project.appz.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("securityService")
public class PersonSecurityService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(PersonSecurityService.class);

    private final UserRepository userRepository;
    private Authentication authentication;

    @Autowired
    public PersonSecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with this email does not exists");
        }
        return new PersonSecurity(user);
    }


}

package com.project.appz.config.security;

import com.project.appz.models.entities.User;
import com.project.appz.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class UserSecurityService implements UserDetailsService {

    private UserRepository repository;


    public UserSecurityService(UserRepository repository) {
        this.repository = repository;
    }

    public User getByLogin(String login) {
        return repository.findAll().stream()
                .filter(user -> login.equals(user.getEmail()))
                .findFirst()
                .orElse(null);
    }

    public List<User> getAll() {
        return repository.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User u = getByLogin(login);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
        return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(), true, true, true, true, new HashSet<>());
    }
}

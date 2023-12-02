package com.project.appz.security;


import com.project.appz.entities.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class Security implements UserDetails {
    private static final Logger logger = LoggerFactory.getLogger(Security.class);

    private long id;
    private String name;
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;


    public Security(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getEmail();
        this.password = user.getPassword();
        this.authorities = List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() {
        return true;
    }
}


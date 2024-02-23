package com.xersky.springblog.service;

import com.xersky.springblog.entity.Role;
import com.xersky.springblog.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsOverrideService implements UserDetailsService {

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userService.findOneByUsername(username);
        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }

        User user = optionalUser.get();
        user.setRole(Role.USER);

        return user;
    }
}

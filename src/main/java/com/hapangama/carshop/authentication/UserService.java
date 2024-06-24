package com.hapangama.carshop.authentication;

import com.hapangama.carshop.repository.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

//@Service
//@AllArgsConstructor
//public class UserService implements UserDetailsService {
//    private final UserMapper mapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        UserDetails user = mapper.find(username);
//        if (user == null) throw new RuntimeException();
//        return new org.springframework.security.core.userdetails.User(
//                user.getUsername(),
//                user.getPassword(), user.getAuthorities());
//    }
//
//
//}

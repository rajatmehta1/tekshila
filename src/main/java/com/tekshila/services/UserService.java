package com.tekshila.services;

import com.tekshila.dtos.User;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.tekshila.dao.UserRepository;
import com.tekshila.domain.TekUser;

import java.util.Arrays;
import java.util.List;

/*
 * This class contains the methods for pulling information about the users
 *
 * This gets passed to the authentication service
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User loadUserByUsername(String username) throws Exception {
        TekUser tekshilaUsr = userRepository.findByEmail(username);

        if(null == tekshilaUsr) {
            throw new Exception("User not found");
        }
      return new User();
    }

}

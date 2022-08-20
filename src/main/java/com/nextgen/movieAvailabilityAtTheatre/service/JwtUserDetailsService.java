package com.nextgen.movieAvailabilityAtTheatre.service;

import com.nextgen.movieAvailabilityAtTheatre.model.UserCredentials;
import com.nextgen.movieAvailabilityAtTheatre.respository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentials> userCredentials = userDetailsRepository.findAll().stream().filter(t->t.getUsername().equals(username)).findFirst();
        if(userCredentials.isPresent())
        {
            return new User(userCredentials.get().getUsername(), userCredentials.get().getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}

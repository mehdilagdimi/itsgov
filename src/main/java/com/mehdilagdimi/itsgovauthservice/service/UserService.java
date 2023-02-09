package com.mehdilagdimi.itsgovauthservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.NoSuchElementException;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    @Qualifier("entry-point-url")
    private String entryUrl;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = restTemplate.getForObject(entryUrl+"/employee?email="+email, U)
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found......"));
    }


    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }
    public Employer getEmployer(Long id){
        return employerRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }
}

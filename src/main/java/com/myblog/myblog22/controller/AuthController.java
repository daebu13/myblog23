package com.myblog.myblog22.controller;

import com.myblog.myblog22.entity.Role;
import com.myblog.myblog22.entity.User;
import com.myblog.myblog22.payload.SignUpDto;
import com.myblog.myblog22.repository.RoleRepository;
import com.myblog.myblog22.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){
        if(userRepository.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("username already taken.Try with different one", HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("email already registered .Try with different email",HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        Role roles = roleRepository.findByName(signUpDto.getRoleType()).get();
        Set<Role> convertRoleToSet= new HashSet<>();
        convertRoleToSet.add(roles);
        user.setRoles(convertRoleToSet);

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully",HttpStatus.OK);
    }
}

package com.acapa.ecoturismo.controllers;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acapa.ecoturismo.repository.UserRepository;
import com.acapa.ecoturismo.repository.RolRepository;
import com.acapa.ecoturismo.dtos.LoginDTO;
import com.acapa.ecoturismo.dtos.RegisterDTO;
import com.acapa.ecoturismo.entitys.Rol;
import com.acapa.ecoturismo.entitys.User;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
   public ResponseEntity<String> authenticationUser(@RequestBody LoginDTO loginDTO) {
      Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
      SecurityContextHolder.getContext().setAuthentication(authentication);

      return  new  ResponseEntity<>("init sucesfully!!!",HttpStatus.OK);

   }

   @PostMapping("/register")
   public ResponseEntity<?> registerUser(@RequestBody RegisterDTO registerDTO) {
      if (userRepository.existsByUsername(registerDTO.getUsername())) {
         return new ResponseEntity<>("this username alreay exist", HttpStatus.BAD_REQUEST);
      }
      if (userRepository.existsByEmail(registerDTO.getEmail())) {
         return new ResponseEntity<>("this email alreay exist", HttpStatus.BAD_REQUEST);
      }
      User user = new User();
      user.setName(registerDTO.getName());
      user.setUsername(registerDTO.getUsername());
      user.setEmail(registerDTO.getEmail());
      user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

      Rol roles = rolRepository.findByName("ROLE_USER").get();
      user.setRoles(Collections.singleton(roles));

      userRepository.save(user);
      return new ResponseEntity<>("User Register Successfully", HttpStatus.OK);
   }
}

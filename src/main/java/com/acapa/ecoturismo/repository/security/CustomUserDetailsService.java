package com.acapa.ecoturismo.repository.security;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acapa.ecoturismo.entitys.Rol;
import com.acapa.ecoturismo.entitys.User;
import com.acapa.ecoturismo.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("not Found with username or email" + usernameOrEmail));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                mapearRoles(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearRoles(Set<Rol> roles) {
        return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getName())).collect(Collectors.toList());
    }
}
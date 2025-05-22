package com.example.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.crm.entity.Operatore;
import com.example.crm.repository.OperatoreRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private OperatoreRepository operatorerepository;

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
Operatore operatore = operatorerepository.findByUsername(username);
if (operatore == null) {
throw new UsernameNotFoundException("Utente non trovato");
}


return
User.withDefaultPasswordEncoder()
.username(operatore.getUsername())
.password(operatore.getPassword())
.roles(operatore.getRuolo())
.build();
}
}






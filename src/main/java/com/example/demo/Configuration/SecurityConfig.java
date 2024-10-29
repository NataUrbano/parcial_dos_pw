package com.example.demo.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration

public class SecurityConfig {
    @Autowired
    private UsuarioDetailsService usuarioDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/rector/**").hasAuthority("RECTOR")
                .requestMatchers("/docente/**").hasAuthority("DOCENTE")
                .requestMatchers("/estudiante/**").hasAuthority("ESTUDIANTE")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();
    }
}

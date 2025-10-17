package com.docubyte.test.app02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                        registry->{
                            registry.requestMatchers("/welcome").permitAll();
                            registry.requestMatchers("/admin").hasRole("ADMIN");
                            registry.requestMatchers("/emp").hasRole("EMPLOYEE");
                            registry.requestMatchers("/std").hasAnyRole("STUDENT","ADMIN");
                        }
                )
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults())
                .build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("DURGA")
                .password("{noop}durga@123")
                .roles("ADMIN")
                .build();


        UserDetails emp = User.withUsername("ANIL")
                .password("{noop}anil@123")
                .roles("EMPLOYEE")
                .build();


        UserDetails std = User.withUsername("RAMANA")
                .password("{noop}ramana@123")
                .roles("STUDENT")
                .build();


        return new InMemoryUserDetailsManager(admin, emp, std);
    }
}
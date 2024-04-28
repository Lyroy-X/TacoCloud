package com.example.tacocloud.web;

import com.example.tacocloud.data.UserRepository;
import com.example.tacocloud.entity.User;
import com.example.tacocloud.security.UserDetailsService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableAutoConfiguration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
          User user = userRepository.findByUsername(username);
          if (user != null) return user;
          else throw new UsernameNotFoundException("User " + username + " not found!");
        };
    }
}
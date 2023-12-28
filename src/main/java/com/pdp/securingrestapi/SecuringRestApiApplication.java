package com.pdp.securingrestapi;

import com.pdp.securingrestapi.entity.Role;
import com.pdp.securingrestapi.entity.User;
import com.pdp.securingrestapi.repository.RoleRepository;
import com.pdp.securingrestapi.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class SecuringRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecuringRestApiApplication.class, args);
    }

    @Bean
    public ApplicationRunner initializeData(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Role userRole = Role.builder().name("USER").code("USER").build();
            Role managerRole = Role.builder().name("MANAGER").code("MANAGER").build();
            Role adminRole = Role.builder().name("ADMIN").code("ADMIN").build();

            roleRepository.saveAll(Arrays.asList(userRole, managerRole, adminRole));

            User user = User.builder()
                    .username("user")
                    .password(passwordEncoder.encode("user"))
                    .roles(Arrays.asList(userRole))
                    .build();

            User manager = User.builder()
                    .username("manager")
                    .password(passwordEncoder.encode("manager"))
                    .roles(Arrays.asList(managerRole))
                    .build();

            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin"))
                    .roles(Arrays.asList(adminRole))
                    .build();

            userRepository.saveAll(Arrays.asList(user, manager, admin));
        };
    }
}

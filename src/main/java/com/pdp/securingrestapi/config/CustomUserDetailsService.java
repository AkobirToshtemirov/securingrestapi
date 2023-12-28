package com.pdp.securingrestapi.config;

import com.pdp.securingrestapi.entity.Role;
import com.pdp.securingrestapi.entity.User;
import com.pdp.securingrestapi.repository.RoleRepository;
import com.pdp.securingrestapi.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public CustomUserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User authUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));


        fetchUserRolesAndPermissions(authUser);

        return new CustomeUserDetails(authUser);
    }

    private void fetchUserRolesAndPermissions(User authUser) {
        Long userId = authUser.getId();
        List<Role> roles = roleRepository.findAllByUserId(userId);
        authUser.setRoles(roles);
    }
}

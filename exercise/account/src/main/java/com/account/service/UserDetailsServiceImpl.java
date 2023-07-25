package com.account.service;

import com.account.model.AppUser;
import com.account.repository.IUserRepository;
import com.account.repository.IUserRoleRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private IUserRoleRepository userRoleRepository;
    private IUserRepository userRepository;

    public UserDetailsServiceImpl(IUserRoleRepository userRoleRepository,
                                   IUserRepository userRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findUserById(username);
        List<String> roleNames = userRoleRepository.findRoleNameById(username);
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null) {
            for (String roleName : roleNames) {
                GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
                grantList.add(authority);
            }
        }
        UserDetails userDetails = new User(user.getUsername(), user.getPassword(), grantList);
        return userDetails;
    }
}

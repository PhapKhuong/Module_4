package com.blog_security.service.account;

import com.blog_security.model.account.AppRole;
import com.blog_security.model.account.AppUser;
import com.blog_security.model.account.UserRole;
import com.blog_security.repository.account.IRoleRepository;
import com.blog_security.repository.account.IUserRepository;
import com.blog_security.repository.account.IUserRoleRepository;
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
    private IRoleRepository roleRepository;

    public UserDetailsServiceImpl(IUserRoleRepository userRoleRepository,
                                  IUserRepository userRepository,
                                  IRoleRepository roleRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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

    public AppUser findUserById(String username) {
        return userRepository.findUserById(username);
    }

    public List<AppRole> findRoleList() {
        return roleRepository.findAll();
    }

    public void createUser(AppUser user) {
        userRepository.save(user);
    }

    public void createUserRole(int roleId, String username){
        userRoleRepository.createUserRole(roleId, username);
    }

    public AppRole findRoleById(int id){
        return roleRepository.findById(id).orElse(null);
    }

    public void create(UserRole userRole){
        userRoleRepository.save(userRole);
    }
}

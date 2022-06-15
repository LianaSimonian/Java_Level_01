package com.aca.classroom.week15.user.service.version5.security;

import com.aca.classroom.week15.user.service.version5.entity.User;
import com.aca.classroom.week15.user.service.version5.entity.UserRole;
import com.aca.classroom.week15.user.service.version5.service.core.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class DbUserDetailsService implements UserDetailsService {

    private UserService userService;

    public DbUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User dbUser = userService.getByUsername(username);

        List<UserRole> userRoles = dbUser.getUserRoles();
        List<GrantedAuthority> authorities = new ArrayList<>();
        userRoles.forEach(userRole ->
                authorities.add(
                        new SimpleGrantedAuthority(userRole.getType().name())
                ));

        return new org.springframework.security.core.userdetails.User(username, dbUser.getPassword(), authorities);
    }
}
    /*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User dbUser = userService.getByUsername(username);
        List<GrantedAuthority> list = new ArrayList<>();
        List<UserRole> userRoles = dbUser.getUserRoles();
       1 userRoles.forEach(userRole -> list.add(new SimpleGrantedAuthority(userRole.getType().name())));
        return new org.springframework.security.core.userdetails.User(
                username,
                dbUser.getPassword(),
                userRoles);

    }
}


     */

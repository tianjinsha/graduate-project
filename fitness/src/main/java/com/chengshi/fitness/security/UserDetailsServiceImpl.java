package com.chengshi.fitness.security;

import com.chengshi.fitness.model.Manager;
import com.chengshi.fitness.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

/**
 * @description:
 * @author: tian
 * @date: 2018-12-17 14:35
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IManagerService managerService;

    public UserDetailsServiceImpl(IManagerService managerService) {
        this.managerService = managerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Manager manager = managerService.findManagerByName(username);
        if (manager == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(manager.getUsername(), manager.getPassword(), emptyList());
    }
}

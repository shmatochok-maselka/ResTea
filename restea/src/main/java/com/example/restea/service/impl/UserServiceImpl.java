package com.example.restea.service.impl;

import com.example.restea.model.Role;
import com.example.restea.model.User;
import com.example.restea.repository.RoleRepository;
import com.example.restea.repository.UserRepository;
import com.example.restea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Supplier;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByName(name).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public User findUserByEmail(String name) {
        return userRepository.findByEmail(name).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void addRoleToUser(Long id, String roleName) {
        User user = userRepository.findById(id).orElseThrow();
        Role role = roleRepository.findByName(roleName).orElseThrow();
        user.getRoles().add(role);
    }
}

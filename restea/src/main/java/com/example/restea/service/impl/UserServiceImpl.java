package com.example.restea.service.impl;

import com.example.restea.dto.UserCreateDto;
import com.example.restea.dto.UserDataDto;
import com.example.restea.dto.UserDto;
import com.example.restea.exception.NotAllFieldPresentException;
import com.example.restea.exception.UserNotFoundException;
import com.example.restea.model.Role;
import com.example.restea.model.RoleEnum;
import com.example.restea.model.User;
import com.example.restea.repository.RoleRepository;
import com.example.restea.repository.UserRepository;
import com.example.restea.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).get();
        if (user == null) {
            System.out.println("There is no: " + username);
            throw new UsernameNotFoundException("There is no: " + username);
        } else {
            System.out.println("User founded " + user.getName());
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role ->
                authorities.add(new SimpleGrantedAuthority(role.getName().name()))
        );
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public UserDto findUserById(Long id) {
        return new UserDto(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND, "No user with such id")));
    }

    @Override
    public UserDto findUserByName(String name) {
        return new UserDto(userRepository.findByName(name)
                .orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND, "No user with such name")));
    }

    @Override
    public UserDto findUserByEmail(String name) {
        return new UserDto(userRepository.findByEmail(name)
                .orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND, "No user with such email")));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto saveUser(UserCreateDto user) {
        if(user.getPassword() == null || user.getBirthday() == null || user.getName() == null || user.getSurname() == null
                || user.getPatronymic() == null || user.getEmail() == null){
            throw new NotAllFieldPresentException(HttpStatus.BAD_REQUEST, "Not all field present");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user.toUser());
        addRoleToUser(savedUser.getId(), RoleEnum.customer);
        return new UserDto(savedUser);
    }

    @Override
    public UserDto update(UserDataDto userDataDto, Principal principal) {
        User toUpdate = userRepository.findByEmail(principal.getName()).orElseThrow(IllegalArgumentException::new);
        if (userDataDto.getName() != null) {
            toUpdate.setName(userDataDto.getName());
        }
        if (userDataDto.getSurname() != null) {
            toUpdate.setSurname(userDataDto.getSurname());
        }
        if (userDataDto.getBirthday() != null) {
            toUpdate.setBirthday(userDataDto.getBirthday());
        }
        if (userDataDto.getImage() != null) {
            toUpdate.setImage(userDataDto.getImage());
        }
        return new UserDto(userRepository.save(toUpdate));
    }

    @Override
    public void addRoleToUser(Long id, RoleEnum roleEnum) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(HttpStatus.BAD_REQUEST, "No user with such id"));
        Role role = roleRepository.findByName(roleEnum.name()).orElseThrow();
        user.getRoles().add(role);
    }


}

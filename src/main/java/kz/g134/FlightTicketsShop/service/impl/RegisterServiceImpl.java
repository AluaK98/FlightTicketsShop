package kz.g134.FlightTicketsShop.service.impl;

import kz.g134.FlightTicketsShop.dto.request.UserRegisterRequestDTO;
import kz.g134.FlightTicketsShop.entity.Role;
import kz.g134.FlightTicketsShop.exception.PasswordNotMatchException;
import kz.g134.FlightTicketsShop.exception.UsernameAlreadyExistException;
import kz.g134.FlightTicketsShop.mapper.UserMapper;
import kz.g134.FlightTicketsShop.repository.RoleRepository;
import kz.g134.FlightTicketsShop.repository.UserRepository;
import kz.g134.FlightTicketsShop.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.InputMismatchException;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public Void registerUser(UserRegisterRequestDTO request) {
        userRepository.findByUsername(request.getUsername()).ifPresent(user -> {
            throw new UsernameAlreadyExistException("Username already exist" + request.getUsername());
        });
        if (!request.getPassword().equals(request.getRePassword())) {
            throw new PasswordNotMatchException("Passwords do not match");
        }
        var user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Role userRole=roleRepository.findRoleUser();
        user.setRoles(Collections.singletonList(userRole));

        userRepository.save(user);
        return null;
    }
}
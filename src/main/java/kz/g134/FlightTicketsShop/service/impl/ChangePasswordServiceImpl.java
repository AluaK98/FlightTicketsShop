package kz.g134.FlightTicketsShop.service.impl;

import kz.g134.FlightTicketsShop.dto.request.ForgetPasswordDTO;
import kz.g134.FlightTicketsShop.exception.PasswordNotMatchException;
import kz.g134.FlightTicketsShop.exception.UserNotExistsException;
import kz.g134.FlightTicketsShop.repository.UserRepository;
import kz.g134.FlightTicketsShop.service.ChangePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangePasswordServiceImpl implements ChangePasswordService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Void changePassword(ForgetPasswordDTO dto) {
        if (userRepository.findByUsername(dto.getUsername()).isEmpty()) {
            throw new UserNotExistsException("User with username " + dto.getUsername() + " does not exist");
        }
        if(!dto.getNewPassword().equals(dto.getReNewPassword())){
            throw new PasswordNotMatchException("Passwords do not match");
        }
        userRepository.findByUsername(dto.getUsername()).ifPresent(user -> {
            user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
            userRepository.save(user);
        });
        return null;
    }
}

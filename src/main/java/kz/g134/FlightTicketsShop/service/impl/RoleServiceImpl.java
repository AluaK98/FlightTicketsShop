package kz.g134.FlightTicketsShop.service.impl;

import kz.g134.FlightTicketsShop.exception.RoleNotExistsException;
import kz.g134.FlightTicketsShop.exception.UserNotExistsException;
import kz.g134.FlightTicketsShop.repository.RoleRepository;
import kz.g134.FlightTicketsShop.repository.UserRepository;
import kz.g134.FlightTicketsShop.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;


    @Override
    public Void addRole(String username, String roleName) {
        validate(username, roleName);

        var user = userRepository.findByUsername(username).get();
        var role = roleRepository.findRoleByName(roleName).get();
        user.getRoles().add(role);
        userRepository.save(user);
        return null;
    }

    @Override
    public Void removeRole(String username, String roleName) {
        validate(username, roleName);

        var user = userRepository.findByUsername(username).get();
        var role = roleRepository.findRoleByName(roleName).get();
        user.getRoles().remove(role);
        userRepository.save(user);
        return null;
    }

    private void validate(String username, String roleName) {
        if (userRepository.findByUsername(username).isEmpty()) {
            throw new UserNotExistsException("User " + username + " does not exist");
        }

        if (roleRepository.findRoleByName(roleName).isEmpty()) {
            throw new RoleNotExistsException("Role " + roleName + " does not exist");
        }
    }
}


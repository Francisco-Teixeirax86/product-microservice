package francisco.personal.productmicroservice.service;

import francisco.personal.productmicroservice.dto.AuthRequest;
import francisco.personal.productmicroservice.entities.Role;
import francisco.personal.productmicroservice.entities.User;
import francisco.personal.productmicroservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;


    @Transactional
    public User createUser(AuthRequest request) {
        // Encode password
        String encodedPassword = passwordEncoder.encode(request.password());

        // Create user
        User user = new User();
        user.setUsername(request.username());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);

        // Assign default role (e.g., "ROLE_USER")
        Role userRole = roleService.findRoleByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Default role not found!"));
        user.setRoles(Collections.singleton(userRole));

        return userRepository.save(user);
    }
}

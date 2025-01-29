package francisco.personal.productmicroservice.service;

import francisco.personal.productmicroservice.entities.Role;
import francisco.personal.productmicroservice.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Optional<Role> findRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    public Role createRole(String name) {
        Role role = new Role();
        role.setName(name);
        return roleRepository.save(role);
    }
}

package hr.platform.service;

import hr.platform.model.enteties.RoleEntity;
import hr.platform.model.enteties.enums.RoleEnum;
import hr.platform.repository.RoleRepository;
import hr.platform.service.interfaces.RolesService;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl implements RolesService {
    private final RoleRepository roleRepository;

    public RolesServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveRole(RoleEnum role) {
        RoleEntity newRole = new RoleEntity();
        newRole.setRole(role);
        this.roleRepository.save(newRole);
    }

    @Override
    public long getRoles() {
        return this.roleRepository.count();
    }

    @Override
    public RoleEntity findByName(RoleEnum role) {
        return this.roleRepository.findByRole(role);
    }
}

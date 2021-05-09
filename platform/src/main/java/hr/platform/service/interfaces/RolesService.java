package hr.platform.service.interfaces;


import hr.platform.model.enteties.RoleEntity;
import hr.platform.model.enteties.enums.RoleEnum;

public interface RolesService {

    void saveRole(RoleEnum role);

    long getRoles();

    RoleEntity findByName(RoleEnum role);
}

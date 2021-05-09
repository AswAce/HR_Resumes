package hr.platform.service.interfaces;

import hr.platform.model.enteties.UserEntity;

public interface UserService {


    long countUsers();

    void saveAdminUser(UserEntity admin);
}

package hr.platform.service;

import hr.platform.model.enteties.UserEntity;
import hr.platform.repository.UserRepository;
import hr.platform.service.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public long countUsers() {
        return this.userRepository.count();
    }

    @Override
    public void saveAdminUser(UserEntity admin) {
        this.userRepository.save(admin);
    }

}

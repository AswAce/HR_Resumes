package hr.platform.init;

import hr.platform.model.enteties.UserEntity;
import hr.platform.model.enteties.enums.RoleEnum;
import hr.platform.service.interfaces.EmailService;
import hr.platform.service.interfaces.RolesService;
import hr.platform.service.interfaces.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements CommandLineRunner {

    private final RolesService rolesService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public DbInit(RolesService rolesService, UserService userService, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.rolesService = rolesService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Run");
//        this.addRoles();
//        this.addAdmin();
//        this.emailService.sendSimpleMessage("asen_asw@yahoo.com", "Test3", "text3");
    }

    private void addRoles() {
        if (this.rolesService.getRoles() == 0) {
            this.rolesService.saveRole(RoleEnum.ADMIN);
            this.rolesService.saveRole(RoleEnum.USER);
        }
    }

    private void addAdmin() {
        if (this.userService.countUsers() == 0) {
            UserEntity admin = new UserEntity();
            admin.setEmail("adminHr@abv.bg");
            admin.setUsername("HRTeam");
            admin.setFullName("Asen Rangelov");
            admin.setPassword(passwordEncoder.encode("Starwars1!"));
            admin.getRoles().add((this.rolesService.findByName(RoleEnum.ADMIN)));
            admin.getRoles().add((this.rolesService.findByName(RoleEnum.USER)));

            this.userService.saveAdminUser(admin);
        }

    }
}

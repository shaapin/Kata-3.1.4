package web.util;

import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class init implements CommandLineRunner {

    private UserService userService;
    private RoleService roleService;

    public init(UserService userService, RoleService roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Role admin = new Role();
        admin.setRoleName("ROLE_ADMIN");
        roleService.createRole(admin);
        Role user = new Role();
        user.setRoleName("ROLE_USER");
        roleService.createRole(user);

        User userAdmin = new User();
        userAdmin.setUsername("admin");
        userAdmin.setPassword("admin");
        userAdmin.setName("Нурхаят");
        userAdmin.setSurname("Шарипова");
        userAdmin.setAge(24);
        userAdmin.setEmail("admin@mail.ru");
        userService.createUser(userAdmin);
        userAdmin.addRoleToUser(admin);
        userAdmin.addRoleToUser(user);
        userService.updateUser(userAdmin, userAdmin.getId());

        User userUser = new User();
        userUser.setUsername("user");
        userUser.setPassword("user");
        userUser.setName("user");
        userUser.setSurname("user");
        userUser.setAge(25);
        userUser.setEmail("user@mail.ru");
        userService.createUser(userUser);
        userUser.addRoleToUser(user);
        userService.updateUser(userUser, userUser.getId());

    }
}

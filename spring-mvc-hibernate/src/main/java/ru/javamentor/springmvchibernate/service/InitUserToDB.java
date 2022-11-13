package ru.javamentor.springmvchibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.javamentor.springmvchibernate.model.Role;
import ru.javamentor.springmvchibernate.model.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitUserToDB {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public InitUserToDB(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @PostConstruct
    private void initUserToDB() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        List<Role> roleAdminList = new ArrayList<>();
        List<Role> roleUserList = new ArrayList<>();

        roleAdminList.add(roleAdmin);
        roleUserList.add(roleUser);

        User user1 = new User("admin", "admin","admin@gmail.com", roleAdminList);
        User user2 = new User("user", "user", "user@gmail.com", roleUserList);

        userService.saveUser(user1);
        userService.saveUser(user2);
    }
}

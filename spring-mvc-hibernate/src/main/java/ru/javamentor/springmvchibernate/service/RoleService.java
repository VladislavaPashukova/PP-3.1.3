package ru.javamentor.springmvchibernate.service;

import ru.javamentor.springmvchibernate.model.Role;

import java.util.List;

public interface RoleService {
    List<Role>  getAllRole();
    void addRole(Role role);
}

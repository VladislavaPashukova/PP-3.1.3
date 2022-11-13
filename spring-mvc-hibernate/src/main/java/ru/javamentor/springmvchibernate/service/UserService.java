package ru.javamentor.springmvchibernate.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.javamentor.springmvchibernate.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findById (Long id);
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
    User findByUsername (String username);
}

package ru.javamentor.springmvchibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javamentor.springmvchibernate.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}

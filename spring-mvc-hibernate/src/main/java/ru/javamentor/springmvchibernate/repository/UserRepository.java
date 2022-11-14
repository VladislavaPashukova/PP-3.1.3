package ru.javamentor.springmvchibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.javamentor.springmvchibernate.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT c FROM User c JOIN FETCH c.roles WHERE c.username = :username")
    User findByUsername(@Param("username") String username);
}

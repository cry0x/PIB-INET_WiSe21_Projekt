package com.forum.backend.repositories;

import com.forum.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u where u.loginname = ?1")
    User findUserByName(String username);

}

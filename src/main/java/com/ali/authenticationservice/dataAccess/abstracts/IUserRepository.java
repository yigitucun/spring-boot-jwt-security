package com.ali.authenticationservice.dataAccess.abstracts;

import com.ali.authenticationservice.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
    boolean existsById(int id);
    boolean existsByUsername(String username);
}

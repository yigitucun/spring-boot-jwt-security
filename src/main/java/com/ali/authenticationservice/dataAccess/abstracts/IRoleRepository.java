package com.ali.authenticationservice.dataAccess.abstracts;

import com.ali.authenticationservice.entities.concretes.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Integer> {
    boolean existsById(int id);
    boolean existsByRole(String role);


}

package com.codeup.repositories;

import com.codeup.models.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Irby on 2/13/17.
 */

@Repository
public interface RolesRepository extends CrudRepository<UserRole, Long> {

    // SQL -> Structured Query Language
    // HQL -> Hibernate Query Language

    @Query("select ur.role from UserRole ur, User u where u.username=?1 and ur.userId = u.id")
    public List<String> ofUserWith(String username);
}

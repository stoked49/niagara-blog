package com.codeup.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codeup.models.User;
/**
 * Created by Irby on 2/13/17.
 */


@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {
    // select * from user where username = ?
    // automagic
    public User findByUsername(String username);
}

package com.codeup.repositories;

import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Irby on 2/13/17.
 */

@Repository
public interface PostsRepository extends CrudRepository<Post, Long> {

}

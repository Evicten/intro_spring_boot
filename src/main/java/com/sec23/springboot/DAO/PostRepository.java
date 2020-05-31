package com.sec23.springboot.DAO;

import com.sec23.springboot.domain.Post;
import com.sec23.springboot.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}

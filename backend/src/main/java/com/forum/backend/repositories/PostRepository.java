package com.forum.backend.repositories;

import com.forum.backend.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
    @Query("SELECT p from Post p where p.title = ?1")
    Post findPostbyTitle(String title);

    //@Query("SELECT p from Post p")
    //Iterable<Post> getAllPosts();
}
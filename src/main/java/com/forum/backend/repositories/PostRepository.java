package com.forum.backend.repositories;

import com.forum.backend.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    void deleteAllByCreator_Id(Long id);

}

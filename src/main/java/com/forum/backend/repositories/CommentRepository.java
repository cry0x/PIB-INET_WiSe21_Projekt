package com.forum.backend.repositories;

import com.forum.backend.entities.Comment;
import com.forum.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    void deleteAllByCreator_Id(Long id);

}

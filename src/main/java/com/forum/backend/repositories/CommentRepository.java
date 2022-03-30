package com.forum.backend.repositories;

import com.forum.backend.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository  extends JpaRepository<Comment, Long> {
}

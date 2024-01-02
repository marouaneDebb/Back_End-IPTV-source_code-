package com.example.angularback.repository;

import com.example.angularback.model.Comments;
import com.example.angularback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    Optional<Comments> findCommentById(Long id);
    List<Comments> findByMovieID(Long movieID);

}

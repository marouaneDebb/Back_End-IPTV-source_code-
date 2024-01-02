package com.example.angularback.service;

import com.example.angularback.exeptions.UserNotFoundExeption;
import com.example.angularback.model.Comments;
import com.example.angularback.model.User;
import com.example.angularback.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;
    @Autowired

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }
    public Comments addComment(Comments comment){
        return commentsRepository.save(comment);
    }
    public Comments findComment(Long id){
        return commentsRepository.findCommentById(id).orElseThrow(() -> new UserNotFoundExeption("user not found"));
    }
    public List<Comments> findCommentsByMovieID(Long movieID) {
        return commentsRepository.findByMovieID(movieID);
    }
    public List<Comments> findAllComments(){
        return commentsRepository.findAll();
    }

}
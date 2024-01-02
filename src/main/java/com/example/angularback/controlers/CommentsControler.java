package com.example.angularback.controlers;

import com.example.angularback.model.Comments;
import com.example.angularback.service.CommentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/detail")
public class CommentsControler {
    private final CommentsService commentsService;

    public CommentsControler(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping("/comment/{movieID}")
    public ResponseEntity<List<Comments>> getCommentsByMovieID(@PathVariable Long movieID){
        List<Comments> comments = commentsService.findCommentsByMovieID(movieID);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
    @GetMapping("/comment")
    public ResponseEntity<List<Comments>> getComments(){
        List<Comments> comments = commentsService.findAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comments> getComment(@PathVariable Long id){
        Comments comment = commentsService.findComment(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Comments> addComment(@RequestBody Comments comment){
        Comments comment1 = commentsService.addComment(comment);
        return new ResponseEntity<>(comment1, HttpStatus.CREATED);
    }

}

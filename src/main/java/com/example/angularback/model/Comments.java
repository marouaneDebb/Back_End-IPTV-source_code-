package com.example.angularback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity
public class Comments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long movieID;
    private String comment_Text;
    private String comment_Date;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Comments(String comment_Text, String comment_Date, Long movieID,String username) {
        this.movieID=movieID;
        this.comment_Text = comment_Text;
        this.comment_Date = comment_Date;
        this.username=username;
    }

    public Comments() {
    }


    public Long getMovieID() {
        return movieID;
    }

    public void setMovieID(Long movieID) {
        this.movieID = movieID;
    }

    public String getComment_Text() {
        return comment_Text;
    }

    public void setComment_Text(String comment_Text) {
        this.comment_Text = comment_Text;
    }

    public String getComment_Date() {
        return comment_Date;
    }

    public void setComment_Date(String comment_Date) {
        this.comment_Date = comment_Date;
    }

    @Override
    public String toString() {
        return "Comments{" +
                ", movieID='" + id + '\'' +
                ", comment_Text='" + comment_Text + '\'' +
                ", comment_Date='" + comment_Date + '\'' +
                '}';
    }
}

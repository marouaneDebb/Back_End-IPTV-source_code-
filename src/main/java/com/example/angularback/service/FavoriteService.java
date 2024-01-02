package com.example.angularback.service;

import com.example.angularback.model.Comments;
import com.example.angularback.model.Favorite;
import com.example.angularback.repository.FavoriteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class FavoriteService {
    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public Favorite addFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    public Favorite findByMovieIDAndUsername(Long movieID,String username) {
        return favoriteRepository.findByMovieIDAndUsername(movieID,username);
    }

    public void deleteFavoriteByMovieIDAndUsername(Long movieID,String username) {
       favoriteRepository.deleteByMovieIDAndUsername(movieID,username);
    }
    public List<Favorite> findAllFavoriteByUsername(String username){
        return favoriteRepository.findByUsername(username);
    }




    // Add other service methods as needed
}

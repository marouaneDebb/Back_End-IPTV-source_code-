package com.example.angularback.repository;

import com.example.angularback.model.Comments;
import com.example.angularback.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    Favorite findByMovieID(Long movieID);

    void deleteByMovieID(Long movieID);

    Favorite findByMovieIDAndUsername(Long movieID,String username);

    void deleteByMovieIDAndUsername(Long movieID, String username);

    List<Favorite> findByUsername(String username);


    // Add other custom query methods if needed
}

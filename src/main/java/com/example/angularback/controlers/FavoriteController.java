package com.example.angularback.controlers;

import com.example.angularback.model.Comments;
import com.example.angularback.model.Favorite;
import com.example.angularback.service.FavoriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {
    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/add")
    public ResponseEntity<Favorite> addFavorite(@RequestBody Favorite favorite) {
        Favorite addedFavorite = favoriteService.addFavorite(favorite);
        return new ResponseEntity<>(addedFavorite, HttpStatus.CREATED);
    }

    @GetMapping("/favorite/{movieID}/{username}")
    public ResponseEntity<Favorite> getFavoriteByMovieID(@PathVariable Long movieID,@PathVariable String username) {
        Favorite favorite = favoriteService.findByMovieIDAndUsername(movieID,username);
        return new ResponseEntity<>(favorite, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{movieID}/{username}")
    public ResponseEntity<?> deleteFavoriteByMovieID(@PathVariable Long movieID,String username) {
        favoriteService.deleteFavoriteByMovieIDAndUsername(movieID,username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all/{username}")
    public ResponseEntity<List<Favorite>> getFavorites(@PathVariable String username){
        List<Favorite> favorites = favoriteService.findAllFavoriteByUsername(username);
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }

    // Add other controller methods as needed
}

package example.movie.controller;

import example.movie.model.dto.MovieCreateRequest;
import example.movie.model.dto.MovieDeleteRequest;
import example.movie.model.dto.MovieDto;
import example.movie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }
    // 영화등록
    @PostMapping("")
    public ResponseEntity<MovieDto> registerMovie(@RequestBody MovieCreateRequest request){
        MovieDto registeredMovie = movieService.registerMovie(request);
        return new ResponseEntity<>( registeredMovie, HttpStatus.CREATED);
    }
    // 영화삭제
    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer movieId, @RequestBody MovieDeleteRequest request){
        boolean isDeleted = movieService.deleteMovie(movieId, request.getPassword());
        if(isDeleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 성공시  204 No Content
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN); // 비밀번호 불일치 또는 없는 ID
        }
    }
    // 영화목록조회
    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies(){
        List<MovieDto> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}

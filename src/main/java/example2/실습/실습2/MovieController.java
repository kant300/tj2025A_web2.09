package example2.실습.실습2;

import example.movie.model.dto.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<?> postMovie(@RequestBody MovieDto movieDto) {
        return ResponseEntity.ok(movieService.postMovie(movieDto));
    }
    @GetMapping("/list")
    public ResponseEntity<?> findAllmovies(){
        return ResponseEntity.ok(movieService.findAllMovies());
    }
    @GetMapping
    public ResponseEntity<?> findMovieById(@RequestParam int movieId){
        return ResponseEntity.ok(movieService.findMovieById(movieId));
    }
    @PutMapping
    public ResponseEntity<?> updateMovie(@RequestBody MovieDto movieDto){
        return ResponseEntity.ok(movieService.updateMovie(movieDto));
    }
    @DeleteMapping
    public ResponseEntity<?> deleteMovie(@RequestParam int movieId){
        return ResponseEntity.ok(movieService.deleteMovie(movieId));
    }


}

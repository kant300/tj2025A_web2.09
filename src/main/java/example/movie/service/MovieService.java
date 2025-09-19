package example.movie.service;

import example.movie.model.dto.MovieCreateRequest;
import example.movie.model.dto.MovieDto;
import example.movie.model.mapper.MovieMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieService {
    private final MovieMapper movieMapper;

    public MovieService(MovieMapper movieMapper){
        this.movieMapper = movieMapper;
    }
    public MovieDto registerMovie(MovieCreateRequest request){
        MovieDto movieDto = new MovieDto();
        movieDto.setTitle(request.getTitle());
        movieDto.setDirector(request.getDirector());
        movieDto.setGenre(request.getGenre());
        movieDto.setSynopsis(request.getSynopsis());
        movieDto.setPassword(request.getPassword());
        movieDto.setCreateAt(LocalDateTime.now());
        movieMapper.insertMovie(movieDto);
        return convertToDto(movieDto);

    }
    public boolean deleteMovie(Integer movieId, String password){
        int deleteRows = movieMapper.deleteMovieNyIdAndePassword(movieId, password);
        return deleteRows > 0;
    }
    public List<MovieDto> getAllMovies(){
        return movieMapper.findAllMovies();
    }
}

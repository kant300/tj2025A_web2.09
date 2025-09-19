package example.movie.model.mapper;

import example.movie.model.dto.MovieDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Stack;

@Mapper
public interface MovieMapper {
    void insertMovie(MovieDto movieDtp);
    MovieDto findMovieById(Integer movieId);
    int deleteMovieByIdAndePassword(Integer movieId, String password);
    List<MovieDto> findAllMovies();
}

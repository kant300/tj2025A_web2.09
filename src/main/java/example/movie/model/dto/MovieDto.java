package example.movie.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDto {
    private Integer movieId;
    private String title;
    private String director;
    private String genre;
    private String synopsis;
    private LocalDateTime createAt;
    private String password;
}

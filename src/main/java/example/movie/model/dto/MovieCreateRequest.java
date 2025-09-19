package example.movie.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieCreateRequest {
    private String title;
    private String director;
    private String genre;
    private String synopsis;
    private String password;
}

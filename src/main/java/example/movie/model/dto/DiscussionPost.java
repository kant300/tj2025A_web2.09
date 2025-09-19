package example.movie.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DiscussionPost {
    private Integer postId;
    private Integer movieId;
    private String content;
    private String password;
    private LocalDateTime createAt;

}

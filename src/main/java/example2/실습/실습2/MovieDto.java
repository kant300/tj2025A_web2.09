package example2.실습.실습2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDto {
    private int movieId;    // 영화번호
    private String title;   // 영화제목
    private String director;    // 감독
    private String releaseDate; // 개봉일
    private double rating;  // 평점
    private String createdAt;
    private String updatedeAt;

    public MovieEntity toEntity(){
        return MovieEntity.builder()
                .title(this.title)
                .director(this.director)
                .releaseDate(this.releaseDate)
                .rating(this.rating)
                .build();
    }

}

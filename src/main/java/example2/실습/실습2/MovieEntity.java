package example2.실습.실습2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "movie" )
@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class MovieEntity extends BaseTime{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment 주입 :: MYSQL 만 가능
    private int movieId;    // 영화번호

    @Column( nullable = false , length = 100 )
    private String title;   // 영화제목
    private String director;    // 감독
    private String releaseDate; // 개봉일
    private Double rating;     // 평점

    // Entity -> DTO 변환 메서드
    public MovieDto toDto() {
        return MovieDto.builder()
                .movieId(this.movieId)
                .title(this.title)
                .director(this.director)
                .releaseDate(this.releaseDate)
                .rating(this.rating)
                .createdAt(this.getCreatedAt().toString())
                .updatedeAt(this.getUpdatedAt().toString())
                .build();
    }
}

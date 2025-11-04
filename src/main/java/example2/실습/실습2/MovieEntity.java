package example2.실습.실습2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "movie" )
@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class MovieEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment 주입 :: MYSQL 만 가능
    private int movieId;    // 영화번호

    @Column( nullable = false , length = 100 )
    private String title;   // 영화제목

    @Column( nullable = false , length = 50 )
    private String director;    // 감독


    private String releaseDate; // 개봉일
    private int rating;     // 평점
}

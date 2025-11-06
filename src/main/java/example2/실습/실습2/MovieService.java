package example2.실습.실습2;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieService {

    private final MovieRepository movieRepository;

    // 1. 영화등록
    public MovieDto postMovie(MovieDto movieDto){
        MovieEntity entity = movieDto.toEntity();
        MovieEntity savedEntity = movieRepository.save(entity);
        if( savedEntity.getMovieId() >= 0){ return savedEntity.toDto(); }
        return movieDto;
    }

    // 2. 전체조회
    public List<MovieDto> findAllMovies(){
        return movieRepository.findAll()    // Entity 리스트조회
                .stream()
                .map(MovieEntity::toDto)    // 각 엔티티를 DTO로 변환
                .collect(Collectors.toList());  // DTO리스트로 수집하여 반환
    }
    // 3. 개별조회
    public MovieDto findMovieById(int movieId){
        Optional<MovieEntity> movieOptional = movieRepository.findById(movieId);
        return movieOptional
                .map(MovieEntity::toDto)    // 존재하면 DTO로 변환
                .orElse(null);  // 없으면 null 반환
    }
    // 4. 특정 영화 수정
    public MovieDto updateMovie( MovieDto movieDto){
        Optional<MovieEntity> optional = movieRepository.findById(movieDto.getMovieId());
        if( optional.isPresent()){  // 엔티티를 DTO값으로 변경
            MovieEntity entity = optional.get();
            entity.setTitle(movieDto.getTitle());
            entity.setDirector(movieDto.getDirector());
            entity.setReleaseDate(movieDto.getReleaseDate());
            entity.setRating(movieDto.getRating());
            return entity.toDto(); // 변경된 엔티티를 DTO로 변환하여 반환
            // @Transactional 의 역할
            // 이 어노테이션은 메서드를 **하나의 트랜잭션**으로 묶어준다.
            // 1. **자동 변경 감지(Dirty Checking)**: 메서드 시작 시 엔티티를 영속성 컨텍스트에 저장하고,
            // 메서드 종료 시 영속성 컨텍스트에 있는 엔티티의 변경 사항을 확인하여 **자동으로 DB에 UPDATE 쿼리를 날려줍니다.**
            // (별도의 `save()` 호출 필요 없음)
            // 2. **데이터 일관성 유지**: 메서드 내에서 오류(예외)가 발생하면, 이전에 수행했던 모든 DB 작업(CRUD)을
            // **롤백(Rollback)**하여 데이터의 일관성을 유지한다.

        }
        return movieDto;
    }
    // 5. 특정 영화 삭제
    public boolean deleteMovie( int movieId ){
        if(movieRepository.existsById(movieId)){
            movieRepository.deleteById(movieId);
            return true;
        }
        return false;
    }

}

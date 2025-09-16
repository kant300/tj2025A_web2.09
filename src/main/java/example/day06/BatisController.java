package example.day06;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController     // REST API를 처리하는 컨트롤러임
@RequestMapping("/day06/batis")
@RequiredArgsConstructor    // final 변수에 대해 자동 생성자
public class BatisController {
    // * Mapper 객체 DI (Dependency Injection, 의존성 주입)
    // MyBatis의 매퍼 인터페이스를 주입받아 데이터베이스 작업을 수행합
    private final BatisMapper batisMapper;
    // 1. 학생등록
    @PostMapping("")  // http://localhost:8080/day06/batis
    // body : {"name":"유재석", "kor":"90","math":"85" }
    public ResponseEntity<Integer> save(
            @RequestBody StudentDto studentDto ){ //JSON 형태로 전달된 데이터를 StudentDto 객체로 변환
        int result = batisMapper.save( studentDto); // batisMapper.save() 메서드를 호출하여 데이터베이스에 학생 정보를 저장
        return ResponseEntity.status( 200 ).body( result );
    }


    // 2. 전체 학생 조회
    @GetMapping("") // http://localhost:8080/day06/batis
    public ResponseEntity<List<StudentDto> > findAll(){
        // 현재 예제는 서비스를 생략
        // batisMapper.findAll() 메서드를 호출하여 데이터베이스의 모든 학생 정보를 List 형태로 가져옵니다.
        List< StudentDto > result = batisMapper.findAll();
        // ResponseEntity 응답객체
        return ResponseEntity.status( 200 ).body( result );

    }

    // 3. 개별 학생 조회
    @GetMapping("/find") // http://localhost:8080/day06/batis/find?sno=1
    public ResponseEntity<Map< String , Object >> find(
        @RequestParam int sno ){
        // batisMapper.find() 메서드를 호출하여 특정 sno를 가진 학생 정보를 Map 형태로 가져옵니다.
        Map<String ,Object> result = batisMapper.find( sno );
        return ResponseEntity.status( 200 ).body( result );
    }

    // 4. 개별 학생 삭제
    @DeleteMapping("") // http://localhost:8080/day06/batis?sno=1
    public ResponseEntity<Integer> delete(
            @RequestParam int sno ) {
        // batisMapper.delete() 메서드를 호출하여 지정된 sno의 학생 정보를 삭제합니다.
        int result = batisMapper.delete( sno );
        return ResponseEntity.status( 200 ).body( result );
    }

    // 5. 개별 학생 수정
    @PutMapping("") // http://localhost:8080/day06/batis
    // body : {"sno":"2", "kor":"100","math":"100" }
    public ResponseEntity<Integer> update(
            @RequestBody StudentDto studentDto ){ //수정할 학생 정보(sno, kor, math)를 가져옵니다.
        int result = batisMapper.update( studentDto );  // batisMapper.update() 메서드를 호출하여 학생 정보를 수정합니다.
        return ResponseEntity.ok( result ); // ok == 200
    }


}

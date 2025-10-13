package example.day13;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/xml")
@RequiredArgsConstructor
public class XmlController {
    // #
    private final XmlMapper xmlMapper;
    // # 1. 등록 , { "name" : "유재석" , "kor" : "98" , "math" : "70" }
    @PostMapping("")
    public ResponseEntity< ? > save(@RequestBody StudentDto dto){
        // < ? > : 제네릭타입에 ? 넣으면 모든 타입을 지칭한다. 와일드카드
        System.out.println("dto = " + dto); // soutp , save 실행전 , sno 없다
        int result = xmlMapper.save(dto);   // ======= SQL 실행 =========
        System.out.println("dto = " + dto); // soutp , save 실행후 , sno 있다.
        xmlMapper.save( dto );
        return ResponseEntity.ok(true); // 제네릭 ? 이므로 모든 자료가 대입된다.
    }

    // # 2. 전체조회
    @GetMapping("")
    public ResponseEntity< ? > findAll(){
        List<StudentDto> result = xmlMapper.findAll();
        return ResponseEntity.ok( result);
    }

    // # 3. 개별학생조회
    @GetMapping("/find")    // http://localhost:8080/xml/find?sno=1
    public ResponseEntity< ? > find( @RequestParam int sno){
        StudentDto result = xmlMapper.find(sno);
        return ResponseEntity.ok(result);
    }

    // # 4. 개별 학생 삭제
    @DeleteMapping("")  // http://localhost:8080/xml?sno=1
    public ResponseEntity< ? > delete( @RequestParam int sno ){
        int result = xmlMapper.delete( sno );
        return ResponseEntity.ok(result);
    }

    // # 5. 개별 학생 수정
    @PutMapping("") // http://localhost:8080/xml
    // body : { "sno" : "2" , "kor" : "100" , "math" : "100" }
    public ResponseEntity< ? > update( @RequestBody StudentDto studentDto ){
        int result = xmlMapper.update( studentDto);
        return ResponseEntity.ok(result); // ok == 200
    }


}// class e
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

    // # 6. 특정한 국어점수가 이상인 학생 조회
    @GetMapping("/query2")  // http://localhost:8080/xml/query?kor=90
    public ResponseEntity< ? > query2( @RequestParam int kor ){
        List<StudentDto> result = xmlMapper.query2(kor);
        return ResponseEntity.ok(result);
    }

    // # 7. 이름(포함된) 또는 수학점수(이상)로 검색
    @GetMapping("/query3")  //http://localhost:8080/xml/search?name=유재석&math=70
    public ResponseEntity< ? > query3(
            @RequestParam(required = false) String name,
            @RequestParam int math
    ){
        List<StudentDto> result = xmlMapper.query3(name,math);
        return ResponseEntity.ok(result);
    }

    // # 8. 여러개 학생 등록
    // body : [ { "name" : "강호동" , "kor" : "85" , "math" : "90" }, { "name" : "신동엽" , "kor" : "75" , "math" : "60" } ]
    @PostMapping("/save")
    public ResponseEntity< ? > saveAll(@RequestBody List<StudentDto> dtos){
        int result = xmlMapper.saveAll(dtos);
        return ResponseEntity.ok(result); // 등록된 행의 개수 반환
    }






}// class e
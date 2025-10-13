package example.day13;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        xmlMapper.save( dto );
        return ResponseEntity.ok(true); // 제네릭 ? 이므로 모든 자료가 대입된다.
    }

    // # 2. 전체조회
    public ResponseEntity< ? > findAll(){
        List<StudentDto> result = xmlMapper.findAll();
        return ResponseEntity.ok( result);
    }

}// class e
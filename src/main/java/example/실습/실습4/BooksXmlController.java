package example.실습.실습4;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xml")
@RequiredArgsConstructor
public class BooksXmlController {
    private final BooksXmlMapper booksXmlMapper;
    // 1. 책 단일 등록 기능 구현
    @PostMapping("")
    public ResponseEntity< ? > save(@RequestBody BooksDto dto){
        booksXmlMapper.save(dto);
        return ResponseEntity.ok(true);
    }
}

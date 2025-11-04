package example2.실습.실습1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    // 1. C , 도서등록  , http://localhost:8080/api/book
    // { "bookId" : "1" , "title" : "대화혁명" , "author" : "홍광수" , "publisher" : "믿음사"}
    @PostMapping
    public ResponseEntity<?> post(@RequestBody BookEntity bookEntity ){
        return ResponseEntity.ok(bookService.post(bookEntity));
    }
    // 2. R , 전체조회
    @GetMapping
    public ResponseEntity<?> get(){
        return ResponseEntity.ok(bookService.get());
    }
    // 3. U , 특정한 엔티티 수정
    @PutMapping // { "bookId" : "1" , "title" : "자바" , "author" : "이경규" , "publisher" : "믿음사"}
    public ResponseEntity<?> put(@RequestBody BookEntity bookEntity){
        return ResponseEntity.ok(bookService.put(bookEntity));
    }
    // 4. D , 삭제
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam int bookId ){
        return ResponseEntity.ok(bookService.delete(bookId));
    }


}

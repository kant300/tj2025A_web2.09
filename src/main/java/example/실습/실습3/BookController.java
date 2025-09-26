package example.실습.실습3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    // [1] 도서대출
    @PostMapping("/rent")
    public ResponseEntity<Boolean> rent(
            @RequestBody Map< String, Object > body ){

        boolean result = bookService.rent( body );
        return ResponseEntity.ok( result );
    }
}

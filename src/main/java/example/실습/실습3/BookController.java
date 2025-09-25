package example.실습.실습3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
//    // [1] 도서대출
//    @PostMapping("/rent")
//    public boolean rentBook(){
//        return bookService.rentBook();
//    // [2] 도서반납
//    @PostMapping("/return")
//    public boolean returnBook(){
//        return  bookService.returnBook();
//        }
//    }
}

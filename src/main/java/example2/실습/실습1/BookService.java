package example2.실습.실습1;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    // 1. C , 도서등록
    public BookEntity post( BookEntity bookEntity ){
        BookEntity saveEntity = bookRepository.save(bookEntity);
        return saveEntity;
    }

    // 2. R , 전체조회
    public List<BookEntity> get(){
        List<BookEntity> entityList = bookRepository.findAll();
        return entityList;
    }
    // 3. U , 특정한 엔티티 수정
    public BookEntity put(BookEntity bookEntity){
        Optional< BookEntity > optional = bookRepository.findById( bookEntity.getBookId());
        if( optional.isPresent()){
            BookEntity entity = optional.get();
            entity.setTitle(bookEntity.getTitle());
            entity.setAuthor(bookEntity.getAuthor());
            entity.setPublisher(bookEntity.getPublisher());
            return entity;
        }
        return bookEntity;
    }
    // 4. D , 삭제 , 특정한 엔티티 삭제
    public boolean delete(int bookId){
        bookRepository.deleteById( bookId );
        return true;
    }



}

package example2.실습.실습1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BookEntity {
    @Id
    private int bookId;
    private String title;
    private String author;
    private String publisher;
}

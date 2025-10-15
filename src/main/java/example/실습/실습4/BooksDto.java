package example.실습.실습4;

import lombok.*;

@Setter@Getter@ToString@Builder
@NoArgsConstructor@AllArgsConstructor
public class BooksDto {
    private String title;
    private int stock;
    private String member;
    private String date;
}

package example2.day03._자바참조;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
public class Category {
    // 1. 멤버변수
    private int cno;    // 카테고리번호
    private  String cname;  // 카테고리명
    @ToString.Exclude // toString 제외
    List<Board> boardList = new ArrayList<>(); //
    // 2. 생성자

    // 3. 메소드

}

//package example2.실습.실습4;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class TodoDto {
//    private int id; // 할일 번호
//    private String title;   // 할일 제목
//    private String content; // 할일 내용
//    private LocalDateTime createdAt;   //  생성일
//    private LocalDateTime updatedAt;   // 수정일
//
//    public TodoEntity toEntity(){
//        return TodoEntity.builder()
//                .title(this.title)
//                .content(this.content)
//                .build();
//    }
//}

//package example2.실습.실습4;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table( name = "todo")
//@Data
//@NoArgsConstructor@AllArgsConstructor@Builder
//public class TodoEntity extends BaseTime{
//    // 1. 테이블 속성 설계
//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY)
//    private int id;  // PK
//
//    @Column( nullable = false , length = 100 )
//    private String title;
//    @Column ( columnDefinition = "longtext")
//    private String content;
//    @Column( columnDefinition =  "boolean default false")
//    private boolean done;
//
//    // 2. 참조 관계 설정
//
//    public TodoDto toDto(){
//        return TodoDto.builder()
//                .id(this.id)
//                .title(this.title)
//                .content(this.content)
//                .createdAt(this.getCreatedAt().toString())
//                .updatedAt(this.getUpdatedAt().toString())
//                .build();
//
//    }
//
//}

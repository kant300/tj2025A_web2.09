package example2.실습.실습3._연관;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data@Builder@Entity
@Table( name = "acourse")
public class CourseEntity extends  BaseTime{ // BaseTime 상속
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int courseId;  // 과정번호(PK)
    private String courseName;



}

package example2.실습.실습3._연관;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity@Data@Builder
@Table( name = "aenroll")
public class EnrollEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int enrolleId;
    private String status;
    // 단방향 연결 //
    @ManyToOne( cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn( name = "courseId" )
    private CourseEntity courseEntity;
    private StudentEntity studentEntity;

    // 양방향 연결 //
    @OneToMany( mappedBy = "enrollEntity")
    @ToString.Exclude
    @Builder.Default
    private List<CourseEntity> courseEntityList = new ArrayList<>();

}

package example2.실습.실습3._참조;

import lombok.Data;

@Data
public class Enroll {
    private int enrollId;   // 수강번호
    private  String status; // 수강상태
    private int couserId;   // 과정번호 (FK)
    private int StudentId;  // 학생번호 (FK)
}

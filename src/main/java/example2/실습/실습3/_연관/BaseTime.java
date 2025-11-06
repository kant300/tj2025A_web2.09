package example2.실습.실습3._연관;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 엔티티 상속 전용 클래스 지정
@EntityListeners( AuditingEntityListener.class ) // JPA 감사(Auditing) 기능 활성화
// **** AppStart 클래스 위에 '@EnableJpaAuditing'주입해야 가능하다 ****
public class BaseTime {
    @CreatedDate  // insert 시 자동 시간 기록
    private LocalDateTime createDate;

    @LastModifiedDate  // update 시 자동 시간 기록
    private LocalDateTime updateDate;

}

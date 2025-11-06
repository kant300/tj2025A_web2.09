package example2.실습.실습2;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // 엔티티 상속용 클래스 지정
@EntityListeners(AuditingEntityListener.class)  // JPA 감사 기능 활성화
public class BaseTime {

    @CreatedDate    // insert 시 자동시간 기록
    private LocalDateTime createdAt;

    @LastModifiedDate   // update 시 자동시간 기록
    private LocalDateTime updatedAt;
}

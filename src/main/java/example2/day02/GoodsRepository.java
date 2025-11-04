package example2.day02;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository     // 빈 등록
public interface GoodsRepository
    extends JpaRepository<GoodsEntity, Integer> {
    // extends JpaRepository<조작할엔티티클래스명, 엔티티PK자료형>
}

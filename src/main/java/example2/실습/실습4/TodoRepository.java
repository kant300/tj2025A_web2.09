//package example2.실습.실습4;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
//    List<TodoEntity> findByTitle( String title );
//
//    List<TodoEntity> findByTitleAndContent( String title, String content );
//
//
//    // * SQL 문장을 직접 작성하여 실행한다. , : (콜론)매개변수명 이용하여 매개변수 대입한다.
//    // 3-1 : @Query( value = "SQL작성" , nativeQuery = true ) 추상메소드 주입하낟.
//    @Query( value = "select * from todo where title = :title" , nativeQuery = true )
//    List<TodoEntity> query1( String title );
//    // 3-2
//    @Query( value = "select * from todo where title = :title and content = :content" , nativeQuery = true )
//    List<TodoEntity> query2( String title, String content );
//    // 3-3
//    @Query( value = "select * from todo where title like %:keyword" , nativeQuery = true )
//    List<TodoEntity> query3( String keyword );
//}

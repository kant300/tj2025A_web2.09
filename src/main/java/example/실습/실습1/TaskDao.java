package example.실습.실습1;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TaskDao {
    // DB연결
    private String db_url = "jdbc:mysql://localhost:3306/springweb2";
    private String db_user = "root";
    private String db_password = "1234";
    public Connection conn;
    // DB연동 생성자
    public TaskDao(){ connect(); }
    // DB 연동메소드
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( db_url, db_user, db_password );
            System.out.println("Dao.connect");
        }catch( Exception e ){
            System.out.println( e );
        }
    }
    // 1. 매 30초마다 모든 제품의 재고는 3개씩 감소한다.
    public void task1(){
        try{
            String sql="update products set stock_quantity = stock_quantity - 3 WHERE stock_quantity >= 3";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 2.  매 1분마다 모든 제품 정보를 조회/출력 한다.
    public List<Map<String , String >> task2(){
        List<Map< String, String >> list = new ArrayList<>();
        try{
            String sql = "select * from products";
            PreparedStatement ps = conn.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Map<String,String> map = new HashMap<>();
                map.put("pid",rs.getString("product_id"));
                map.put("pname",rs.getString("product_name"));
                map.put("stock",rs.getString("stock_quantity"));
                list.add(map);
            }// while end
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    // 3. 매 5분마다 재고가 10 이하인 상품의 재고를 +20개 추가한다.
    public void task3(){
        try{
            String sql= "update products set stock_quantity = stock_quantity +20 where stock_quantity <= 10";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

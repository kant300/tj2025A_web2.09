package web2.model.mapper;

import lombok.Setter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import web2.model.dto.UserDto;

@Mapper
public interface UserMapper {
    // 1. 회원가입( pk반환 )
    @Insert("insert into users( uid , upwd, uname, uphone, urole) values( #{uid}, #{upwd}, #{uname}, #{uphone}, #{ urole })")
    @Options( useGeneratedKeys = true , keyProperty = "uno") // insert 성공시 매개변수에 생성된 pk값을 주입한다.
    public int signup(UserDto userDto );

    // 2-1. 로그인
//    @Select("select * from users where uid = #{ uid } and upwd = #{ upwd }")
//    UserDto login( UserDto userDto );

    // 2-2 : 회원아이디로 계정 정보 조회+로그인
    @Select("select * from user")

}

package example.Task5.model.mapper;

import example.Task5.model.dto.MemberDto;
import example.Task5.service.MemberService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public class MemberMapper {
    // 등록
    @Insert("insert into member( name, phone, age ) values( #{ name }, #{ phone } ,#{ age } )")
    public boolean memberWrite(MemberDto memberDto);
    // 전체조회
    @Select("select * from member")
    public List<MemberDto> memberPrint();
}


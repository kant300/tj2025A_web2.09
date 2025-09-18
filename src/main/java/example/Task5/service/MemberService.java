package example.Task5.service;

import example.Task5.model.dto.MemberDto;
import example.Task5.model.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;

    // 등록
    public boolean memberWrite(MemberDto memberDto){
        boolean result = memberMapper.memberWrite( memberDto );
        return result;
    }
    // 전체조회
    public List<MemberDto> memberPrint(){
        List<MemberDto> result = memberMapper.memberPrint();
        return result;
    }



}

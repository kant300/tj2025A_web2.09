package web2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web2.model.dto.UserDto;
import web2.model.mapper.UserMapper;

@Service
@RequiredArgsConstructor    // final  필드에 대한 자동 생성자 주입
public class UserService {

    private  final UserMapper userMapper;
    // 1. 회원가입
    public int signup(UserDto userDto){
        userMapper.signup(userDto); // mapper이용한 sql 처리
        if( userMapper)
    }
}

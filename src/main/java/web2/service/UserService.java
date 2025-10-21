package web2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import web2.model.dto.UserDto;
import web2.model.mapper.UserMapper;

@Service
@RequiredArgsConstructor    // final  필드에 대한 자동 생성자 주입
public class UserService {

    private  final UserMapper userMapper;
    // 1-2 : 비크립트 라이브러리 객체 주입
    private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    // 1. 회원가입
    public int signup(UserDto userDto){
        // 1-3 : 회원가입 하기전에 비크립트를 이용한 비밀번호 암호화(사람이 이해하기 어려운 데이터로 변경) 하기
        // String 암호화된데이터 = bcrypt.encode(암호화된데이터);
        userDto.setUpwd( bcrypt.encode( userDto.getUpwd() ) ); // 1234 --> XXXXXXXXXXXXXXXXXXX
        System.out.println("[암호화 결과] = " + userDto.getUpwd());

        userMapper.signup(userDto); // mapper이용한 sql 처리
        if( userDto.getUno() > 0 ){ // 만약에 uno 생성되었다면 회원가입 SQL처리 성공
            return userDto.getUno();    // 회원번호 반환(1, 2, 3 ~~~)
        }else{
            return 0;   // 회원가입 실패를 0으로 가정한다.
        }
    }// m end

    // 2 로그인 : 암호문을 해독하여 평문을 비교하는 방식이 아닌 비교할 대상을 암호화해서 암호문 비교
    public UserDto login(UserDto userDto){
        // 2-1 : 현재 로그인에서 입력받은 아이디의 계정이 있는지 확인
        UserDto result = userMapper.login( userDto.getUid() );
        if( result == null ){ return null; }
        // 2-2 : 만약에 입력받은 아이디의 계정이 존재하면, 입력받은 비밀번호화 암호화된 비밀번호 비교
        // 평문비교가 아니므로 == equals 불가능하다.
        // 암호분 비교방식인 .matches(비교할비밀번호 평문, 암호문)
        System.out.println("[ 평문 : 로그인시 입력받은 비밀번호 ]= " + userDto.getUpwd() );
        System.out.println("[ 암호문 : 회원가입시 입력받은 비밀번호 ] = " + result.getUpwd() );
        boolean result2 = bcrypt.matches(userDto.getUpwd(), result.getUpwd() );
        if( result2 == true ){  // 비밀번호가 일치하면 로그인 성공
            result.setUpwd( null ); // 비밀번호 성공시 반환되는 계정에는 비밀번호 제외
            return result;
        }else { return null; }
    }

    // 3. 내정보 조회
    public UserDto myInfo( String uid ){
        UserDto result = userMapper.myInfo(uid);
        return result;
    }

}

//회원의 비밀번호를 암호화
//1234(평문) --- 나만의 계산식 ---> 7572858484
//* 평문 : 본래의 데이터, 암호문 : 암호화된 데이터
//* 암호화 : 사람이 이해 할 수 없는 데이터 변경
//* 복호화 : 암호화된 데이터를 다시 평문으로 변경
//나만의 계산식 : 암호화 알고리즘(순서도) , 비밀번호에서 사용되는 대표 : 비크립토

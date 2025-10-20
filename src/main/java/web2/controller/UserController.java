package web2.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web2.model.dto.UserDto;
import web2.service.UserService;

@RestController
@RequestMapping("/api/user") // 공통 URL 정의
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 1. 회원가입
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserDto userDto){
        int result = userService.signup( userDto );
        return ResponseEntity.ok( result );     // ok(200 성공의 의미)
    }

    // 2-1. 로그인(+세션 : 자바웹서버(톰캣)의 임시저장소, 한번 로그인 성공했다는 증거 )
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto, HttpSession session) {
        UserDto result = userService.login(UserDto);
        if (result != null) { // 만약에 로그인 성공했다면 성공한 유저의 아이디를 세션에 저장
            session.setAttribute(("loginUser", result.getUid()));
        }
        return ResponseEntity.ok(result);
    }

    // 3. 현재 로그인된 정보 호출( + 마이페이지 )

    // 4. 로그아웃

}

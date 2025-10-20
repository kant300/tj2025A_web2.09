package web2.controller;

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
        int result userService.signup( userDto );
        return ResponseEntity.ok( result );     // ok(200 성공의 의미)
    }
}

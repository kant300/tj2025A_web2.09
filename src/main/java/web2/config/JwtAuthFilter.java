package web2.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import web2.service.JwtService;

import java.io.IOException;
import java.util.List;

@Component  // 빈 등록
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    // 내가 만든 토큰(jwtService) 인증 방법을 (시큐리티방식)usernamepasswordauthentionToken 혼합

    // [1] 내가 만든 토큰 방식
    private final JwtService jwtService;

    // [2]  기존 시큐리티 방식의 필터 커스텀, 상속받기( OncePerRequestFilter ), 물려받기
    @Override   // 오버라이딩( 상속받은 메소드 재정의 )
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. 세션이 아닌 쿠키 방식이라서 먼저 쿠키에서 토큰 추출
        String token = null;
        if( request.getCookies() != null ){ // 쿠키가 존재하면
            for(Cookie cookie : request.getCookies() ){ // 모든 쿠키들을 반복문 돌려서
                if( cookie.getName().equals("loginUser")){ // 로그인유저 쿠키가 존재하면
                    token = cookie.getValue();  //
                }
            }
        }

        // 2. UsernamepasswordauthentionToken 을 내 재정의하기
        if( token !=null && jwtService.checkToken(token) ){ // 토큰이 유효하면
            String uid = jwtService.getUid(token);  // 아이디꺼내기
            String urole = jwtService.getUrole(token);  // **권한**꺼내기
            //
            //
//            new UsernamePasswordAuthenticationToken(
//                    id, password,
//                    List.of(new SimpleGrantedAuthority("ROLE_권한명1"), new SimpleGrantedAuthority() ) );

            //
            UsernamePasswordAuthenticationToken t =
                    new UsernamePasswordAuthenticationToken(
                            uid, null,
                            List.of(new SimpleGrantedAuthority("ROLE_권한명1"), new SimpleGrantedAuthority())

        }
    }
}

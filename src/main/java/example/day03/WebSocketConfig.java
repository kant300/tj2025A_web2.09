package example.day03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration // 스프링 컨테이너에 빈 등록
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    // 내가 만든 서버 웹소켓(핸들러)에 주소 등록한다.
    // @Autowired 사용하는 클래스들의 전제조건 : 스프링 컨테이너 빈 등록
    @Autowired private ChatSocketHandler chatSocketHandler;


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // registry.addHandler( 웹소켓객체 , 매핑주소 ); 여러개 등록이 가능하다.
        registry.addHandler( chatSocketHandler , "/chat");
    }
}

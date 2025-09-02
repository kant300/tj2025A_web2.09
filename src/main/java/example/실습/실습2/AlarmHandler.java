package example.실습.실습2;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Vector;

@Component // 스프링 컨테이너(메모리)에 빈(객체) 등록
public class AlarmHandler extends TextWebSocketHandler {

    private static final List<WebSocketSession > sessions = new Vector<>();

    @Override
    public void afterConnectionEstablished( WebSocketSession session ) throws Exception {
        System.out.println("[서버] 클라이언트소켓과 연동 성공");
        // WebSocketSession 이란 : ws 기반으로 클라이언트가 요청한 정보가 저장된 객체
        // HttpSession 이란 : http 기반으로 클라이언트가 요청한 정보가 저장된 객체
        System.out.println("[클라이언트 웹소켓 객체] : " + session );
        // 1. 접속된 클라이언트 소켓들을 저장 : 받은 메시지를 접속된 소켓들에게 재전송하기
        sessions.add( session ); // 서버와 접속 성공한 클라이언트 소켓(세션)을 리스트에 저장
        for( WebSocketSession clientSocket : sessions ) {
            clientSocket.sendMessage( new TextMessage( "익명의 유저가 접속했습니다. "));
        }
    }

    @Override
    public void afterConnectionClosed (WebSocketSession session , CloseStatus status ) throws Exception{
        sessions.remove(session);
        for( WebSocketSession clientSocket : sessions ){
            clientSocket.sendMessage(new TextMessage( "익명의 유저가 퇴장했습니다. "));
        }
    }
}// class e

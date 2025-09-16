package example.day07.controller;


import example.day07.model.dto.BoardDto;
import example.day07.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/board") // + 공통 URL
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

       // [1] 등록
    @PostMapping("") // localhost:8080/board
    public ResponseEntity<Boolean> boardWrite(@RequestBody BoardDto boardDto ){
        boolean result = boardService.boardWrite( boardDto ); // 서비스 호출 하고 응답을 반환
        return ResponseEntity.status( 200 ).body( result );
            // ResponseEntity.status( 200 ).body( 응답자료 );
    }

    // [2] 전체조회
    @GetMapping("") // localhost:8080/board
    public ResponseEntity< List<BoardDto> >  boardPrint(){
        List<BoardDto> result = boardService.boardPrint();
        return ResponseEntity.ok().body(result);
    }

    // [3] 개별조회
    @GetMapping("/find") // localhost:8080/board/find?bno=1
    public ResponseEntity<BoardDto> boardFind( @RequestParam int bno ){
        BoardDto result = boardService.boardFind( bno );
        return ResponseEntity.ok().body(result);
    }

    // [4] 개별삭제
    @DeleteMapping("") // localhost:8080/board?bno=3
    public ResponseEntity<Boolean> boardDelete( @RequestParam int bno ){
        boolean result = boardService.boardDelete( bno );
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("") // localhost:8080/board
    public ResponseEntity< Boolean > boardUpdate( @RequestBody BoardDto boardDto ){
        boolean result = boardService.boardUpdate( boardDto );
        return ResponseEntity.ok().body( result );
    }


}// class end

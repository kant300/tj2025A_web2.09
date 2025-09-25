//package example.Task5.controller;
//
//import example.Task5.model.dto.MemberDto;
//import example.Task5.service.MemberService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/member")
//@RequiredArgsConstructor
//@CrossOrigin( value = "http://localhost:5174")
//public class MemberController {
//    private final MemberService memberService;
//
//    // 등록
//    @PostMapping("")
//    public ResponseEntity<Boolean> memberWrite(@RequestBody MemberDto memberDto ){
//        boolean result = memberService.memberWrite( memberDto);
//        return ResponseEntity.status( 200 ).body( result );
//    }
//
//    // 전체조회
//    @GetMapping("")
//    public ResponseEntity<List<MemberDto>> memberPrint(){
//        List<MemberDto> result = memberService.memberPrint();
//        return ResponseEntity.ok().body(result);
//    }
//
//    // 삭제
//
//}

package example.day08;

class TestService{
    // 만약에 식당과 학원에서 동일한 코드/명령어를 실행한다면
    // -> 방법1) 열체크 함수화, 방법2) 관점지향 프로그래밍 AOP
    // 메소드1
    public void enter1(){
        System.out.println("[코로나] 열 체크");
        System.out.println(">>식당 입장<<");
    }
    // 메소드2
    public void enter2(){
        System.out.println("[코로나] 열 체크");
        System.out.println(">>학원 입장<<");

    }
//}
//public class Example1 {
//    public static void main(String[] args) {
//        TestService testService = new TestService();    // 메소드1,2 실행하기 위한 객체생성
//        TestService.enter1();   // 메소드1 호출
//        TestService.enter2();   // 메소드2 호출
//    }// main end
}// class end

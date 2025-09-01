package example.실습.실습1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TaskService {
    @Autowired
    public TaskDao taskDao;

    // 1. 매 30초마다 모든 제품의 재고는 3개씩 감소한다.
    @Scheduled( cron = "*/30 * * * * *")// 예시] 12:57:00 , 12:57:30
    public void task1(){
        taskDao.task1();
        // ++ DAO호출하여 모든 제품 3개씩 감소 요청/응답++
        System.out.println("[30초] ScheduleService.stock");
    }
    // 2. 매 1분마다(0/1 과 1은 다르다) 모든 제품 정보를 조회/출력 한다.
    @Scheduled( cron = "0 0/1  * * * *") // 예시] 12:57:00 , 12:58:00
   //  @Scheduled( cron = "0 1  * * * *") // 매시각 1분될때마다 예시] 12:01:00 , 13:01:00
    public void task2(){
        List<Map<String , String >> list = taskDao.task2();
        System.out.println(list);
        // ++ 모든 제품 정보를 조회/출력 한다. ++
    }
    // 3. 매 5분마다 재고가 10 이하인 상품의 재고를 +20개 추가한다.
    @Scheduled( cron = " 0 0/5 * * * *")
    public void task3(){
        taskDao.task3();
        System.out.println("[5분] TaskService.task3");
        // ++ 재고가 10이하인 상품의 재고를 +20개 추가한다.++
    }
}

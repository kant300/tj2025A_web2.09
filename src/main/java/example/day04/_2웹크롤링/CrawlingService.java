package example.day04._2웹크롤링;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CrawlingService {
    // 1. 뉴스 크롤링 https://www.karnews.or.kr/
    public List<String> task1() {
        List<String > list = new ArrayList<>(); // 크롤링한 제목들을 담을 리스트
        try{
            // 1-1 : 크롤링한 웹페이지 주소
            String URL = "https://www.karnews.or.kr/news/articleList.html?sc_section_code=S1N1&view_type=sm";
            // 1-2 : JSOUP 이용한 웹주소의 HTML(문서) 가져오기
            // * Document import org.jsoup.nodes.Document;
            // * Jsoup.connect( 크롤링할주소 ).get() * 일반예외
            Document document = Jsoup.connect(URL).get();
            System.out.println("document = " + document);
            // 1-3 : ********************** 가져올 HTML 식별자  .select("CSS선택자"); ************************
            // JS : document.querySelect("CSS선택자" );
            // JSOUP :  document.select("CSS선택자" );
            Elements aList = document.select(".titles > a");  // 'title'이라는
            System.out.println("aList = " + aList);
            // 1-4 : 가져온 마크업등ㄹ을 반복하여 텍스트만 추출. text()
            for(Element a : aList ){
                String title = a.text();
                if( title.isBlank() ) continue; // * 만일 내용이 없으면 다음반복 *
                list.add( title );
            }
        }catch( Exception e ) {
            System.out.println("CrawlingService.인스턴스 이니셜라이저");
        }
        return list;
    }// func e

    // 2. 상품정보 : 예스24 , https://www.yes24.com/robots.txt
    public List<Map<String, String >> task2(){
        //2-1 :  책정보들을 담을 리스트
        List< Map< String, String >> list = new ArrayList<>();
        try{
            // 2-2 : 웹크롤링할 주소
            String URL ="https://www.yes24.com/product/category/daybestseller?categoryNumber=001&pageNumber=1&pageSize=24&type=day";
            // 2-3 : JSOUP 활용한 지정한 주소 HTML로 가져오기
            Document document = Jsoup.connect(URL).get();
            // 2-4 : 책제목(.info_name > .gd_name)과 책가격(.info_price > .txt_num > .yes_b)의 css선택자 확인/가져오기
            Elements nameList = document.select(".info_name > .gd_name" );
            Elements priceList = document.select(".info_price > .txt_num > .yes_b");
            Elements imgList = document.select(".img_bdr .lazy");
            // 2-5 : 반복문을 이용한 책정보 구성
            for( int i = 0 ; i< nameList.size(); i++  ){
                String name = nameList.get( i ).text(); // i번째 책제목 1개씩 호출
                String price = priceList.get( i ).text(); // i번째 책가격 1개씩 호출
                String img = imgList.get( i ).attr( "data-original"); // i번째 책이미지(링크) 속성값 1개 호출
                Map<String ,String > map = new HashMap<>();
                map.put( "name" , name );
                map.put( "price" , price); // MAP 객체생성 VS DTO
                map.put( "img" , img );
                list.add(map);
            }
        } catch (Exception e) {
            System.out.println("CrawlingService.task2");
        }
        return list;
    }

}// class e

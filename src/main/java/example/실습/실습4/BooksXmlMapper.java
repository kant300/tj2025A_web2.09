package example.실습.실습4;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BooksXmlMapper {
    // 1. 책 단일 등록 기능 구현
    String save(BooksDto dto);
}

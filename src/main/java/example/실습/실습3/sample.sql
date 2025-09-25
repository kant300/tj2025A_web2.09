drop database if exists 실습3;
create database 실습3;
use 실습3;
-- 1. 책 테이블
    CREATE TABLE books (
        id INT NOT NULL auto_increment,  	-- 도서번호
        title VARCHAR(255) NOT NULL,		-- 도서명
        stock INT NOT NULL DEFAULT 0,		-- 도서재고
        PRIMARY KEY (id)
    );

    -- 2. 대출 기록 테이블
    CREATE TABLE rentals (
        id INT NOT NULL auto_increment,		-- 대출기록 번호
        book_id INT NOT NULL,				-- **참조**하는 도서번호
        member VARCHAR(100) NOT NULL, 	    -- 대출한 사람
        rent_date DATETIME DEFAULT NOW(),	-- 대출일
        return_date DATETIME NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (book_id) REFERENCES books(id)
    );

    -- 3. 샘플 데이터 (책 목록)
    INSERT INTO books (id, title, stock) VALUES (1, '자바의 정석', 3);
    INSERT INTO books (id, title, stock) VALUES (2, '스프링 인 액션', 2);
    INSERT INTO books (id, title, stock) VALUES (3, '토비의 스프링', 1);
    INSERT INTO books (id, title, stock) VALUES (4, '리액트 교과서', 5);

    -- 4. 샘플 데이터 (대출 기록)
    INSERT INTO rentals (id, book_id, member) VALUES (1, 1, '홍길동');

    -- 5. 확인용 조회 쿼리
    SELECT * FROM books;
    SELECT * FROM rentals;
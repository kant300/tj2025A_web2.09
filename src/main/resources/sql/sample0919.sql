drop database if exists exam0919;
create database exam0919;
use exam0919;

CREATE TABLE movie(
	movie_id INT NOT NULL auto_increment primary KEY,
    title varchar(255) NOT NULL,
    directior varchar(255) NOT NULL,
    genre varchar(255),
    synopsis TEXT,
    create_at 	timestamp default current_timestamp,
    password varchar(255) NOT NULL
);

CREATE TABLE discussion_post(
	post_id INT NOT NULL auto_increment primary KEY,
    movie_id INT NOT NULL,
	content TEXT NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at timestamp default current_timestamp,
    foreign key(movie_id) references movie(movie_id) ON DELETE cascade
);

# 샘플데이터
INSERT INTO movie (title, directior, genre, synopsis, password) VALUES
('기생충', '봉준호', '드라마, 스릴러', '전원 백수인 기택네 장남 기우가 고액 과외 면접을 위해 박 사장네 집에 발을 들이면서 시작되는 두 가족의 만남을 그린 이야기.', 'parasite'),
('명량', '김한민', '사극, 액션', '1597년 임진왜란, 단 12척의 배로 330척에 달하는 왜군의 공격에 맞선 이순신 장군의 명량해전.', 'myeongryang'),
('부산행', '연상호', '스릴러, 좀비', '정체불명의 바이러스가 대한민국을 뒤덮으면서 부산행 열차에 몸을 실은 사람들의 사투를 그린 영화.', 'busan'),
('괴물', '봉준호', 'SF, 드라마', '한강에 나타난 괴물과 맞서 싸우는 한 가족의 사투를 그린 이야기.', 'monster'),
('범죄도시', '강윤성', '액션, 범죄', '2004년 서울, 강력반 형사 마석도가 신흥 범죄조직을 소탕하기 위해 벌이는 통쾌한 액션 범죄 영화.', 'crimecity'),
('아저씨', '이정범', '액션, 범죄', '전직 특수요원 태식이 옆집 소녀를 구하기 위해 범죄조직에 맞서는 이야기.', 'ajusshi'),
('웰컴 투 동막골', '박광현', '전쟁, 드라마', '한국전쟁 당시 낯선 마을 동막골에 추락한 미군과 국군, 그리고 북한군이 겪는 따뜻하고 감동적인 이야기.', 'dongmakgol'),
('신세계', '박훈정', '범죄, 스릴러', '대한민국 최대 범죄조직에 잠입한 경찰 이자성이 펼치는 음모와 배신을 그린 느와르 영화.', 'newworld'),
('베테랑', '류승완', '액션, 범죄', '안하무인 재벌 3세를 쫓는 광역수사대 형사의 활약을 그린 범죄오락 액션 영화.', 'veteran'),
('도가니', '황동혁', '드라마', '청각장애인 학교에서 벌어진 성폭력 사건을 다룬 실화를 바탕으로 한 영화.', 'silenced');
INSERT INTO discussion_post (movie_id, content, password) VALUES
(1, '기생충은 정말 사회 비판적 메시지가 강한 영화인 것 같아요. 특히 계단 장면이 인상적이었어요.', 'gisaengchung'),
(1, '송강호 배우님의 연기력이 돋보이는 작품이었어요. 여러 번 봐도 새롭네요.', 'gisaengchung'),
(2, '명량 해전 장면은 CG라고 믿기 힘들 정도로 생생해서 몰입감이 대단했어요!', 'myeongryang'),
(3, '좀비물인데도 사회적 풍자가 담겨 있어서 좋았습니다. 단순한 공포 영화가 아니었어요.', 'busan'),
(4, '괴물은 단순한 괴수 영화가 아니라 가족의 사랑을 보여주는 따뜻한 영화였어요.', 'monster'),
(5, '마동석 배우님의 시원시원한 액션이 최고! 스트레스 풀려고 다시 봤어요.', 'crimecity'),
(6, '원빈 배우님 인생작이라고 생각합니다. 액션씬이 정말 멋있었어요.', 'ajusshi'),
(7, '전쟁 영화인데 이렇게 따뜻하고 아름다울 수 있다니... 엔딩이 특히 기억에 남아요.', 'dongmakgol'),
(8, '신세계는 반전의 반전을 거듭해서 끝까지 긴장감을 놓을 수 없게 만들어요.', 'newworld'),
(9, '유아인 배우님의 악역 연기가 정말 소름 돋았어요. 눈빛 하나로 압도하는 연기력.', 'veteran'),
(10, '이 영화를 보면서 사회에 대해 다시 한번 생각하게 되었습니다. 모두가 봐야 할 영화.', 'silenced');

select * FROM movie;
select * from discussion_post;
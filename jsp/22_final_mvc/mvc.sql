CREATE TABLE mvc_member(
	num INT primary key auto_increment,
	id VARCHAR(50) UNIQUE NOT NULL,
	pass VARCHAR(50) NOT NULL,
	name VARCHAR(50),
	age INT(3) default 0,
	gender VARCHAR(10),
	joinYN char(1) DEFAULT 'Y',
	regdate TIMESTAMP default now(),
	updatedate TIMESTAMP default now()
);
commit;

SELECT * FROM mvc_member;

-- 비밀번호 찾기에 사용될 코드를 저장할 테이블
CREATE TABLE test_code(
	id VARCHAR(50),
	code char(5)
);



-- 관리자 계정 추가
INSERT INTO mvc_member(id,pass,name,age,gender) 
VALUES('admin','admin','MASTER',0,'male');











-- 공 지 사 항
DESC notice_board;

SELECT * FROM notice_board
ORDER BY n_num DESC limit 0, 10;

-- 질문과 답변형 게시판
CREATE TABLE question_answer(
	qna_num INT PRIMARY KEY auto_increment, -- 글번호
	qna_title VARCHAR(50) NOT NULL,			-- 글 제목
	qna_content TEXT NOT NULL,				-- 글 내용
	qna_re_ref INT NOT NULL,				-- 원본글 번호
	qna_re_lev INT NOT NULL,				-- 답변글 뷰 번호
	qna_re_seq INT NOT NULL,				-- 답변글 정렬 번호
	qna_writer_num INT,						-- 작성자 회원 번호
	qna_readcount INT DEFAULT 0,			-- 조회 수
	qna_delete char(1) default 'N',			-- 글 삭제 여부
	qna_date TIMESTAMP default now()		-- 작성 시간
);

DESC question_answer;

ALTER TABLE question_answer 
ADD FOREIGN KEY(qna_writer_num)
REFERENCES mvc_member(num);

SELECT * FROM question_answer;

commit;

SELECT 
	Q.*,
	M.name AS qna_name
FROM question_answer AS Q, mvc_member AS M
WHERE Q.qna_writer_num = M.num 
ORDER BY qna_re_ref DESC , qna_re_seq ASC;




















CREATE TABLE IF NOT EXISTS tbl_member(
	userid VARCHAR(50),
    userpw VARCHAR(45),
    username VARCHAR(45),
    regdate timestamp default now(),
	updatedate timestamp default now()
);

DESC tbl_member;
commit;

SELECT * FROM tbl_member;

CREATE TABLE tbl_board(
	bno int PRIMARY KEY auto_increment,
    title VARCHAR(200) NOT NULL,
    content TEXT null,
    writer VARCHAR(20) NOT NULL,
    regdate TIMESTAMP NOT NULL default now(),
    viewcnt INT default 0
);
DESC tbl_board;

commit;

SELECT * FROM tbl_board;

INSERT INTO tbl_board(title,content,writer) 
SELECT title,content,writer FROM tbl_board;

commit;

SELECT * FROM tbl_board 
WHERE title LIKE '%게시물%'
ORDER BY bno DESC 
limit 0, 30;
commit;
SELECT * FROM tbl_board ORDER BY bno DESC limit 1;

CREATE TABLE tbl_comment(
	cno INT PRIMARY KEY auto_increment,
    bno INT NOT NULL default 0,
    commentText TEXT NOT NULL,
    commentAuth VARCHAR(50) NOT NULL ,
    regdate TIMESTAMP NOT NULL default now(),
    updatedate TIMESTAMP NOT NULL default now(),
	CONSTRAINT fx_tbl_bno FOREIGN KEY(bno)
    REFERENCES tbl_board(bno),
    INDEX(bno)
);

SELECT * FROM tbl_board WHERE bno = 1;

commit;

SELECT * FROM tbl_comment WHERE bno = 1;

DELETE FROM tbl_board WHERE bno = 1;

SELECT * FROM information_schema.table_constraints 
WHERE table_name = 'tbl_comment';

ALTER TABLE tbl_comment DROP FOREIGN KEY fx_tbl_bno;

ALTER TABLE tbl_comment ADD CONSTRAINT fk_tbl_bno 
FOREIGN KEY(bno) REFERENCES tbl_board(bno) ON DELETE CASCADE;

commit;


SELECT * FROM tbl_board WHERE bno = 1;

INSERT INTO tbl_board(bno,title,content,writer) 
VALUES(1,'게시물 제목','게시물 내용','PJS');

commit;

-- 답변형 게시판 table
CREATE TABLE re_tbl_board(
	bno INT PRIMARY KEY auto_increment,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    origin INT NOT NULL DEFAULT 0,
	depth INT NOT NULL default 0,
    seq INT NOT NULL default 0,
    regdate TIMESTAMP NOT NULL default now(),
    updatedate TIMESTAMP NOT NULL default now(),
    viewcnt INT NOT NULL default 0,
    showboard char(1) default 'y',
    uno INT NOT NULL,
    CONSTRAINT fk_re_tbl_uno FOREIGN KEY(uno)
    REFERENCES tbl_user(uno)
);

commit;
SELECT * FROM re_tbl_board;
commit;
SELECT R.*, U.uname AS writer FROM 
re_tbl_board AS R NATURAL JOIN tbl_user AS U 
ORDER BY R.origin DESC, R.seq ASC limit 0, 15; 



-- 첨부파일 목록 table
CREATE TABLE tbl_attach(
	fullName VARCHAR(200) NOT NULL,
    bno INT NOT NULL,
    regdate TIMESTAMP default now(),
    constraint fk_tbl_attach FOREIGN KEY(bno) 
    REFERENCES re_tbl_board(bno)
);

commit;
SELECT * FROM re_tbl_board WHERE bno = 15;
SELECT * FROM tbl_attach;
commit;
SELECT * FROM re_tbl_board ORDER BY bno DESC;

-- 
SELECT now();
SELECT sysdate();
SELECT curdate();
SELECT curtime();
SELECT date_add(now(), interval -1 day);
SELECT fullName FROM tbl_attach 
WHERE regdate = (CURDATE() - interval 1 day);

SELECT DATE_FORMAT(regdate,"%Y-%m-%d")
FROM tbl_attach;

SELECT fullName FROM tbl_attach 
WHERE 
DATE_FORMAT(regdate,"%Y-%m-%d") 
= 
date_format(date_sub(now(), interval 1 day),"%Y-%m-%d");


CREATE TABLE validation_member(
	u_no INT PRIMARY KEY auto_increment,
    u_id VARCHAR(50) NOT NULL UNIQUE,
    u_pw VARCHAR(200) NOT NULL,
    u_phone VARCHAR(20) NOT NULL,
    u_name VARCHAR(20) 

);

















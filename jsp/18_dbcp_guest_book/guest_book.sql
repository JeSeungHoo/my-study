-- 이름 , 비밀번호, 메세지
CREATE TABLE IF NOT EXISTS test_guestbook(
	id INT PRIMARY KEY auto_increment, -- 방명록 번호
	guestName VARCHAR(20) NOT NULL, 	-- 방명록 작성자
	password VARCHAR(30) NOT NULL,		-- 비밀번호
	message Text
);  

show tables;

commit;
SELECT * FROM test_guestbook ORDER BY id DESC;

INSERT INTO test_guestbook(guestName,password,message) 
SELECT guestName,password,message FROM test_guestbook;

SELECT * FROM test_guestbook;

commit;

SELECT * FROM test_guestbook 
ORDER BY id DESC limit 0, 10;

SELECT count(id) FROM test_guestbook;














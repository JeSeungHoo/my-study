use bigdata;

CREATE TABLE tbl_member(
	mNum INT PRIMARY KEY auto_increment,
	mName VARCHAR(50),
	mId VARCHAR(20) NOT NULL UNIQUE,
	mPw VARCHAR(30) NOT NULL,
	reg BIGINT DEFAULT 0
);

INSERT INTO tbl_member(mName,mId,mPw)
VALUES('관리자','root','root');

SELECT * FROM tbl_member;

commit;

-- 탈퇴한 회원의 정보를 임시 저장할 back_up table 생성
CREATE TABLE back_up_member LIKE tbl_member; 
-- SELECT * FROM tbl_member WHERE 1=0;
DESC back_up_member;

ALTER TABLE back_up_member 
ADD COLUMN deleteDate TIMESTAMP DEFAULT now();

INSERT INTO tbl_member(mName,mId,mPw)
VALUES('박주신','id002','pw002');
SELECT * FROm tbl_member;
 
SELECT LAST_INSERT_ID();
rollback;
commit;
SELECT * FROM tbl_member;
show table status WHERE name = 'tbl_member';
UPDATE tbl_member SET mNum = 2 WHERE mId = 'id001';
commit;
ALTER TABLE tbl_member auto_increment = 3;

-- 등록할 회원정보 입력
-- INSERT 후에 SELECT 반환 하는  프로시저 추가
DELIMITER $$ 
	CREATE PROCEDURE insert_member(
		IN _name VARCHAR(30),
        IN _id VARCHAR(100),
        IN _pw VARCHAR(100),
        IN _reg BIGINT
    )
BEGIN
		INSERT INTO tbl_member VALUES(null, _name, _id, _pw, _reg);
        SELECT * FROM tbl_member WHERE mNum = LAST_INSERT_ID();
END $$
DELIMITER ;

CALL insert_member('박주신','id002','pw002',0);

commit;
commit;
SELECT * FROM tbl_member;
SELECT * FROM back_up_member;

-- tbl_member table의 행정보가 DELETE 된후
-- back_up_member table에 삭제된 회원 정보 저장.
DELIMITER $$
	CREATE TRIGGER delete_member
    AFTER DELETE ON tbl_member FOR EACH ROW
BEGIN 
	INSERT INTO back_up_member 
    VALUES(OLD.mNum,OLD.mName,OLD.mId,OLD.mPw,OLD.reg,now());
END $$
DELIMITER ;






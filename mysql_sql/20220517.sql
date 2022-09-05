-- ctrl + enter
/*
	Create 명령어를 이용하여 
    database 또는 table 등 데이터를 정의하는
    구조를 생성
*/
-- CREATE SCHEMA `sqldb` ;
-- CREATE SCHEMA sqldb ;
use sqldb;

CREATE TABLE `sqldb`.`member_tbl` (
  `member_id` VARCHAR(50) NOT NULL COMMENT '회원을 구분짓는 아이디',
  `member_name` VARCHAR(45) NULL DEFAULT NULL COMMENT '회원의 이름',
  `member_addr` VARCHAR(45) NULL COMMENT '회원 배송 주소',
  PRIMARY KEY (`member_id`))
COMMENT = '회원정보에 대한 정보';


/*
 table 이름 : product_tbl 
 상품이름 : product_name VARCHAR(50),
 상품가격 : cost INT,
 제조날짜 : make_date VARCHAR(20),
 남은수량 : amount INT NULL
*/
CREATE TABLE `sqldb`.`product_tbl` (
  `product_name` VARCHAR(50) NOT NULL,
  `cost` INT NULL,
  `make_date` VARCHAR(20) NULL,
  `amount` INT NULL,
  PRIMARY KEY (`product_name`))
COMMENT = '상품 정보';

-- 지정된 데이터베이스의 테이블 이름 정보 확인
show tables;

-- product_tbl의 모든 열의 정보 검색
SELECT * FROM product_tbl;

-- sqldb schema or database 삭제
DROP DATABASE sqldb;

-- ----------------------------------
-- sqldb schema 생성
CREATE DATABASE sqldb;

-- testdb DATABASE 생성
-- testdb가 존재하지 않으면 create
CREATE SCHEMA IF NOT EXISTS testdb;

-- testdb 삭제
DROP DATABASE IF EXISTS testDB;

-- testdb 사용
USE testdb;

-- userTbl 회원정보 테이블 생성
CREATE TABLE IF NOT EXISTS userTbl(
	userID char(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    birthyear INT NOT NULL,
    addr char(2) NOT NULL,
    mobile1 char(3),
    mobile2 char(8),
    height smallint,
    mDate date
);

-- 상품 정보를 저장하는 테이블
CREATE TABLE IF NOT EXISTS prodoctTbl(
	num INT(8) NOT NULL PRIMARY KEY,
    userID char(8) NOT NULL,
    prodName char(6),
    groupName char(4),
    price char(5),
    count smallint NOT NULL
);

show tables;

DESCRIBE usertbl;
DESC usertbl;

-- 정의된 정보를 수정하는 keyword - ALTER
-- 상품 정보 테이블을 구매 정보 테이블로 변경
-- table 이름 수정
ALTER TABLE prodocttbl RENAME buyTBL;

show tables;

-- buyTBL 에 있는 price 속성에 dataType을 INT로 변경
ALTER TABLE buyTBL MODIFY price INT;

-- 변경 확인
DESC buyTBL;

-- buyTBL의 num 속성을 변경
-- auto_increment 1에서 부터 1씩 순차적으로
-- 삽입 되는 행 마다 저동으로 증가
-- MySQL에만 존재하며 PRINMARY KEY INT FILED에만 적용 가능
ALTER TABLE buyTBL modify
 num INT AUTO_INCREMENT;

-- buyTBL count열의 이름과 속성 변경
-- amount로 변경
ALTER TABLE buyTBL 
CHANGE count amount smallint NOT NULL;

DESC buyTBL;

-- 테이블에 행의 정보를 추가하는 DML
-- INSERT INTO VALUES
DESC userTBL;
INSERT INTO userTBL 
VALUES('PJS','박주신',1988,'평양',null,null,162,'1989-8-8');
INSERT INTO userTBL 
VALUES('PJS','박재신',1987,'서울',null,null,180,'1995-10-09');

SELECT * FROM userTBL;

DESC buyTBL;
INSERT INTO buyTBL 
VALUES(null,'PJS',"운동화",'의류',30, 1);

SELECT * FROM buyTBL;

INSERT INTO buyTBL 
VALUES(null,'PTH',"세탁기",'전자',400, 2);

SELECT * FROM userTBL;

SELECT * FROM buyTBL;

-- buyTBL의 userID 열정보를 
-- userTBL 테이블에 userID의 외래키로 지정
ALTER TABLE buyTBL ADD CONSTRAINT FOREIGN KEY(userID) 
REFERENCES userTBL(userID);

DESC buyTBL;

commit;
TRUNCATE buyTbl;
TRUNCATE userTBL;
-- 테이블에 존재하는 특정 행의 정보를 삭제하는 DML
-- DELETE FROM table명
DELETE FROM userTBL;
COMMIT;
SELECT * FROM userTBL;
-- WHERE 0 = 0;

-- SELECT column명 FROM table 명 WHERE 조건절
SELECT * FROM userTBL
WHERE name = '김범수';	
-- 조건절 : name 속성의 값이 '김범수'와 일치하는 사용자
-- userTBL 에서 userID가 BBK인 사람을 검색
SELECT * FROM userTBL 
WHERE userID = 'BBK';

-- 1970년 이후에 출생하고 키가 182 이상인 사람 검색
SELECT * FROM userTBL 
WHERE birthYear > 1970 AND height >= 182;

-- userTbl에서 경기에 사는 사람의 이름과 주소만 검색
SELECT name, addr FROM userTbl 
WHERE addr = '경기';

-- userTbl에서 1970 ~ 1979 사이에 태어난 사람의 이름 검색
-- 1970, 1979 포함
SELECT name FROM userTbl
WHERE birthyear >= 1970 AND birthyear <= 1979;

-- 키가 180이상 183이하인 사람의 이름,주소,키 정보 검색
SELECT name,addr,height FROM userTBL
WHERE height >= 180 AND height < 184;

-- BETWEEN 범위값 AND 범위값
SELECT * FROM userTBL 
WHERE height BETWEEN 180 AND 183;

-- userTbl에서 주소가 '경남'이거나 '전남' 이거나 '경북'인 사람 검색
SELECT * FROM userTbl
WHERE addr = '경남' OR addr = '전남' OR addr = '경북';
-- 동일한 속성에서 특정 조건들을 만족하는 정보를 검색
-- WHERE IN
SELECT * FROM userTbl 
WHERE addr IN('경북','경기','전남');

-- LIKE wildcard[ % || _ ]를 활용한 검색
-- 와일드 카드를 이용하여 1970년대 출생한 사람 찾기 1970 ~ 1979
SELECT * FROM userTbl WHERE birthyear LIKE '197_';

-- userTbl에서 성이 '김'씨 인 모든 사용자 정보 검색
SELECT * FROM userTbl 
WHERE name LIKE '김__';

-- userTbl에서 이름 사이에 '시' 가 들어가는 사용자 검색
SELECT * FROM userTbl 
WHERE name LIKE '_시_';
-- 김으로 시작하고 뒤에는 무슨 값이든 상관없음.
SELECT * FROM userTbl 
WHERE name LIKE '김%';

-- NULL 값 비교
SELECT * FROM userTbl;
-- userTbl에서 mobile1 핸드폰 번호가 없는 사용자 정보 검색
SELECT * FROM userTbl 
WHERE mobile1 = null;

-- NULL 비교 연산 할떄는 WHERE IS
SELECT * FROM userTbl 
WHERE mobile1 IS NULL;

-- 전화번호가 존재하는 사용자
SELECT * FROM userTbl 
WHERE mobile1 IS NOT NULL;

-- 거주지(주소)가 서울이 아닌 사람 검색
SELECT * FROM userTbl 
WHERE addr != '서울';

SELECT * FROM userTbl 
WHERE NOT addr = '서울';

SELECT * FROM userTbl 
WHERE addr <> '서울';

-- 전화번호 시작(mobile1) 016,018,019 인 사람들 검색
SELECT * FROM userTBL 
-- WHERE mobile1 in('016','018',019);
WHERE mobile1 = '016' OR mobile1 = '018' OR mobile1 = 019;

SELECT * FROM userTBL 
WHERE NOT mobile1 in('016','018',019);

-- height 키가  170이상인 사람 검색
SELECT * FROM userTBL 
WHERE height >= 170;
-- 이름이 '김경호' 인 사람의 '키' 검색
SELECT height FROM userTBL 
WHERE name = '김경호';
-- 177
-- 김경호와 키가 같거나 큰 사람의 이름과 키를 검색
SELECT name, height FROM userTbl 
WHERE height >= 177;

SELECT name, height FROM userTbl 
WHERE height >= (
	SELECT height FROM userTBL 
	WHERE name = '김경호'
);


















































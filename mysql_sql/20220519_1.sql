-- auto commit 설정
SELECT @@autocommit;
-- 0 자동으로 commit 실행 안함
-- 1 autocommit
set autocommit = 0;

use sqldb;
SELECT * FROM buytbl4;
UPDATE buytbl4 SET price = 0;
rollback;

set autocommit = 1;
SELECT @@autocommit;
UPDATE buytbl4 SET price = price + 10;
SELECT * FROM buytbl4;
rollback;

set autocommit = 0;

-- 계정 생성  권한 부여& 회수
-- 사용자 계정 생성 
-- CREATE USER 계정명@접속위치 IDENTIFIED BY 비밀번호;
-- 컴퓨터 주소 : IP
-- % : 어디서나 접근 가능
-- localhost : 현재 컴퓨터에서만 접근 가능

use mysql;
-- 사용자 계정 정보
SELECT * FROM user;

SELECT user, host FROM user;
-- user1
-- 1234
CREATE USER user1@'localhost' IDENTIFIED BY '1234';
SHOW GRANTS FOR user1@'localhost';
SHOW GRANTS FOR root@'localhost';
-- user1@'localhost' 계정 삭제
DROP user user1@'localhost';

CREATE USER 'pm'@'%' IDENTIFIED BY '1234';

-- 권한 부여
GRANT ALL ON *.* TO pm@'%' WITH GRANT OPTION;
SHOW GRANTS FOR pm@'%';

CREATE USER 'staff'@'%' IDENTIFIED BY '1234';

GRANT SELECT,UPDATE,INSERT,DELETE ON sqlDB.* TO staff@'%';
SHOW GRANTS FOR staff@'%';

CREATE USER 'ceo'@'%' IDENTIFIED BY '1234';
GRANT SELECT,INSERT,UPDATE ON sqldb.* TO ceo@'%';

SELECT user,host FROM user;





























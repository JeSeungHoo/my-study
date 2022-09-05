CREATE DATABASE big_test;
CREATE SCHEMA big_test;
use big_test;

-- 1-2 DML
DESC big_test.emp;
INSERT INTO emp 
VALUES(8000,'MASTER','SALESMAN',7839,'1982-06-07',1200,500,40);
commit;
UPDATE emp SET comm = 600 WHERE empno = 7566; 
SELECT * FROM emp;
DELETE FROM emp WHERE empno = 8000;

-- 1-3 TRANSACTION
SELECT @@AUTOCOMMIT;
-- 0 == false,   1 == true
SET @@AUTOCOMMIT = 1;
SET @@AUTOCOMMIT = 0;
SET @@AUTOCOMMIT = FALSE;

SELECT * FROM emp;
DELETE FROM emp;
rollback;
commit;

-- 2_1 부서별 인원 출력 하되 부서이름순으로 정렬 전체인원도 출력
SELECT deptno, count(*) AS '부서별 인원' FROM emp 
GROUP BY deptno WITH ROLLUP;

-- 2_2 계정 생성
CREATE USER testUser@'localhost' IDENTIFIED BY '12345';
SELECT * FROM mysql.USER WHERE user = 'testUser';

-- 2_3 권한 부여
GRANT SELECT, INSERT, DELETE, UPDATE ON 
big_test.* TO testUser@'localhost';
-- 해당 계정에 부여된 권한 정보 확인
SHOW GRANTS FOR testUser@'localhost';

-- 3_1 stored procedure 
-- 급여가 2000이상인 사원의 사원번호와 이름, 부서명을 부서 순으로
-- 구하는 프로시저를 작성하라.
DELIMITER //
	CREATE PROCEDURE test3_1()
    BEGIN 
		SELECT 
			empno, ename, dname
        FROM emp e NATURAL JOIN dept d 
        WHERE e.sal >= 2000 ORDER BY e.deptno;
    END //
DELIMITER ;

SELECT 
	empno, ename, dname
FROM emp, dept WHERE emp.deptno = dept.deptno 
AND emp.sal >= 2000 ORDER BY emp.deptno ASC;

CALL test3_1();

-- 3_2 매개변수가 있는 저장 프로시저
-- 사원번호와 부서번호를 전달받아서 
-- 사원번호가 일치하는 사원의 부서를 전달받은 부서로 변경
DELIMITER $$ 
	CREATE PROCEDURE test3_2(IN vEmpno INT, IN vDeptno INT)
    BEGIN
		UPDATE emp SET deptno = vDeptno 
        WHERE empno = vEmpno;
    END $$
DELIMITER ;

SELECT * FROM emp WHERE empno = 7369;
CALL test3_2(7369,10);

-- 3_3 TRIGGER
-- emp table과 구조가 동일한 back_up_emp table 생성
-- emp table에서 사원 정보가 DELETE(삭제)되면
-- back_up_emp table에 저장
CREATE TABLE back_up_emp AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE back_up_emp LIKE emp;


DELIMITER $$
	CREATE TRIGGER backup_emp_trg	-- 트리거 이름
    AFTER DELETE 					-- 트리거 수행 시점	
    ON emp							-- 트리거를 부착할 테이블
    FOR EACH ROW 
BEGIN
	-- OLD, INSERT UPDATE == NEW
    INSERT INTO back_up_emp 
    VALUES(OLD.empno,OLD.ename,OLD.job,OLD.mgr,
    OLD.hiredate,OLD.sal,OLD.comm,OLD.deptno);
END $$
DELIMITER ;

DELETE FROM emp WHERE empno = 7369;
SELECT * FROM emp;
SELECT * FROM back_up_emp;
rollback;

-- 4-1 INDEX 생성
-- emp ename속성에 INDEX를 부여
CREATE INDEX index_emp_ename ON emp(ename);
ALTER TABLE emp ADD INDEX idx_emp_ename(ename);

-- 4_2 emp 테이블에 부여된 index 목록 확인
SHOW INDEXES FROM big_test.emp;

-- 4_3 INDEX 삭제
DROP INDEX index_emp_ename ON big_test.emp;
SHOW INDEXES FROM big_test.emp;
ALTER TABLE big_test.emp DROP INDEX idx_emp_ename;




SELECT * FROM tbl_account;
truncate tbl_account;
commit;










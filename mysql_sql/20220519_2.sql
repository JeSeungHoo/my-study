CREATE DATABASE bigdata;

SELECT * FROM dept;
SELECT * FROM emp;

-- 변수 선언과 초기화
SET @val1 = 10;
SET @val2 = 3;
SET @val3 = 3.14;
SET @val4 = '안녕';

-- @를 변수를 표시
-- @ 사용자 변수
-- @@ 시스템 변수
-- 		= 비교연산자또는 대입연산자로 사용
-- := 대입연산자
SET @val5 := 10;

SELECT @val1 FROM dual;
SELECT @val2 + @val3;

/*******************************************/
-- MySQL 내장 함수
-- dual table
-- 데이터가 없고, 함수계산을 위해 사용하는 가상의 테이블
-- 모든 RDBMS에  존재하는 테스트용 테이블

SELECT 1+1 FROM dual;

-- 현재 날짜와 시간에 대해 알려주는 함수
SELECT sysdate(), now(), curdate(), curtime(), current_timestamp() 
FROM dual;

-- 현재 사용자 정보
SELECT current_user() FROM dual;
SELECT user() FROM dual;

-- 문자열 관련된 함수
-- 대소문자 처리 
SELECT 'Welcome to Mysql',
upper('Welcome to Mysql'),
lower('Welcome to Mysql');

-- 문자열 길이 - byte크기 
SELECT length('MySQL') , length('마이에스큐엘');

SET @temp = 'Welcome to MySQL';
-- 문자열 추출
-- (문자열,시작위치,개수)
SELECT substr(@temp,4,3);
-- 음수는 뒤에서 부터
SELECT substr(@temp,-4,3);

SELECT hiredate FROM emp;
-- 사원의 정보를 사원번호, 사원명, 입사년도, 월로 출력
-- hiredate 0000-00-00
DESC emp;
SELECT empno, ename, substr(hiredate,1,4) AS '입사년도', 
substr(hiredate,6,2) AS '월' FROM emp;

-- 특정문자의 위치
SELECT instr('WELCOME TO MYSQL','O'); -- 5
SELECT instr('Welcome To MYSQL','O'); -- 5
SELECT instr('이것이 MYSQL이다','다');	-- 11

-- 문자열에 공백을 제거하는 함수
-- '               MySQL'
SELECT '               MySQL';
SELECT ltrim('               MySQL');
SELECT rtrim('         MySQL      ');
-- 양쪽에서 특정문자 제거
SELECT trim('a' FROM 'aaaaMySQLalaaa');
SELECT trim(' ' FROM '    MySQLal   ');

-- 문자열을 넘겨받은 매개변수들을 묶어주는 함수
SELECT concat(ename,'은',sal,'를 받습니다.') FROM emp ORDER BY sal DESC;

-- 날짜 관련 함수
SELECT sysdate() FROM dual;
SELECT sysdate() - INTERVAL 1 day AS 어제, 
	   sysdate() AS 오늘,
       sysdate() + INTERVAL 1 day AS 내일;
-- 한달전       
SELECT sysdate() - INTERVAL 1 month;
-- 1년전
SELECT sysdate() - INTERVAL 1 year;
-- 10년 후
SELECT sysdate() + INTERVAL 10 year;
-- 기준시간 + 계산시간
-- date_add(기준시간,계산시간);
-- 1분 후
SELECT now(), date_add(now(), INTERVAL 1 MINUTE);
-- 1분 전
SELECT now(), date_add(now(), INTERVAL -1 MINUTE);
-- 1분 전
SELECT now(), date_sub(now(), INTERVAL 1 MINUTE);
-- 1분 후
SELECT now(), date_sub(now(), INTERVAL -1 MINUTE);

-- 두 시간 사이의 간격(차이)를 계산
SELECT empno, ename, hiredate, now(), 
timestampdiff(year,hiredate,now()) FROM emp;

-- 날짜를 형식에 맞는 문자열로 반환하는 함수
-- data_format 
/*
	%Y 4자리 년도		%y 2자리년도
    %m 숫자 월(2자리) %c 월 (1자리)
    %M 긴 월(영문)	%b 짧은 월(영문)
	%d 일자(두자리)	%e 일자(한자리)
    %W(요일 이름 영문) %a (짧은 영문 요일)
	%I 시간(12)		%H 시간 (24)
    %i 분     		%S 초
    %r hh:mm:ss AM,PM
    %T HH:mm:ss
*/
SELECT now(), date_format(now(),'%Y/%m/%d');
SELECT now(), date_format(now(), '%y/%m/%d %T');

-- CASE 
-- 사원이름 부서번호 부서명을 출력
SELECT * FROM emp;
SELECT * FROM dept;
DESC emp;
SELECT ename, deptno, 
	CASE WHEN deptno = 10 THEN 'ACCOUNTING' 
		 WHEN deptno = 20 THEN 'RESEARCH'
         WHEN deptno = 30 THEN 'SALES'
         WHEN deptno = 40 THEN 'OPERAITINGS'
	END AS dname
FROM emp;

-- Query문을 미리 등록 시켜놓고 필요한 것을 후에 전달하는
-- PREPARE EXCUTE문
-- PREPARE 이름 FROM 'Query문';
-- EXECUTE 이름 USING 전달데이터;
PREPARE mQuery FROM 
'SELECT ename, sal FROM emp ORDER BY sal LIMIT ?';

SET @tempVal = 3;
EXECUTE mQuery USING @tempVal;
SET @tempVal = 10;
EXECUTE mQuery USING @tempVal;

/*************************************************************/
-- JOIN : 다수의 테이블 정보를 합쳐 원하는 정보를 검색하는 것
-- cross join
SELECT * FROM emp, dept;
SELECT count(*) FROM emp;		-- 14
SELECT count(*) FROM dept;		--  4
SELECT count(*) FROM emp, dept;	-- 56

-- INNER JOIN - 일반적으로 가장 많이 사용되는 형태
-- 기준 테이블과 조인 테이블 모두 데이터가 존재해야 조회됨.
-- SELECT * FROM emp JOIN dept;
SELECT * FROM emp INNER JOIN dept;
SELECT count(*) FROM emp INNER JOIN dept;	-- 56
SELECT * FROM emp, dept 
WHERE emp.deptno = dept.deptno;

SELECT emp.*, dept.* FROM emp INNER JOIN dept 
ON emp.deptno = dept.deptno;

-- natural join -- 중복되는 속성을 기준으로 조인
SELECT * FROM emp NATURAL JOIN dept
ORDER BY emp.empno;

-- 조인을 사용해서 뉴욕에서 근무하는 사원의 이름과 급여 출력
SELECT emp.ename, emp.sal 
FROM emp, dept 
WHERE emp.deptno = dept.deptno 
AND dept.loc = "NEW YORK";

-- join을 이용하여 SCOTT이 근무하는 부서이름 출력
SELECT dname FROM emp, dept 
WHERE emp.deptno = dept.deptno 
AND emp.ename = 'SCOTT';

SELECT dname FROM emp NATURAL JOIN dept 
WHERE emp.ename = 'SCOTT';

-- sub query
SELECT dname FROM dept 
WHERE deptno = (
	SELECT deptno FROM emp WHERE ename = 'SCOTT'
);

-- SELF JOIN 
-- 사원의 이름과 그 사원의 매니저 이름을 출력하기
SELECT * FROM emp;

SELECT a.ename AS 사원, b.ename AS 매니저
FROM emp AS a, emp AS b
WHERE a.mgr = b.empno;

-- SCOTT 이랑 동일한 근무지에 근무하는 사람의 사원명 출력
-- SCOTT 제외
SELECT 
	a.ename , b.ename
FROM emp AS a , emp AS b 
WHERE a.deptno = b.deptno AND a.ename = 'SCOTT' 
AND b.ename != 'SCOTT';

-- outer join
-- LEFT / RIGHT JOIN
-- 일치하지 않는 값이라도 남아 있는 테이블 값이 존재하면 검색에 포함.
-- 사원의 이름과 매니저의 이름을 출력 
-- 매니저가 아닌사람의 목록도 같이 출력
SELECT * FROM emp;
SELECT A.ename, B.ename FROM emp A RIGHT JOIN emp B 
ON A.mgr = B.empno ORDER BY A.ename DESC;

-- 매니저가 없는 사원의 정보도 출력
SELECT A.ename, B.ename FROM emp A LEFT JOIN emp B 
ON A.mgr = B.empno ORDER BY A.ename DESC;

-- emp table과 salgrade table을 join하여
-- 각 사원의 급여 등급을 사원명, 급여, 급여등급 으로 출력
SELECT 
	e.ename, e.sal, s.grade 
FROM emp e, salgrade s 
WHERE e.sal BETWEEN s.losal AND s.hisal;

-- 급여등급별 인원수와, 평균급여 출력
-- 급여 등급, 인원수, 평균급여
SELECT 
	s.grade, count(*), avg(e.sal) 
FROM emp e , salgrade s 
WHERE e.sal BETWEEN s.losal AND s.hisal 
GROUP BY s.grade ORDER BY s.grade DESC;



















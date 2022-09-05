show databases;
show tables;

SELECT * FROM usertbl;
SELECT * FROM testdb.usertbl;

-- 권한 회수
REVOKE UPDATE, INSERT ON sqldb.* FROM ceo@'%';


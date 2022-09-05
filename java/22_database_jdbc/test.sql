-- alt + x , alt + c
SELECT * FROM member_tbl;

show tables;

CREATE TABLE student(
	stuNo INT PRIMARY KEY auto_increment,
	stuName VARCHAR(50),
	stuDept VARCHAR(50),
	stuGrade INT,
	stuClass char(1) DEFAULT 'A',
	stuGender char(1) DEFAULT 'F',
	stuDate TIMESTAMP DEFAULT now()
);

show tables;

DESC student;

commit;
SELECT * FROM student;


call checkYear('바비킴');

SELECT * FROM userTbl
WHERE name='바비킴';

















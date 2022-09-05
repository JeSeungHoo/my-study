-- AOP TEST TABLE
CREATE TABLE tbl_user(
	uno INT PRIMARY KEY auto_increment,
    uid VARCHAR(50) NOT NULL UNIQUE,
    upw VARCHAR(50) NOT NULL,
    uname VARCHAR(50) NOT NULL,
    upoint INT NOT NULL default 0
);

CREATE TABLE tbl_message(
	mno INT PRIMARY KEY auto_increment,
    targetid VARCHAR(50) NOT NULL,  -- 수신자
    sender VARCHAR(50) NOT NULL,	-- 발신자
    message TEXT NOT NULL,			-- 메세지
    opendate TIMESTAMP NULL,		-- 메세지 읽은 시간
    senddate TIMESTAMP NOT NULL default now(), -- 발신 시간
    FOREIGN KEY(targetid) REFERENCES tbl_user(uid),
    FOREIGN KEY(sender) REFERENCES tbl_user(uid)
);

INSERT INTO tbl_user(uid,upw,uname) 
VALUES('id001','pw001','IRON MAN');

INSERT INTO tbl_user(uid,upw,uname) 
VALUES('id002','pw002','THOR');

INSERT INTO tbl_user(uid,upw,uname) 
VALUES('id003','pw003','DR.strange');

commit;

SELECT * FROM tbl_message;
commit;
SELECT * FROM tbl_user;
-- id002 80, id001 30

CREATE TABLE ban_ip(
	ip VARCHAR(50) primary key,
    cnt INT DEFAULT 1,
    bandate TIMESTAMP DEFAULT now()
);

commit;

SELECT * FROM ban_ip;






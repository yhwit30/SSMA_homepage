DROP DATABASE IF EXISTS SSMA_DB;
CREATE DATABASE SSMA_DB;
USE SSMA_DB;


# artist 테이블 생성
CREATE TABLE artist(
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    `name` CHAR(100) NOT NULL,
    `gender` CHAR(20) NOT NULL,
    `birth` DATE NOT NULL
);


INSERT INTO artist
SET regDate = NOW(),
updateDate = NOW(),
`name` = '아무개',
`gender` = '남',
`birth`= '1994.10.23';

INSERT INTO artist
SET regDate = NOW(),
updateDate = NOW(),
`name` = '여성주',
`gender` = '여',
`birth`= '1987.8.23';

INSERT INTO artist
SET regDate = NOW(),
updateDate = NOW(),
`name` = '남성미',
`gender` = '남',
`birth`= '1990.1.10';




SELECT * FROM artist;


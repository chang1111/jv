-- 1. book_db 데이터베이스가 있으면 삭제.
-- 2. book_db 데이터베이스 생성
drop database if exists book_db;
create database book_db  collate 'utf8_general_ci' ;

-- 사용자 추가
GRANT ALL ON book_db.* TO tester1@localhost IDENTIFIED BY '1234';
FLUSH PRIVILEGES;

-- 3. 생성된 book_db 들어가기
use book_db;

-- 4. auth 테이블이 있으면 테이블 삭제.
drop table if exists book       ; -- book 테이블

-- 7. book 테이블이 있으면 테이블 삭제.
drop table if exists auth       ; -- auth 테이블


-- 5. auth 테이블생성
create table auth (
      authid    int  primary key
    , name      varchar(50)
    , birth     varchar(10)
);

-- 8. book 테이블 생성
create table book (
      bookid        int not null auto_increment primary key
    , bookname      varchar(50)
    , publisher     varchar(40)
    , year          varchar(10)
    , price         int
    , dtm           date
    , use_yn        bit
    , authid        int
);

-- 6. auth 테이블 데이터 insert
insert into auth( authid, name, birth)   values(  1, 'bob' , '1970.05.01' ) ;
insert into auth( authid, name, birth)   values(  2, 'kim' , '1980.05.01' ) ;
insert into auth( authid, name, birth)   values(  7, 'park', '2000.05.01' ) ;


-- 9. book 테이블 데이터 insert
insert into book(bookname, publisher, year, price, dtm, use_yn, authid) values('operating system'  , 'wiley'     , '2003', 30700, '2004-01-01', 0, 1 ) ;
insert into book(bookname, publisher, year, price, dtm, use_yn, authid) values('mysql'             , 'oreilly'   , '2009', 58700, '2010-01-01', 1, 2 ) ;
insert into book(bookname, publisher, year, price, dtm, use_yn, authid) values('java'              , 'hall'      , '2013', 40000, '2014-01-01', 1, 3 ) ;
insert into book(bookname, publisher, year, price, dtm, use_yn, authid) values('first sql'         , 'wiley'     , '2015', 57700, '2016-01-01', 1, 4 ) ;

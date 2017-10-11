-- 부서 테이블 제거하기
BEGIN EXECUTE IMMEDIATE 'DROP TABLE EMP'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
-- 사원 테이블 제거하기
BEGIN EXECUTE IMMEDIATE 'DROP TABLE DEPT'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
-- 급여 테이블 제거하기
BEGIN EXECUTE IMMEDIATE 'DROP TABLE SALGRADE'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
-- GROUP_STAR 테이블 제거하기
BEGIN EXECUTE IMMEDIATE 'DROP TABLE GROUP_STAR'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
-- SINGLE_STAR 테이블 제거하기
BEGIN EXECUTE IMMEDIATE 'DROP TABLE SINGLE_STAR'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/


-- 부서 테이블 생성하기
CREATE TABLE DEPT(
     DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY,
     DNAME VARCHAR2(14),
     LOC   VARCHAR2(13) 
);

-- 사원 테이블 생성하기
CREATE TABLE EMP( 
     EMPNO NUMBER(4) CONSTRAINT PK_EMP PRIMARY KEY,
     ENAME VARCHAR2(10),
     JOB   VARCHAR2(9),
     MGR  NUMBER(4),
     HIREDATE DATE,
     SAL NUMBER(7,2),
     COMM NUMBER(7,2),
     DEPTNO NUMBER(2) CONSTRAINT FK_DEPTNO REFERENCES DEPT
);

 -- 급여 테이블 생성하기
CREATE TABLE SALGRADE(
     GRADE NUMBER,
     LOSAL NUMBER,
     HISAL NUMBER 
);


-- GROUP_STAR 테이블 생성하기
CREATE TABLE GROUP_STAR(
    NAME        VARCHAR2(50)
);

-- SINGLE_STAR 테이블 생성하기
CREATE TABLE SINGLE_STAR(
    NICKNAME    VARCHAR2(50)
);     
     

-- 사원 테이블에 샘플 데이터 추가하기
INSERT INTO DEPT VALUES(10, '경리부', '서울');
INSERT INTO DEPT VALUES(11, '회계팀', '서울');
INSERT INTO DEPT VALUES(20, '인사부', '인천');
INSERT INTO DEPT VALUES(21, 'HR팀'  , '인천');
INSERT INTO DEPT VALUES(30, '영업부', '용인'); 
INSERT INTO DEPT VALUES(31, '개발팀', '용인'); 
INSERT INTO DEPT VALUES(40, '전산부', '수원');
INSERT INTO DEPT VALUES(41, '서버부', '수원');


-- 부서 테이블에 샘플 데이터 추가하기
INSERT INTO EMP VALUES(1001, '김사랑', '사원', 1013, to_date('2007-03-01','yyyy-mm-dd'), 300, NULL, 20);
INSERT INTO EMP VALUES(1002, '한예슬', '대리', 1005, to_date('2007-04-02','yyyy-mm-dd'), 250,   80, 30);
INSERT INTO EMP VALUES(1003, '오지호', '과장', 1005, to_date('2005-02-10','yyyy-mm-dd'), 500,  100, 30);
INSERT INTO EMP VALUES(1004, '이병헌', '부장', 1008, to_date('2003-09-02','yyyy-mm-dd'), 600, NULL, 20);
INSERT INTO EMP VALUES(1005, '신동협', '과장', 1009, to_date('2005-04-07','yyyy-mm-dd'), 450,  200, 30);
INSERT INTO EMP VALUES(1006, '장동건', '부장', 1008, to_date('2003-10-09','yyyy-mm-dd'), 480, NULL, 30);
INSERT INTO EMP VALUES(1007, '이문세', '부장', 1008, to_date('2004-01-08','yyyy-mm-dd'), 520, NULL, 10);
INSERT INTO EMP VALUES(1008, '감우성', '차장', 1003, to_date('2004-03-08','yyyy-mm-dd'), 500,    0, 30);
INSERT INTO EMP VALUES(1009, '안성기', '사장', NULL, to_date('1996-10-04','yyyy-mm-dd'),1000, NULL, 20);
INSERT INTO EMP VALUES(1010, '이병헌', '과장', 1003, to_date('2005-04-07','yyyy-mm-dd'), 500, NULL, 10);
INSERT INTO EMP VALUES(1011, '조향기', '사원', 1007, to_date('2007-03-01','yyyy-mm-dd'), 280, NULL, 30);
INSERT INTO EMP VALUES(1012, '강혜정', '사원', 1006, to_date('2007-08-09','yyyy-mm-dd'), 300, NULL, 20);
INSERT INTO EMP VALUES(1013, '박중훈', '부장', 1003, to_date('2002-10-09','yyyy-mm-dd'), 560, NULL, 20);
INSERT INTO EMP VALUES(1014, '조인성', '사원', 1006, to_date('2007-11-09','yyyy-mm-dd'), 250, NULL, 10);
INSERT INTO EMP VALUES(1015, '김현수', '사원', 1008, to_date('2012-11-09','yyyy-mm-dd'), 250, NULL, 31);
INSERT INTO EMP VALUES(1016, '강정호', '사원', 1008, to_date('2013-01-09','yyyy-mm-dd'), 250, NULL, 31);
INSERT INTO EMP VALUES(1017, '이대호', '사원', 1008, to_date('2011-03-09','yyyy-mm-dd'), 250, NULL, 31);
INSERT INTO EMP VALUES(1018, '추신수', '대리', 1004, to_date('2016-10-04','yyyy-mm-dd'),1000, NULL, 21);



-- 급여 테이블에 샘플 데이터 추가하기
INSERT INTO SALGRADE VALUES (1, 700,1200);
INSERT INTO SALGRADE VALUES (2, 1201,1400);
INSERT INTO SALGRADE VALUES (3, 1401,2000);
INSERT INTO SALGRADE VALUES (4, 2001,3000);
INSERT INTO SALGRADE VALUES (5, 3001,9999);


-- GROUP_STAR 테이블에 샘플 데이터 추가하기
INSERT INTO GROUP_STAR VALUES('태연');
INSERT INTO GROUP_STAR VALUES('유리');
INSERT INTO GROUP_STAR VALUES('윤아');
INSERT INTO GROUP_STAR VALUES('효연');
INSERT INTO GROUP_STAR VALUES('티파니');
INSERT INTO GROUP_STAR VALUES('제시카');
INSERT INTO GROUP_STAR VALUES('수영');
INSERT INTO GROUP_STAR VALUES('써니');
INSERT INTO GROUP_STAR VALUES('서현');
INSERT INTO GROUP_STAR VALUES('탑');
INSERT INTO GROUP_STAR VALUES('지드래곤');
INSERT INTO GROUP_STAR VALUES('대성');
INSERT INTO GROUP_STAR VALUES('승리');
INSERT INTO GROUP_STAR VALUES('태양');


-- SINGLE_STAR 테이블에 샘플 데이터 추가하기
INSERT INTO SINGLE_STAR VALUES('태연');
INSERT INTO SINGLE_STAR VALUES('지드래곤');
INSERT INTO SINGLE_STAR VALUES('대성');
INSERT INTO SINGLE_STAR VALUES('태양');
INSERT INTO SINGLE_STAR VALUES('아이유');
INSERT INTO SINGLE_STAR VALUES('백지영');
INSERT INTO SINGLE_STAR VALUES('윤종신');

COMMIT;




-- 주문 테이블 제거하기 
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Orders'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
-- 도서 테이블 제거하기
BEGIN EXECUTE IMMEDIATE 'DROP TABLE book'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
-- 저자 테이블 제거하기 
BEGIN EXECUTE IMMEDIATE 'DROP TABLE auth'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
-- 고객 테이블 제거하기 
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Customer'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/


-- auth 테이블 
CREATE TABLE auth (
      authid    NUMBER(10)  PRIMARY KEY
    , name      VARCHAR(50)
    , birth     VARCHAR(10)
);


-- book 테이블 생성
CREATE TABLE book (
      bookid        NUMBER(10) GENERATED AS IDENTITY 
    , bookname      VARCHAR(50)
    , publisher     VARCHAR(40)
    , year          VARCHAR(10)
    , price         NUMBER(10)
    , dtm           DATE
    , use_yn        NUMBER(1) CHECK ( use_yn = 0 OR use_yn = 1 ) 
    , authid        NUMBER(10)
    
    , PRIMARY KEY( bookid )
);

-- 고객 테이블 생성
CREATE TABLE  Customer (
      custid        NUMBER(2) PRIMARY KEY  
    , name          VARCHAR2(40)
    , address       VARCHAR2(50)
    , phone         VARCHAR2(20)
);

-- 주문 테이블 생성
CREATE TABLE Orders (
      orderid       NUMBER(2) PRIMARY KEY 
    , custid        NUMBER(2) REFERENCES Customer(custid)
    , bookid        NUMBER(2) REFERENCES Book(bookid)
    , saleprice     NUMBER(8) 
    , orderdate     DATE
);


-- Auth, Book, Customer, Orders 데이터 생성
INSERT INTO auth( authid, name, birth)   VALUES( 1, 'bob' , '1970.05.01' ) ;
INSERT INTO auth( authid, name, birth)   VALUES( 2, 'kim' , '1980.05.01' ) ;
INSERT INTO auth( authid, name, birth)   VALUES( 7, 'park', '2000.05.01' ) ;


INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid) VALUES('Operating System'  , 'Wiley'     , '2003', 30700, '2004-01-01', 0, 1 ) ;
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid) VALUES('MySQL'             , 'OReilly'   , '2009', 58700, '2010-01-01', 1, 2 ) ;
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid) VALUES('JAVA'              , 'Hall'      , '2013', 40000, '2014-01-01', 1, 3 ) ;
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid) VALUES('First SQL'         , 'Wiley'     , '2015', 57700, '2016-01-01', 1, 4 ) ;

INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('축구의 역사'      , '굿스포츠'  , '2001',  7000, '2001-01-01', 1,  1);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('축구아는 여자'    , '나무수'    , '2002', 13000, '2002-02-02', 1,  2);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('축구의 이해'      , '대한미디어', '2003', 22000, '2003-03-03', 1,  3);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('골프 바이블'      , '대한미디어', '2004', 35000, '2004-04-04', 1,  4);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('피겨 교본'        , '굿스포츠'  , '2005',  8000, '2005-05-05', 1,  5);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('역도 단계별기술'  , '굿스포츠'  , '2006',  6000, '2006-06-06', 1,  6);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('야구의 추억'      , '이상미디어', '2007', 20000, '2007-07-07', 1,  7);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('야구를 부탁해'    , '이상미디어', '2008', 13000, '2008-08-08', 1,  8);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('올림픽 이야기'    , '삼성당'    , '2009',  7500, '2009-09-09', 1,  9);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('Olympic Champions', 'Pearson'   , '2010', 13000, '2010-10-10', 1, 10);


INSERT INTO Customer VALUES (1, '박지성', '영국 맨체스타'  , '000-5000-0001');
INSERT INTO Customer VALUES (2, '김연아', '대한민국 서울'  , '000-6000-0001');  
INSERT INTO Customer VALUES (3, '장미란', '대한민국 강원도', '000-7000-0001');
INSERT INTO Customer VALUES (4, '추신수', '미국 클리블랜드', '000-8000-0001');
INSERT INTO Customer VALUES (5, '박세리', '대한민국 대전'  ,  NULL);


-- 주문(Orders) 테이블의 책값은 할인 판매를 가정함
INSERT INTO Orders VALUES ( 1, 1,  5,  6000, TO_DATE('2014-07-01', 'yyyy-mm-dd') ); 
INSERT INTO Orders VALUES ( 2, 1,  7, 21000, TO_DATE('2014-07-03', 'yyyy-mm-dd') );
INSERT INTO Orders VALUES ( 3, 2,  9,  8000, TO_DATE('2014-07-03', 'yyyy-mm-dd') ); 
INSERT INTO Orders VALUES ( 4, 3, 10,  6000, TO_DATE('2014-07-04', 'yyyy-mm-dd') ); 
INSERT INTO Orders VALUES ( 5, 4, 11, 20000, TO_DATE('2014-07-05', 'yyyy-mm-dd') );
INSERT INTO Orders VALUES ( 6, 1,  6, 12000, TO_DATE('2014-07-07', 'yyyy-mm-dd') );
INSERT INTO Orders VALUES ( 7, 4, 12, 13000, TO_DATE('2014-07-07', 'yyyy-mm-dd') );
INSERT INTO Orders VALUES ( 8, 3, 14, 12000, TO_DATE('2014-07-08', 'yyyy-mm-dd') ); 
INSERT INTO Orders VALUES ( 9, 2, 14,  7000, TO_DATE('2014-07-09', 'yyyy-mm-dd') ); 
INSERT INTO Orders VALUES (10, 3, 12, 13000, TO_DATE('2014-07-10', 'yyyy-mm-dd') );


COMMIT;



-- 재귀적, 계층형 쿼리 예제 데이터
-- 부서 테이블 제거하기
BEGIN EXECUTE IMMEDIATE 'DROP TABLE 부서'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/

-- 실적 테이블 제거하기
BEGIN EXECUTE IMMEDIATE 'DROP TABLE 실적'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/


CREATE TABLE 부서 ( 
      부서코드 VARCHAR2(4) PRIMARY KEY
    , 부서명 VARCHAR2(30) NOT NULL
    , 상위부서코드 VARCHAR2(4) NULL
);

CREATE TABLE 실적  ( 
      년월 VARCHAR2(7) NOT NULL
    , 부서코드 VARCHAR2(4) NOT NULL
    , 금액 NUMBER(10) NOT NULL       
    
    , CONSTRAINT PK_실적 PRIMARY KEY (년월, 부서코드)
);

INSERT INTO 부서
SELECT '1000', '대표이사'   , NULL    FROM DUAL UNION ALL
SELECT '1100', '영업1본부'  , '1000'  FROM DUAL UNION ALL
SELECT '1200', '영업2본부'  , '1000'  FROM DUAL UNION ALL
SELECT '1110', '국내영업1부', '1100'  FROM DUAL UNION ALL
SELECT '1120', '국내영업2부', '1100'  FROM DUAL UNION ALL
SELECT '1210', '해외영업1부', '1200'  FROM DUAL UNION ALL
SELECT '1220', '해외영업2부', '1200'  FROM DUAL UNION ALL
SELECT '1111', '수도권지부' , '1110'  FROM DUAL UNION ALL
SELECT '1112', '강원지부'   , '1110'  FROM DUAL UNION ALL
SELECT '1121', '호남지부'   , '1120'  FROM DUAL UNION ALL
SELECT '1122', '경남지부'   , '1120'  FROM DUAL
;

INSERT INTO 실적
SELECT '2013.07', '1210', 1000  FROM DUAL UNION ALL
SELECT '2013.07', '1220', 1000  FROM DUAL UNION ALL
SELECT '2013.07', '1111', 1000  FROM DUAL UNION ALL
SELECT '2013.07', '1112', 1000  FROM DUAL UNION ALL
SELECT '2013.07', '1121', 1000  FROM DUAL UNION ALL
SELECT '2013.07', '1122', 1000  FROM DUAL
;

COMMIT;


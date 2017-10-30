-- ######################################2
-- 테이블 CUD
-- 테이블 추가           : CREATE TABLE  테이블명                   ;
-- 테이블 변경           : ALTER  TABLE  테이블명                   ; 
-- 테이블 삭제           : DROP   TABLE  테이블명                   ;
-- 테이블 이름 바꾸기    : Mysql : rename table 원본테이블명 to 새테이블;
--                         Oracle : rename  
-- 테이블 복제           : Mysql : CREATE TABLE 새테이블명 AS SELECT * FROM 원본테이블;
--                         Oracle : SELECT *  INTO 새테이블명 FROM 원본테이블;
-- 테이블 로우 제거     :  MySQL : 
--                      :  Oralce : TRUNCATE TABLE 테이블명                 ; // DELETE 보다 속도가 빠름.
-- ######################################2


-- ######################################2
-- 테이블 컬럼 CUD
-- 테이블 컬럼 추가      : ALTER  TABLE  테이블명 ADD          컬럼이름 컬럼타입 
-- 테이블 컬럼 삭제      : ALTER  TABLE  테이블명 DROP  COLUMN 컬럼이름 
-- 테이블 컬럼 변경 타입 : ALTER  TABLE  테이블명 ALTER COLUMN 컬럼이름 컬럼타입
-- 테이블 제약 변경 조건 : ALTER  TABLE  테이블명 ALTER COLUMN 컬럼이름 컬럼타입
-- 테이블 컬럼 변경 이름 : EXEC SP_RENAME '테이블이름.컬럼이름' , '새컬럼이름', 'COLUMN'
-- ######################################2

-- dept01 테이블을 삭제하시오.
-- MySQL  : DROP TABLE if exits 테이블명 ;
-- Oracle : BEGIN EXECUTE IMMEDIATE 'DROP TABLE 테이블명'; 
--          EXCEPTION WHEN OTHERS THEN NULL; 
--          END;
--          /      -- 중요. 빠트리지 마시오. 줄바꿈을 해야 적용 됨.


-- dept01 테이블을 DDL을 이용하여  추가하시오.
-- 컬럼에는 
-- ename     : 문자열
-- job       : 문자열
-- email     : 문자열 
-- address   : 문자열
-- sex       : F 또는 M  두개중에 한개만 저장될 수 있게.
-- phone     : 문자열. 11자리~15자리
-- birthday  : 생일. 날짜만 저장.
-- birthtime : 생시. 시간만 저장.
-- age       : 정수. 999 까지만 저장가능하게. 
-- height    : 실수. 정수부분은 3자리, 소수부분은 2자리까지.


-- dept01 테이블을 삭제하시오.


-- @@@@@@
-- dept01 테이블을 테이블 디자이너를 이용하여 추가하시오.
-- 
-- 
-- 컬럼에는 
-- ename     : 문자열
-- job       : 문자열
-- email     : 문자열 
-- address   : 문자열
-- sex       : F 또는 M  두개중에 한개만 저장될 수 있게.
-- phone     : 문자열. 11자리~15자리
-- birthday  : 생일. 날짜만 저장.
-- birthtime : 생시. 시간만 저장.
-- age       : 정수. 999 까지만 저장가능하게. 
-- height    : 실수. 정수부분은 3자리, 소수부분은 2자리까지.
-- @@@@@@


-- @@@@@@
-- dept01 테이블을 수정하시오.
-- email 컬럼에 not null 을 설정하시오.
-- @@@@@@


-- @@@@@@
-- dept01 테이블에 insert를 이용하여 데이터를 입력하시오. 
-- ename: abc, 나머지 컬럼 값은 null로 입력
-- email 때문에 에러 발생
-- @@@@@@


-- @@@@@@
-- 문제. dept01 테이블에 salary 컬럼을 추가하되
-- 타입은 숫자형으로 하고 정수 10자리와 소수점 3자리,
-- 그리고 not null 조건을 설정하시오.
-- @@@@@@


-- @@@@@@
-- 문제. 컬럼 타입 수정
-- dept01 테이블의 addres 컬럼 타입을 nvarchar(1000)으로 바꾸시오.
-- @@@@@@


-- @@@@@@
-- 문제. 컬럼 삭제
-- dept01 테이블에서 birthtime 컬럼을 삭제하시오.
-- @@@@@@



-- 테이블 이름 바꾸기
-- dept01 을 dept_new로 바꾸시오.


-- @@@@@@
-- 테이블 복제
-- 테이블 구조와 데이터를 복제 : CREATE TABLE 새로만들테이블명 AS SELECT * FROM 복사할테이블명;
-- 테이블 구조만 복제          : CREATE TABLE 새로만들테이블명 LIKE 복사할테이블명;
-- 
-- 테이블 복제시 제약 조건은 복제 되지 않는다.
-- @@@@@@

-- dept 테이블의 구조와 데이터를 복제해서 dept02 테이블을 만드시오.


-- dept 테이블 구조만 복제해서 dept03 테이블을 만드시오. 데이터는 복제하지 마시오.


-- 문제. dept 테이블에 auto_increment를 갖는 pid 컬럼 를 추가하시오.
-- auto_increment 로 설정하려면 반드시 key 가 되어야 한다.
-- pid 컬럼 추가.
-- pid 컬럼에  key 추가


-- 문제. emp 테이블의 구조와 데이터를 복제해서 dept11 테이블을 만드시오.
-- 테이블 목록 출력
-- 컬럼 목록 출력
-- 데이터 출력


-- 문제. emp 테이블의 구조만 복제해서 dept12 테이블을 만드시오.
-- 테이블 목록 출력
-- 컬럼 목록 출력
-- 데이터 출력


-- @@@@@@
-- 테이블 데이터 삭제
--     DELETE    :  테이블 상태 유지  . auto_increment 정보가 유지.
--     TRUNCATE  :  테이블 상태 초기화. auto_increment 정보가 초기화.
-- @@@@@@

-- 아래와 같이 tbtest 테이블을 만들고 데이터를 입력하시오.
-- +-------+---------------+------+-----+---------+----------------+
-- | Field | Type          | Null | Key | Default | Extra          |
-- +-------+---------------+------+-----+---------+----------------+
-- | pid   | int(11)       | NO   | PRI | NULL    | auto_increment |
-- | val   | varchar(1000) | YES  |     | NULL    |                |
-- +-------+---------------+------+-----+---------+----------------+
-- +-----------------+
-- |  pid   |  val   |
-- +-----------------+  
-- |   1    |   a    |
-- |   2    |   b    |
-- |   3    |   c    |
-- |   4    |   d    |
-- +-----------------+  


-- a,b,c,d를 입력하는 insert 문을 작성하시오.


-- e, f, g ,h를 한번에 입력하는 multi insert 문을 작성하시오.


-- 문제. tbtest 테이블에서 delete을 사용하여 데이터를 제거 후
--       tbtest 테이블에 a1 값을 입력.
-- +-----------------+
-- |  pid   |  val   |
-- +-----------------+  
-- |   9    |   a1   |
-- +-----------------+  


-- 문제. tbtest 테이블에서 truncate을 사용하여 데이터를 제거한 후
--       tbtest 테이블에 a2 값을 입력.
-- +-----------------+
-- |  pid   |  val   |
-- +-----------------+  
-- |   1    |   a2   |
-- +-----------------+  


-- ########################
-- Database 목록 조회
-- MySQL  : show databases ;
-- Oracle : 
-- ########################
show databases ;

-- ########################
-- 테이블 목록 조회 
-- MySQL  : show tables ;
-- Oracle : 
-- ########################
show tables; 

-- ########################
-- 컬럼 목록 조회
-- MySQL  : show columns from 테이블명 ;
-- Oracle : 
-- ########################
show columns from dept ;




-- ########################
-- index 확인
-- MySQL  : show index from 테이블명 ;
-- Oracle : 
-- ########################
show index from dept ;



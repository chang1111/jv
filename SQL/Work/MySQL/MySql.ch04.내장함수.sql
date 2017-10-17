﻿-- @@@@@@@@@@
-- from 절 생략 여부
-- MySql  : from 절 생략 가능
-- MsSql  : from 절 생략 가능
-- Oracle : from 절 생략 불가. dual 테이블 사용.
--          dual 테이블은 oracle에만 있는 1행1열의 테이블이다.
--          dual 테이블은 단순 계산이나 연산을 위해서 사용된다.
-- @@@@@@@@@@

-- 24*35의 계산 결과를 출력하시오.



-- @@@@@@@@@@
-- 숫자 관련 함수
-- @@@@@@@@@@

-- floor : 2356.2578 의 정수값 구하시오.


-- round : 2356.2578 을 반올림하시오.
-- round를 이용하여 2356.2578 에서 정수만 출력하시오.


-- round를 이용하여 2356.2578의 정수 두번째 자리에서 반올림하여  출력하시오.


-- round를 이용하여 2356.2578의 소수 세번째 자리에서 반올림하여  출력하시오.


-- 버림: 
-- MySQL  : truncate 
-- Oracle : trunc

-- truncate(trunc)를 이용하여 2356.2578 에서 정수만 출력하시오. 2356


-- truncate(trunc)를 이용하여 2356.2578의 정수 두번째 자리에서 버리시오. 2300


-- truncate(trunc)를 이용하여 2356.2578의 소수 세번째 자리에서 버리시오. 2356.25



-- 나머지 구하기: mod
-- mod를 이용하여 2356을 3으로 나눈 나머지를 구하시오. 1





-- @@@@@@@@@@
-- 문자 관련 함수 
-- @@@@@@@@@@

-- 문자 길이 구하기. length(). 'kfa 가나다' 의 길이로 처리하시오. 13
-- MySQL  : 한글은 3byte, 영문자는 1byte
-- Oracle : 한글은 2byte, 영문자는 1byte




-- 바이트 길이 구하기. 한글은 2byte, 영문자는 1byte




-- 문자열 추출. 
-- MySQL  : substring
-- Oracle : substr





-- 왼쪽에 기호 채우기. lpad




-- 오른쪽에 기호 채우기. rpad




-- 문자열 바꾸기. replace


-- 대문자 변환 : upper(). "fa ofakfo 강" 을 대문자로 바꾸시오.


-- 소문자 변환 : lower(). "FA OFAKFO 강" 을 소문자로 바꾸시오.



-- @@@@@@@@@@
-- 날짜 관련 함수 
-- MySQL  : now(), curdate(), curtime(), date_format(), date_add(), date_sub()
-- Oracle : sysdate , systimestamp     ,     to_date()
-- @@@@@@@@@@

-- 현재 날짜와 시간을 출력하시오



-- 현재 날짜만 출력하시오


-- 현재 시간만 출력하시오


-- 날짜와 format







-- 현재 날짜를 'YYYY/MM/DD' 포맷으로 출력하시오


-- 문제. emp 테이블에서 이름(ename)과 입사일(hiredate) 출력하되 입사일(hiredate)은 "연도2자리/월/일" 형태로 출력하시오.


-- emp 테이블에서 입사일(hiredate)을 '연도4자리-월-일' 포맷으로 출력하시오.


-- 시간과 format





-- 현재 시간를 'hh:mm:ss' 포맷으로 출력하시오




-- 이번달의 첫째날 구하기.


-- 이번달의 첫째날 요일 구하기


-- 이번달의 첫째날 요일 구하기. 일반화


     
-- 문제. emp 테이블에서 입사일(hiredate)과 입사일의 요일이 출력하되도록 하시오.


-- 해당 월의 마지막 일을 출력하시오.



-- 문제. emp 테이블에서 입사일(hiredate)과 입사할 달의 마지말 일을 출력하되도록 하시오.


-- 오늘은 이번달의 몇 주차인가? dayofweek


-- 지금부터 '2014-01-01'까지의 개월 수 차이를 계산하시오. 


-- 지금부터 '2014-01-01'까지의 년수 차이를 계산하시오.


-- 문제. 지금부터 '2014-01-01'까지의 일수를 계산하시오.


-- 오늘 날짜에 6개월 후를 계산하시오.


-- 오늘 날짜에 -6개월 전을 계산하시오.


-- 문제. 오늘 날짜에 17년후를 계산하시오.




-- @@@@@@@@@@
-- 형변환 함수 
-- SQL 데이터 타입 : 날짜(date) <--> 문자(character) <--> 숫자(number)
-- MySQL  : convert() : 
-- Oracle : to_char, to_date, to_number
-- @@@@@@@@@@

-- 현재일자를 문자열로 변환. 날짜 --> 문자로 : YYYY, MM, DD




-- 현재시간을 문자열로 변환. 날짜 --> 문자로 : hh:mm, hh:mm:ss



-- 문자를 날짜로 변환. 문자 --> 날짜. 변환 후에는 DATE 포맷이 된다.




-- 문자를 숫자로 변환






-- 문제. 문자 20,000,000.73797874857848 을 실수로 바꾸시오.





-- @@@@@@@@@@
-- 통화 기호 붙이기.
-- MySql  : 안됨.
-- Oracle : 가능.
-- @@@@@@@@@@





-- @@@@@@@@@@
-- 윤달 테이블 만들기
-- @@@@@@@@@@
select last_day( '2001-02-01' )  union
select last_day( '2002-02-01' )  union
select last_day( '2003-02-01' )  union
select last_day( '2004-02-01' )  union
select last_day( '2005-02-01' )  union
select last_day( '2006-02-01' )  union
select last_day( '2007-02-01' )  union
select last_day( '2008-02-01' )  union
select last_day( '2009-02-01' )  union
select last_day( '2010-02-01' )  union
select last_day( '2011-02-01' )  union
select last_day( '2012-02-01' )  union
select last_day( '2013-02-01' )  union
select last_day( '2014-02-01' )  union
select last_day( '2015-02-01' )  union
select last_day( '2016-02-01' )  union
select last_day( '2017-02-01' )  union
select last_day( '2018-02-01' )  union
select last_day( '2019-02-01' )  union
select last_day( '2020-02-01' )  union
select last_day( '2021-02-01' )  union
select last_day( '2022-02-01' )  union
select last_day( '2023-02-01' )  union
select last_day( '2024-02-01' )  union
select last_day( '2025-02-01' )  union
select last_day( '2026-02-01' )  
;


-- @@@@@@@@@@
-- NULL을 처리하는 함수 
-- MySQL  : ifnull(), if()
-- Oracle : nvl()
-- @@@@@@@@@@
select ifnull( null, 1);
select ifnull( 0   , 1);
select ifnull( '0' , 1);



-- @@@@@@@@@@
-- 선택 함수 : CASE 문. 자바의 연속if 와 유사
-- CASE WHEN THEN ELSE 
-- @@@@@@@@@@ 


-- CASE WHEN THEN ELSE 를 사용하여 부서명을 출력하시오.
-- deptno = 10  이면 경리부
-- deptno = 20  이면 인사과
-- deptno = 30  이면 영업부
-- deptno = 40  이면 전산부
-- 아니면 나머지부








 

-- CASE WHEN THEN ELSE 를 사용하여 지금부터 가장 가까운 수요일은 몇 일후 인가? 
-- case when then else 을 이용하시오.
-- if( dayofweek( now() ) <= 4)  {
-- 		4 -  dayofweek( now()     )
-- }
-- else {
--		4 + (7-dayofweek( now() ) )
-- }








-- @@@@@@@@@@@@@@
-- 미션
-- @@@@@@@@@@@@@@
-- 미션 1. 문자열 추출(substring, substr) 함수를 사용하여 9월에 입사한 사원을 출력하기. 1개
-- 오늘 날짜에서 월을 추출하려면


-- 입사일(hiredate)에서 월을 추출하려면


-- 9월에 입사한 직원을 찾아서 출력하시오.


-- 미션 2. SUBSTR 함수를 이용하여 2003년도에 입사한 사원을 검색하기. 2개


-- 미션 3. 이름(ename)이 '기'로 끝나는 사원을 검색하시오. 2개


-- 미션 4. 이름의 두 번째 글자에 '동'이 있는 사원을 검색하기. 2개
select * from emp where ename like '_동%';

-- 미션 5. 직급(job)에 따라 직급에 따라 급여를 인상하시오.
-- '부장'인 사원은 5% 인상 
-- '과장'인 사원은 10% 인상
-- '대리'인 사원은 15% 인상 
-- '사원'인 사원은 20% 인상









-- 미션 6. 입사일을 연도는 2자리(YY), 
--         월은 숫자로 표시하고 
--         요일은 약어(DY)로 출력하시오.
-- 구글 검색을 이용 
-- 구글 검색을 이용 : http://aesya.tistory.com/15




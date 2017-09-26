-- @@@@@@@@@@
-- 계산이나 단순 연산을 위해서 사용.
-- @@@@@@@@@@

-- 24*35의 계산 결과를 출력하시오.

-- 현재 날짜와 시간을 출력하시오

-- 현재 날짜를 출력하시오

-- 현재  시간을 출력하시오


-- @@@@@@@@@@
-- 숫자 관련 함수
-- @@@@@@@@@@

-- 정수값 구하기: floor

-- 반올림: round

-- 버림: truncate

-- 나머지 구하기: mod



-- @@@@@@@@@@
-- 문자 관련 함수 : substring
-- @@@@@@@@@@

-- 대문자 변환 : upper()

-- 소문자 변환 : lower()

-- 문자 길이 구하기. length(). 한글은 2byte, 영문자는 1byte

-- 바이트 길이 구하기. 한글은 2byte, 영문자는 1byte


-- 문자열 추출. substring

-- 왼쪽에 기호 채우기. lpad

-- 오른쪽에 기호 채우기. rpad

-- 문자열 바꾸기. replace



-- @@@@@@@@@@
-- 날짜 관련 함수 : now(), date_format(), date_add(), date_sub()
-- @@@@@@@@@@

-- 현재 날짜와 시간을 출력하시오

-- 현재 날짜를 출력하시오

-- 현재  시간을 출력하시오

-- 현재 날짜를 'YYYY/MM/DD' 포맷으로 출력하시오

-- 현재 날짜를 'YYYY-MM-DD' 포맷으로 출력하시오



-- 현재 시간를 'hh:mm:ss' 포맷으로 출력하시오


-- 이번달의 첫째날 요일 구하기

-- 오늘은 이번달의 몇 주차인가?

-- 지금부터 '2014-01-01'까지의 개월 수 구하기

-- 오늘 날짜에 6개월 추가하기

-- 오늘 날짜에 -6개월 추가하기

-- 지금부터 가장 가까운 수요일은 몇일후 인가?

-- 지금부터 가장 가까운 수요일은 몇일인가?

-- 해당 월의 마지막 일을 구하기



-- @@@@@@@@@@
-- 윤달 테이블 만들기
-- @@@@@@@@@@





-- @@@@@@@@@@
-- 형변환 함수 : convert() : date <--> character <--> number
-- @@@@@@@@@@

-- 현재일자를 문자열로 변환 : YYYY, MM, DD

-- 현재시간을 문자열로 변환

-- 통화 기호 붙이기.MySql 안됨.


-- 문자를 날짜로 변환. 변환 후 DATE 포맷이 된다.

-- 문자를 숫자로 변환


-- 문자를 숫자로 변환시 숫자의 포맷 지정하기


-- 문자를 숫자로 변환: 20,000,000.73797874857848 을 숫자로 바꾸시오.



-- @@@@@@@@@@
-- NULL을 처리하는 함수 : ifnull()
-- @@@@@@@@@@

-- ifnull 사용법



-- @@@@@@@@@@
-- 선택 함수 : CASE 문. 자바의 연속if 와 유사
-- CASE WHEN ELSE 
-- @@@@@@@@@@ 


-- CASE WHEN ELSE
 




-- @@@@@@@@@@@@@@
-- 미션
-- @@@@@@@@@@@@@@
-- 미션 1. substring 함수를 사용하여 9월에 입사한 사원을 출력하기. 1개
select hiredate, substring( hiredate, 6, 2) from emp ;

select * from emp where substring( hiredate, 6, 2) = '09' ;


-- 미션 2. SUBSTR 함수를 이용하여 2003년도에 입사한 사원을 검색하기. 2개
select hiredate, substring( hiredate, 1, 4) from emp ;
select * from emp where substring( hiredate, 1, 4) = '2003' ;

-- 미션 3. 이름(ename)이 '기'로 끝나는 사원을 검색하시오. 2개
select * from emp where ename like '%기';


-- 미션 4. 이름의 두 번째 글자에 '동'이 있는 사원을 검색하기. 2개
select * from emp where ename like '_동%';


-- 미션 5. 직급(job)에 따라 직급에 따라 급여를 인상하시오.
-- '부장'인 사원은 5% 인상 
-- '과장'인 사원은 10% 인상
-- '대리'인 사원은 15% 인상 
-- '사원'인 사원은 20% 인상
select distinct job from emp;
select ename, sal, case when job ='사원' then sal * ( 1+0.2 )
		                 when job ='대리' then sal * ( 1+0.15)
		                 when job ='과장' then sal * ( 1+0.1 )
		                 when job ='부장' then sal * ( 1+0.05)
		                 else sal
		            end newsal
 from emp;            


-- 미션 6. 입사일을 연도는 2자리(YY), 
--         월은 숫자로 표시하고 
--         요일은 약어(DY)로 출력하시오.
-- 구글 검색을 이용 
select hiredate, date_format( hiredate, '%y %c %W') from emp;



-- 검색
SELECT title,  publisher,  price,  authid FROM book;
SELECT * FROM book;
SELECT * FROM book WHERE title like '%SQL%';
SELECT * FROM book WHERE 30700 <= price and price <50000;
SELECT * FROM book WHERE price BETWEEN 30700 AND 50000;
SELECT * FROM book WHERE price <= 30700 or 58000 < price ;



-- 정렬
SELECT * FROM book ORDER BY price ASC;   
SELECT * FROM book ORDER BY price DESC;    
SELECT * FROM book ORDER BY publisher ASC, price DESC;    



-- 수정
SELECT * FROM book 
WHERE year='2003' and publisher ='Wiley' ;
 
UPDATE book
   SET year='1993'
 WHERE year='2003' and publisher ='Wiley' ; 
 
SELECT * FROM book WHERE publisher ='Wiley' ; 



-- 수정
SELECT * FROM book 
WHERE title = 'First SQL' ;
 
UPDATE book
   SET price=70000
WHERE title = 'First SQL' ;      
        
SELECT * FROM book 
 WHERE title = 'First SQL' ; 



-- 수정
SELECT * FROM book WHERE title like '%SQL%' ; 
UPDATE book
   SET year = '2016'
 WHERE title like '%SQL%' ; 
SELECT * FROM book WHERE title like '%SQL%' ;



-- 수정
SELECT * FROM book WHERE title like '%SQL%' ; 
UPDATE book
   SET year = '2010'
     , price = 20000
 WHERE title like '%SQL%' ; 
SELECT * FROM book WHERE title like '%SQL%' ;



-- 삭제
SELECT * FROM book WHERE publisher ='Wiley' ;
DELETE FROM book
 WHERE publisher ='Wiley' ;
SELECT * FROM book WHERE publisher ='Wiley' ;



-- 추가: insert
insert into test(testid  , name)
          values( 'test1', 'test1');

insert into test( testid )
          values( 'test2');

select * from test;



-- join
select * from auth;
select * from book;



-- inner join
select book.*, auth.*
  from book
       inner join auth on book.authid = auth.authid ;


-- left join
select book.*, auth.*
  from book
       left join auth on book.authid = auth.authid ;
       
       
-- right join
select book.*, auth.*
  from book
       right join auth on book.authid = auth.authid ;
       
              
-- cross join
select book.*, auth.*
  from book
       cross join auth  ;

 

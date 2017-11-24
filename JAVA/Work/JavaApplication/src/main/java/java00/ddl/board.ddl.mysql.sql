
-- springboard 데이터베이스 구조 내보내기
DROP DATABASE IF EXISTS springboard;

CREATE DATABASE springboard DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


-- 사용자 추가
GRANT ALL ON springboard.* TO tester1@localhost IDENTIFIED BY '1234';


FLUSH PRIVILEGES;



-- 데이터베이스 변경
USE springboard;


DROP TABLE IF EXISTS TB_Bbs_Article;
DROP TABLE IF EXISTS TB_Bbs_Board;

-- 게시판 종류 테이블
CREATE TABLE IF NOT EXISTS  TB_Bbs_Board (
      boardcd       NVARCHAR(20)   NOT NULL
    , boardnm       NVARCHAR(40)   NOT NULL
                                   
    , UseYN         TINYINT(1)     NULL   DEFAULT  1 
                                   
    , InsertUID     VARCHAR(40)    NULL                            
    , InsertDT      DateTime       NULL
    , UpdateUID     VARCHAR(40)    NULL                            
    , UpdateDT      DateTime       NULL
    
    , PRIMARY KEY(boardcd)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

insert into TB_Bbs_Board(boardcd, boardnm) values ('free','자유게시판');
insert into TB_Bbs_Board(boardcd, boardnm) values ('qna' ,'QnA게시판' );
insert into TB_Bbs_Board(boardcd, boardnm) values ('data','자료실'    );

select * from TB_Bbs_Board;



-- 게시글 테이블
CREATE TABLE IF NOT EXISTS  TB_Bbs_Article (
      articleno     INT UNSIGNED  NOT NULL AUTO_INCREMENT
    , boardcd       NVARCHAR(20)
    , title         NVARCHAR(200) NOT NULL
    , content       MEDIUMTEXT
    , email         NVARCHAR(60)
    , hit           INT UNSIGNED  DEFAULT  0   
    , regdate       DateTime
        
    , countgood     INT  DEFAULT  0  -- 좋아요.
    , countbad      INT  DEFAULT  0  -- 나빠요.
                       
    , UseYN         TINYINT(1)    NOT NULL   DEFAULT  1  
                                  
    , InsertUID     VARCHAR(40)   NULL                            
    , InsertDT      DateTime      NULL
    , UpdateUID     VARCHAR(40)   NULL                            
    , UpdateDT      DateTime      NULL
    
    , PRIMARY KEY(articleno)
    , FOREIGN KEY(boardcd) REFERENCES TB_Bbs_Board(boardcd)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  01", "article test  01", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  02", "article test  02", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  03", "article test  03", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  04", "article test  04", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  05", "article test  05", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  06", "article test  06", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  07", "article test  07", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  08", "article test  08", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  09", "article test  09", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  10", "article test  10", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  11", "article test  11", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  12", "article test  12", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  13", "article test  13", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  14", "article test  14", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  15", "article test  15", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  16", "article test  16", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  17", "article test  17", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  18", "article test  18", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  19", "article test  19", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  20", "article test  20", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  21", "article test  21", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  22", "article test  22", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  23", "article test  23", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  24", "article test  24", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  25", "article test  25", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  26", "article test  26", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  27", "article test  27", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  28", "article test  28", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  29", "article test  29", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  30", "article test  30", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  31", "article test  31", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  32", "article test  32", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  33", "article test  33", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  34", "article test  34", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  35", "article test  35", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  36", "article test  36", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  37", "article test  37", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  38", "article test  38", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  39", "article test  39", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  40", "article test  40", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  41", "article test  41", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  42", "article test  42", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  43", "article test  43", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  44", "article test  44", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  45", "article test  45", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  46", "article test  46", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  47", "article test  47", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  48", "article test  48", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  49", "article test  49", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  50", "article test  50", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  51", "article test  51", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  52", "article test  52", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  53", "article test  53", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  54", "article test  54", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  55", "article test  55", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  56", "article test  56", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  57", "article test  57", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  58", "article test  58", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  59", "article test  59", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  60", "article test  60", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  61", "article test  61", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  62", "article test  62", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  63", "article test  63", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  64", "article test  64", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  65", "article test  65", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  66", "article test  66", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  67", "article test  67", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  68", "article test  68", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  69", "article test  69", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  70", "article test  70", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  71", "article test  71", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  72", "article test  72", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  73", "article test  73", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  74", "article test  74", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  75", "article test  75", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  76", "article test  76", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  77", "article test  77", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  78", "article test  78", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  79", "article test  79", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  80", "article test  80", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  81", "article test  81", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  82", "article test  82", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  83", "article test  83", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  84", "article test  84", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  85", "article test  85", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  86", "article test  86", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  87", "article test  87", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  88", "article test  88", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  89", "article test  89", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  90", "article test  90", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  91", "article test  91", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  92", "article test  92", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  93", "article test  93", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  94", "article test  94", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  95", "article test  95", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  96", "article test  96", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  97", "article test  97", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  98", "article test  98", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test  99", "article test  99", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 100", "article test 100", "aa@aa.co.kr", 0, now(), 1 );

insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 101", "article test 101", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 102", "article test 102", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 103", "article test 103", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 104", "article test 104", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 105", "article test 105", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 106", "article test 106", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 107", "article test 107", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 108", "article test 108", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 109", "article test 109", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 110", "article test 110", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 111", "article test 111", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 112", "article test 112", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 113", "article test 113", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 114", "article test 114", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 115", "article test 115", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 116", "article test 116", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 117", "article test 117", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 118", "article test 118", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 119", "article test 119", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 120", "article test 120", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 121", "article test 121", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 122", "article test 122", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 123", "article test 123", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 124", "article test 124", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 125", "article test 125", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 126", "article test 126", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 127", "article test 127", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 128", "article test 128", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 129", "article test 129", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 130", "article test 130", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 131", "article test 131", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 132", "article test 132", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 133", "article test 133", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 134", "article test 134", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 135", "article test 135", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 136", "article test 136", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 137", "article test 137", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 138", "article test 138", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 139", "article test 139", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 140", "article test 140", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 141", "article test 141", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 142", "article test 142", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 143", "article test 143", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 144", "article test 144", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 145", "article test 145", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 146", "article test 146", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 147", "article test 147", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 148", "article test 148", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 149", "article test 149", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 150", "article test 150", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 151", "article test 151", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 152", "article test 152", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 153", "article test 153", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 154", "article test 154", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 155", "article test 155", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 156", "article test 156", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 157", "article test 157", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 158", "article test 158", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 159", "article test 159", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 160", "article test 160", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 161", "article test 161", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 162", "article test 162", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 163", "article test 163", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 164", "article test 164", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 165", "article test 165", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 166", "article test 166", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 167", "article test 167", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 168", "article test 168", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 169", "article test 169", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 170", "article test 170", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 171", "article test 171", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 172", "article test 172", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 173", "article test 173", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 174", "article test 174", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 175", "article test 175", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 176", "article test 176", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 177", "article test 177", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 178", "article test 178", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 179", "article test 179", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 180", "article test 180", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 181", "article test 181", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 182", "article test 182", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 183", "article test 183", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 184", "article test 184", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 185", "article test 185", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 186", "article test 186", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 187", "article test 187", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 188", "article test 188", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 189", "article test 189", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 190", "article test 190", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 191", "article test 191", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 192", "article test 192", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 193", "article test 193", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 194", "article test 194", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 195", "article test 195", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 196", "article test 196", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 197", "article test 197", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 198", "article test 198", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 199", "article test 199", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 200", "article test 200", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 201", "article test 201", "aa@aa.co.kr", 0, now(), 1 );


select * from TB_Bbs_Article;



-- 덧글 테이블
DROP TABLE IF EXISTS TB_Bbs_Comments;
CREATE TABLE IF NOT EXISTS  TB_Bbs_Comments (
      commentno     INT UNSIGNED     NOT NULL AUTO_INCREMENT
    , articleno     INT UNSIGNED     NOT NULL     
    , email         NVARCHAR(60)  
    , memo          NVARCHAR(4000)
    , regdate       DateTime 
                       
    , UseYN         TINYINT(1)       NULL     DEFAULT  1  
                                     
    , InsertUID     VARCHAR(40)      NULL                            
    , InsertDT      DateTime         NULL
    , UpdateUID     VARCHAR(40)      NULL                            
    , UpdateDT      DateTime         NULL
    
    , PRIMARY KEY(commentno)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

insert into TB_Bbs_Comments( articleno, email, memo, regdate, UseYN  ) values ( 1, "aa@aa.co.kr", "comment test", now(), 1 );
      
select * from TB_Bbs_Comments;     
           
           
-- 첨부파일 테이블
DROP TABLE IF EXISTS TB_Bbs_Attachfile;
CREATE TABLE IF NOT EXISTS  TB_Bbs_Attachfile (
      attachfileno   INT UNSIGNED    NOT NULL AUTO_INCREMENT
    , filename       NVARCHAR(50)    NOT NULL
    , filetype       NVARCHAR(30)    
    , filesize       INT             
    , articleno      INT             
                                     
    , UseYN          TINYINT(1)      NULL     DEFAULT  1  
                                     
    , InsertUID      VARCHAR(40)     NULL                            
    , InsertDT       DateTime        NULL
    , UpdateUID      VARCHAR(40)     NULL                            
    , UpdateDT       DateTime        NULL
    
    , imageData      LONGBLOB        NULL
    
    , PRIMARY KEY(attachfileno)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

Insert into TB_BBS_ATTACHFILE (FILENAME,FILETYPE,FILESIZE,ARTICLENO,USEYN,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT) values ('어태치파일','파일타입',10,1,1,'attachfile','2016/12/09','filetype','2016/12/09');
Insert into TB_BBS_ATTACHFILE (FILENAME,FILETYPE,FILESIZE,ARTICLENO,USEYN,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT) values ('어태치파일','파일타입',10,1,1,'attachfile','2016/12/09','filetype','2016/12/09');
Insert into TB_BBS_ATTACHFILE (FILENAME,FILETYPE,FILESIZE,ARTICLENO,USEYN,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT) values ('어태치파일','파일타입',10,1,1,'attachfile','2016/12/09','filetype','2016/12/09');
Insert into TB_BBS_ATTACHFILE (FILENAME,FILETYPE,FILESIZE,ARTICLENO,USEYN,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT) values ('어태치파일','파일타입',10,1,1,'attachfile','2016/12/09','filetype','2016/12/09');
Insert into TB_BBS_ATTACHFILE (FILENAME,FILETYPE,FILESIZE,ARTICLENO,USEYN,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT) values ('어태치파일','파일타입',10,1,1,'attachfile','2016/12/09','filetype','2016/12/09');
Insert into TB_BBS_ATTACHFILE (FILENAME,FILETYPE,FILESIZE,ARTICLENO,USEYN,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT) values ('어태치파일','파일타입',10,1,1,'attachfile','2016/12/09','filetype','2016/12/09');
Insert into TB_BBS_ATTACHFILE (FILENAME,FILETYPE,FILESIZE,ARTICLENO,USEYN,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT) values ('어태치파일','파일타입',10,1,1,'attachfile','2016/12/09','filetype','2016/12/09');

select * from TB_Bbs_Attachfile; 



           
-- '좋아요/나빠요' 테이블
DROP TABLE IF EXISTS TB_Bbs_Recommend;
CREATE TABLE TB_Bbs_Recommend (
      userid        VARCHAR( 50)    NOT NULL
    , articleno     INTEGER         NOT NULL       
    , good          TINYINT(1)      NULL     DEFAULT  0  
    , bad           TINYINT(1)      NULL     DEFAULT  0  
    
    , PRIMARY KEY(userid, articleno)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

select * from TB_Bbs_Recommend;  

           
           
-- 회원  테이블
DROP TABLE IF EXISTS TB_User;
CREATE TABLE TB_User (
      userno        INT UNSIGNED    NOT NULL AUTO_INCREMENT
    , userid        VARCHAR( 50)    NOT NULL
    , email         NVARCHAR(100)   NOT NULL
    , passwd        NVARCHAR( 30)    
    , name          NVARCHAR( 30)    
    , mobile        VARCHAR(20)        
    , retireYN      TINYINT(1)      NULL     DEFAULT  1  
                                     
    , InsertUID     VARCHAR(40)     NULL                            
    , InsertDT      DateTime        NULL
    , UpdateUID     VARCHAR(40)     NULL                            
    , UpdateDT      DateTime        NULL
    
    , PRIMARY KEY(userno)
    , UNIQUE KEY(userid)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

select * from TB_User;


--  Phone 테이블
DROP TABLE IF EXISTS TB_Phone;
CREATE TABLE IF NOT EXISTS  TB_Phone (
      name           NVARCHAR(50)    NOT NULL
    , manufacturer   NVARCHAR(30)    NOT NULL
    , price          INT             NOT NULL 
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

select * from TB_Phone;   


commit;

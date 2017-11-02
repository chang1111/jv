-- DROP DATABASE IF EXISTS book_db;
-- CREATE DATABASE book_db COLLATE  'utf8_general_ci';

--
USE book_db;

-- 
DROP TABLE IF EXISTS tb_recent;
CREATE TABLE tb_recent (
    recent_id 	int  NOT  NULL  auto_increment,
    expression       VARCHAR(50),

    PRIMARY KEY(recent_id)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB  ;


--
DROP TABLE IF EXISTS tb_saved;
CREATE TABLE tb_saved (
    saved_id        INT  NOT  NULL  auto_increment,
    name            VARCHAR(50),
    expression      VARCHAR(50)

    , PRIMARY KEY(saved_id)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB  ;



INSERT INTO tb_recent ( expression ) VALUES( '1-2');
INSERT INTO tb_recent ( expression ) VALUES( '1+2');
INSERT INTO tb_recent ( expression ) VALUES( '1*2');
INSERT INTO tb_recent ( expression ) VALUES( '1/2');


INSERT INTO tb_saved  ( name, expression)   VALUES( 'bob'       , '1-2'         ) ;
INSERT INTO tb_saved  ( name, expression)   VALUES( 'kim'       , '1+2'         ) ;
INSERT INTO tb_saved  ( name, expression)   VALUES( 'park'      , '3*4+2'       ) ;
INSERT INTO tb_saved  ( name, expression)   VALUES( 'se'        , '25*45/35'    ) ;
INSERT INTO tb_saved  ( name, expression)   VALUES( 'kimjeon'   , '7449*2'      ) ;
INSERT INTO tb_saved  ( name, expression)   VALUES( 'leejang'   , '949/94'      ) ;
INSERT INTO tb_saved  ( name, expression)   VALUES( 'gosu'      , '384+993'     ) ;

commit;

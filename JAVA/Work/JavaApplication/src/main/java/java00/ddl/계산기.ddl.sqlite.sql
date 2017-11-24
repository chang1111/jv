-- 
DROP TABLE IF EXISTS tb_recent;
DROP TABLE IF EXISTS tb_saved;

--
CREATE TABLE tb_recent (
	  recent_id 	  INTEGER  PRIMARY KEY
	, expression      VARCHAR(50)
);


--
CREATE TABLE tb_saved (
      saved_id        INTEGER  PRIMARY KEY
    , name            VARCHAR(50)
    , expression      VARCHAR(50)
);



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

-- commit;

select * from tb_recent;

select * from tb_saved;
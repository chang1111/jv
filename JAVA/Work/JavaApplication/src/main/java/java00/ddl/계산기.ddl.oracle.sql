-- books drop
BEGIN EXECUTE IMMEDIATE 'DROP TABLE tb_recent'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
-- auth drop
BEGIN EXECUTE IMMEDIATE 'DROP TABLE tb_saved'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/

-- 
CREATE TABLE tb_recent (
	  recent_id   NUMBER(10)  GENERATED AS IDENTITY
	, expression  VARCHAR(50)

	, CONSTRAINT tbRecent_pk_recentId  PRIMARY KEY(recent_id)
);


--
CREATE TABLE tb_saved (
      saved_id        NUMBER(10)  GENERATED AS IDENTITY
    , name            VARCHAR(50)
    , expression      VARCHAR(50)

    , CONSTRAINT tbSaved_pk_savedId PRIMARY KEY(saved_id)
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

commit;

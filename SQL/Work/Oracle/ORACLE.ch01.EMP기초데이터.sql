-- �μ� ���̺� �����ϱ�
BEGIN EXECUTE IMMEDIATE 'DROP TABLE EMP'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
-- ��� ���̺� �����ϱ�
BEGIN EXECUTE IMMEDIATE 'DROP TABLE DEPT'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
-- �޿� ���̺� �����ϱ�
BEGIN EXECUTE IMMEDIATE 'DROP TABLE SALGRADE'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
-- GROUP_STAR ���̺� �����ϱ�
BEGIN EXECUTE IMMEDIATE 'DROP TABLE GROUP_STAR'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
-- SINGLE_STAR ���̺� �����ϱ�
BEGIN EXECUTE IMMEDIATE 'DROP TABLE SINGLE_STAR'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/


-- �μ� ���̺� �����ϱ�
CREATE TABLE DEPT(
     DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY,
     DNAME VARCHAR2(14),
     LOC   VARCHAR2(13) 
);

-- ��� ���̺� �����ϱ�
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

 -- �޿� ���̺� �����ϱ�
CREATE TABLE SALGRADE(
     GRADE NUMBER,
     LOSAL NUMBER,
     HISAL NUMBER 
);


-- GROUP_STAR ���̺� �����ϱ�
CREATE TABLE GROUP_STAR(
    NAME        VARCHAR2(50)
);

-- SINGLE_STAR ���̺� �����ϱ�
CREATE TABLE SINGLE_STAR(
    NICKNAME    VARCHAR2(50)
);     
     

-- ��� ���̺� ���� ������ �߰��ϱ�
INSERT INTO DEPT VALUES(10, '�渮��', '����');
INSERT INTO DEPT VALUES(11, 'ȸ����', '����');
INSERT INTO DEPT VALUES(20, '�λ��', '��õ');
INSERT INTO DEPT VALUES(21, 'HR��'  , '��õ');
INSERT INTO DEPT VALUES(30, '������', '����'); 
INSERT INTO DEPT VALUES(31, '������', '����'); 
INSERT INTO DEPT VALUES(40, '�����', '����');
INSERT INTO DEPT VALUES(41, '������', '����');


-- �μ� ���̺� ���� ������ �߰��ϱ�
INSERT INTO EMP VALUES(1001, '����', '���', 1013, to_date('2007-03-01','yyyy-mm-dd'), 300, NULL, 20);
INSERT INTO EMP VALUES(1002, '�ѿ���', '�븮', 1005, to_date('2007-04-02','yyyy-mm-dd'), 250,   80, 30);
INSERT INTO EMP VALUES(1003, '����ȣ', '����', 1005, to_date('2005-02-10','yyyy-mm-dd'), 500,  100, 30);
INSERT INTO EMP VALUES(1004, '�̺���', '����', 1008, to_date('2003-09-02','yyyy-mm-dd'), 600, NULL, 20);
INSERT INTO EMP VALUES(1005, '�ŵ���', '����', 1009, to_date('2005-04-07','yyyy-mm-dd'), 450,  200, 30);
INSERT INTO EMP VALUES(1006, '�嵿��', '����', 1008, to_date('2003-10-09','yyyy-mm-dd'), 480, NULL, 30);
INSERT INTO EMP VALUES(1007, '�̹���', '����', 1008, to_date('2004-01-08','yyyy-mm-dd'), 520, NULL, 10);
INSERT INTO EMP VALUES(1008, '���켺', '����', 1003, to_date('2004-03-08','yyyy-mm-dd'), 500,    0, 30);
INSERT INTO EMP VALUES(1009, '�ȼ���', '����', NULL, to_date('1996-10-04','yyyy-mm-dd'),1000, NULL, 20);
INSERT INTO EMP VALUES(1010, '�̺���', '����', 1003, to_date('2005-04-07','yyyy-mm-dd'), 500, NULL, 10);
INSERT INTO EMP VALUES(1011, '�����', '���', 1007, to_date('2007-03-01','yyyy-mm-dd'), 280, NULL, 30);
INSERT INTO EMP VALUES(1012, '������', '���', 1006, to_date('2007-08-09','yyyy-mm-dd'), 300, NULL, 20);
INSERT INTO EMP VALUES(1013, '������', '����', 1003, to_date('2002-10-09','yyyy-mm-dd'), 560, NULL, 20);
INSERT INTO EMP VALUES(1014, '���μ�', '���', 1006, to_date('2007-11-09','yyyy-mm-dd'), 250, NULL, 10);
INSERT INTO EMP VALUES(1015, '������', '���', 1008, to_date('2012-11-09','yyyy-mm-dd'), 250, NULL, 31);
INSERT INTO EMP VALUES(1016, '����ȣ', '���', 1008, to_date('2013-01-09','yyyy-mm-dd'), 250, NULL, 31);
INSERT INTO EMP VALUES(1017, '�̴�ȣ', '���', 1008, to_date('2011-03-09','yyyy-mm-dd'), 250, NULL, 31);
INSERT INTO EMP VALUES(1018, '�߽ż�', '�븮', 1004, to_date('2016-10-04','yyyy-mm-dd'),1000, NULL, 21);



-- �޿� ���̺� ���� ������ �߰��ϱ�
INSERT INTO SALGRADE VALUES (1, 700,1200);
INSERT INTO SALGRADE VALUES (2, 1201,1400);
INSERT INTO SALGRADE VALUES (3, 1401,2000);
INSERT INTO SALGRADE VALUES (4, 2001,3000);
INSERT INTO SALGRADE VALUES (5, 3001,9999);


-- GROUP_STAR ���̺� ���� ������ �߰��ϱ�
INSERT INTO GROUP_STAR VALUES('�¿�');
INSERT INTO GROUP_STAR VALUES('����');
INSERT INTO GROUP_STAR VALUES('����');
INSERT INTO GROUP_STAR VALUES('ȿ��');
INSERT INTO GROUP_STAR VALUES('Ƽ�Ĵ�');
INSERT INTO GROUP_STAR VALUES('����ī');
INSERT INTO GROUP_STAR VALUES('����');
INSERT INTO GROUP_STAR VALUES('���');
INSERT INTO GROUP_STAR VALUES('����');
INSERT INTO GROUP_STAR VALUES('ž');
INSERT INTO GROUP_STAR VALUES('���巡��');
INSERT INTO GROUP_STAR VALUES('�뼺');
INSERT INTO GROUP_STAR VALUES('�¸�');
INSERT INTO GROUP_STAR VALUES('�¾�');


-- SINGLE_STAR ���̺� ���� ������ �߰��ϱ�
INSERT INTO SINGLE_STAR VALUES('�¿�');
INSERT INTO SINGLE_STAR VALUES('���巡��');
INSERT INTO SINGLE_STAR VALUES('�뼺');
INSERT INTO SINGLE_STAR VALUES('�¾�');
INSERT INTO SINGLE_STAR VALUES('������');
INSERT INTO SINGLE_STAR VALUES('������');
INSERT INTO SINGLE_STAR VALUES('������');

COMMIT;




-- �ֹ� ���̺� �����ϱ� 
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Orders'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
-- ���� ���̺� �����ϱ�
BEGIN EXECUTE IMMEDIATE 'DROP TABLE book'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
-- ���� ���̺� �����ϱ� 
BEGIN EXECUTE IMMEDIATE 'DROP TABLE auth'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
-- �� ���̺� �����ϱ� 
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Customer'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/


-- auth ���̺� 
CREATE TABLE auth (
      authid    NUMBER(10)  PRIMARY KEY
    , name      VARCHAR(50)
    , birth     VARCHAR(10)
);


-- book ���̺� ����
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

-- �� ���̺� ����
CREATE TABLE  Customer (
      custid        NUMBER(2) PRIMARY KEY  
    , name          VARCHAR2(40)
    , address       VARCHAR2(50)
    , phone         VARCHAR2(20)
);

-- �ֹ� ���̺� ����
CREATE TABLE Orders (
      orderid       NUMBER(2) PRIMARY KEY 
    , custid        NUMBER(2) REFERENCES Customer(custid)
    , bookid        NUMBER(2) REFERENCES Book(bookid)
    , saleprice     NUMBER(8) 
    , orderdate     DATE
);


-- Auth, Book, Customer, Orders ������ ����
INSERT INTO auth( authid, name, birth)   VALUES( 1, 'bob' , '1970.05.01' ) ;
INSERT INTO auth( authid, name, birth)   VALUES( 2, 'kim' , '1980.05.01' ) ;
INSERT INTO auth( authid, name, birth)   VALUES( 7, 'park', '2000.05.01' ) ;


INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid) VALUES('Operating System'  , 'Wiley'     , '2003', 30700, '2004-01-01', 0, 1 ) ;
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid) VALUES('MySQL'             , 'OReilly'   , '2009', 58700, '2010-01-01', 1, 2 ) ;
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid) VALUES('JAVA'              , 'Hall'      , '2013', 40000, '2014-01-01', 1, 3 ) ;
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid) VALUES('First SQL'         , 'Wiley'     , '2015', 57700, '2016-01-01', 1, 4 ) ;

INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('�౸�� ����'      , '�½�����'  , '2001',  7000, '2001-01-01', 1,  1);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('�౸�ƴ� ����'    , '������'    , '2002', 13000, '2002-02-02', 1,  2);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('�౸�� ����'      , '���ѹ̵��', '2003', 22000, '2003-03-03', 1,  3);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('���� ���̺�'      , '���ѹ̵��', '2004', 35000, '2004-04-04', 1,  4);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('�ǰ� ����'        , '�½�����'  , '2005',  8000, '2005-05-05', 1,  5);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('���� �ܰ躰���'  , '�½�����'  , '2006',  6000, '2006-06-06', 1,  6);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('�߱��� �߾�'      , '�̻�̵��', '2007', 20000, '2007-07-07', 1,  7);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('�߱��� ��Ź��'    , '�̻�̵��', '2008', 13000, '2008-08-08', 1,  8);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('�ø��� �̾߱�'    , '�Ｚ��'    , '2009',  7500, '2009-09-09', 1,  9);
INSERT INTO book(bookname, publisher, year, price, dtm, use_yn, authid)  VALUES('Olympic Champions', 'Pearson'   , '2010', 13000, '2010-10-10', 1, 10);


INSERT INTO Customer VALUES (1, '������', '���� ��ü��Ÿ'  , '000-5000-0001');
INSERT INTO Customer VALUES (2, '�迬��', '���ѹα� ����'  , '000-6000-0001');  
INSERT INTO Customer VALUES (3, '��̶�', '���ѹα� ������', '000-7000-0001');
INSERT INTO Customer VALUES (4, '�߽ż�', '�̱� Ŭ������', '000-8000-0001');
INSERT INTO Customer VALUES (5, '�ڼ���', '���ѹα� ����'  ,  NULL);


-- �ֹ�(Orders) ���̺��� å���� ���� �ǸŸ� ������
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



-- �����, ������ ���� ���� ������
-- �μ� ���̺� �����ϱ�
BEGIN EXECUTE IMMEDIATE 'DROP TABLE �μ�'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/

-- ���� ���̺� �����ϱ�
BEGIN EXECUTE IMMEDIATE 'DROP TABLE ����'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/


CREATE TABLE �μ� ( 
      �μ��ڵ� VARCHAR2(4) PRIMARY KEY
    , �μ��� VARCHAR2(30) NOT NULL
    , �����μ��ڵ� VARCHAR2(4) NULL
);

CREATE TABLE ����  ( 
      ��� VARCHAR2(7) NOT NULL
    , �μ��ڵ� VARCHAR2(4) NOT NULL
    , �ݾ� NUMBER(10) NOT NULL       
    
    , CONSTRAINT PK_���� PRIMARY KEY (���, �μ��ڵ�)
);

INSERT INTO �μ�
SELECT '1000', '��ǥ�̻�'   , NULL    FROM DUAL UNION ALL
SELECT '1100', '����1����'  , '1000'  FROM DUAL UNION ALL
SELECT '1200', '����2����'  , '1000'  FROM DUAL UNION ALL
SELECT '1110', '��������1��', '1100'  FROM DUAL UNION ALL
SELECT '1120', '��������2��', '1100'  FROM DUAL UNION ALL
SELECT '1210', '�ؿܿ���1��', '1200'  FROM DUAL UNION ALL
SELECT '1220', '�ؿܿ���2��', '1200'  FROM DUAL UNION ALL
SELECT '1111', '����������' , '1110'  FROM DUAL UNION ALL
SELECT '1112', '��������'   , '1110'  FROM DUAL UNION ALL
SELECT '1121', 'ȣ������'   , '1120'  FROM DUAL UNION ALL
SELECT '1122', '�泲����'   , '1120'  FROM DUAL
;

INSERT INTO ����
SELECT '2013.07', '1210', 1000  FROM DUAL UNION ALL
SELECT '2013.07', '1220', 1000  FROM DUAL UNION ALL
SELECT '2013.07', '1111', 1000  FROM DUAL UNION ALL
SELECT '2013.07', '1112', 1000  FROM DUAL UNION ALL
SELECT '2013.07', '1121', 1000  FROM DUAL UNION ALL
SELECT '2013.07', '1122', 1000  FROM DUAL
;

COMMIT;


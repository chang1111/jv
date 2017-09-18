-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
-- �Լ� : ������Ʈ�� ����
--        �ݵ�� ��ȯ���� ����.
--        1) �Լ� ��Ͽ��� �ݵ�� RETURN���� �־�� �Ѵ�.
--        2) �Լ��� RETURN ���� ������ �Ͱ� ������ datatype���� RETURN ���� �����ؾ� �Ѵ�.
--        3) ���� RETURN ���� ����� �� ������ �� ���� ȣ��δ� �� ���� RETURN ���� ����ȴ�.
--  
-- �Լ� ����: 
--        ��Į�� �Լ�(�Ѱ��� ����) 
--        ���̺� �Լ�(������ ����)
-- 
-- �Լ� ����
--        ��Į�� �Լ� ���� : select  �Լ���(...)
--        ���̺� �Լ� ���� : select  �Լ���(...)
-- 
-- �Լ�����
--        arr_split ����� : ��Į�� �Լ�
--        str_split ����� : ���̺� �Լ�
--  
-- http://laserbit.tistory.com/entry/����Ŭ-FUNCTION-����
-- http://www.gurubee.net/lecture/1042
-- http://www.gurubee.net/lecture/2238
-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2



-- ###############################
-- ��Į�� �Լ� 
-- ###############################


-- @@@@@@@
-- ��Į�� �Լ�.
-- �Է��� ���ڿ��� ��ȯ�ϴ� udf_string_print �Լ��� ����ÿ�.
-- ��Į�� �Լ� ���� : 1�� ����
-- �Ű����� : ���ڿ� 
-- ��Į�� �Լ� ���� : SELECT �Լ��̸�() FROM ���̺��;
-- ��Į�� �Լ� ���� : SELECT �Լ��̸� ;
-- @@@@@@@



-- @@@@@@@ 
-- ����. ��Į�� �Լ�, udf_find_dname �� ����ÿ�.
-- emp ���̺��� empno�� �Է��ϸ� dept ���̺��� �μ����� �����ִ� �Լ��� �ۼ��Ͽ���.
-- 
-- ���� ����: 
--    select udf_find_dname(1001);
-- 
--    select *, (select dname from dept where deptno = emp.deptno) from emp  ;
--    select *, udf_find_dname(???) '�μ���' from emp ;
-- @@@@@@@



-- @@@@@@@
-- ����. �÷� ���� ���� üũ�ϴ� �Լ� �� ����ÿ�.
-- udf_col_length('���̺��','�÷���') 
-- 
-- select * 
--   from information_schema.columns 
--  where table_schema = 'db_name' 
--    and table_name   = 'table_name' 
--    and column_name  = 'column_name' ;  
-- @@@@@@@ 






-- @@@@@@@ 
-- 3���� ���� �޴� ��Į�� �Լ�, emp_disp�� �����.  
-- EMP ���̺��� �̸��� �Է� �޾� �μ���ȣ,�μ���,�޿��� �˻��ϴ� function�� �ۼ��Ͽ���. 
-- ��, �μ���ȣ�� RETURN�� ����Ͽ���.
-- 
-- oracle, mssql �� ����
-- mysql �� �Ұ���. mysql������ procedure�� ����ؾ� ��.
-- @@@@@@@

-- ��Į�� �Լ� ���� : select ���


-- @@@@@@@ 
-- udf_ipconfig �� ����ÿ�.
-- 
-- client ���� ������ ����ϴ� SQL��
-- select host 
--   into myip
--   from information_schema.PROCESSLIST
--  where id = connection_id()  ;
-- @@@@@@@





-- ###############################
-- ���̺� �Լ� ���� : ������ ����
--      Table Function
--      Pipelined Table Function
-- 
--      Oracle, MsSQL�� ���̺� �Լ� ����
--      MySQL�� ���̺� �Լ� ���� �ȵ�.
-- ###############################

-- @@@@@@@ 
-- Table Function  ���� : ������ ����
-- oracle, mssql �� ����
-- mysql �� �Ұ���.
-- @@@@@@@




-- @@@@@@@ 
-- Table Function  ���� : SELECT �Լ��̸� ;
-- @@@@@@@ 



-- @@@@@@@ 
-- Pipelined Table Function  ���� : ������ ����
-- @@@@@@@




-- @@@@@@@ 
-- Pipelined Table Function ���� : SELECT �Լ��̸� ;
-- @@@@@@@ 




-- ###############################
-- ���� Ǯ��
-- ###############################


-- @@@@@@@ 
-- �Լ�����-arr_split
-- SELECT arr_split('��α�|MSSQL|WEB', '|', 1) ;    
-- ��� ���: '��α�'
-- @@@@@@@ 



-- @@@@@@@ 
-- �Լ�����-str_split
-- select * from dbo.STR_SPLIT(  'a,b,c', ',' ); 
-- 
-- ��� ���
-- +-------+
-- | value |
-- +-------+
-- | a     |
-- +-------+
-- | b     |
-- +-------+
-- | c     |
-- +-------+
-- 
-- oracle, mssql �� ����. mysql �� �Ұ���.
-- @@@@@@@ 


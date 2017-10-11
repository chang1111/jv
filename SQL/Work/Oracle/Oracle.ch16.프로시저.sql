-- ########################
-- ���ν��� �����
-- 
-- sql ���α׷���
--  1. ���� ����
--  2. ���ù�
--  3. �ݺ���
-- 
-- ���ν��� ����
--  1. �Ű����� ���� ���ν��� �����
--  2. �Ű����� �ִ� ���ν��� �����
--  3. ��� ��ȯ �޴� ���ν��� �����
-- 
-- ���ν��� �Ű����� : ���ν����� �Ķ���ʹ� IN, OUT, INOUT�� ������ �� �ִ�.
--  IN    : read-only
--  INOUT : read-write
--  OUT   : write-only
--  �ԷµǾ�� �ϴ� �Ű��������� in�� ����ϳ� in�� ���� �� �� �ִ�.
--  �ǵ��� �޾ƾ� �ϴ� �Ű��������� out�̳� inout�� �����Ѵ�.
-- 
-- ���ν��� �����ϱ�
--  1. call �� ���ν��� ����
--  2. ���ν������� ���ν��� ���� 
-- 
-- http://m.egloos.zum.com/it79/v/1032459
-- http://thesunrises.tistory.com/m/511
-- ########################



-- ########################
-- �Ű����� ���� ���ν��� �����
-- ########################
-- 'hello' �� ����ϴ� helloworld ���ν����� ����ÿ�.




-- ########################
-- ���ν��� �ȿ��� ���� ����
-- declare  ������  ����Ÿ��;
-- ########################

-- variable_demo ���ν����� ����ÿ�.
-- �������� my_integer�� ����� 20 �����ϰ� my_integer ���� ����Ͻÿ�.


-- ########################
-- ���ù�
-- 
-- if search_condition then statement_list
-- [elseif search_condition then statement_list]
-- [elseif search_condition then statement_list]
-- ...
-- [else statement_list]
-- end if
-- ########################

-- @@@@@
-- simplecompare ���ν����� ����ÿ�.
-- �Ű����� n --> int
-- �Ű����� m --> int
-- ���: call simplecompare(1,2);
-- n > m ==> large, n<m ==> small ���
-- +------+------+-------+
-- | n    | m    | s     |
-- +------+------+-------+
-- |    1 |    2 | small |
-- +------+------+-------+
-- @@@@

-- @@@@@
-- �ݺ���
-- 
-- cursor���� �ַ� ����.
-- 
-- WHILE search_condition DO
--    statement_list
--    statement_list
--    statement_list
-- END WHILE
-- @@@@@

-- @@@@
-- simple_loop ���ν����� ����ÿ�.
-- ���� ���ν��� �ȿ� ������ ����.
-- �Ű������� ����
-- ���ν��� ���� ���� ����: counter����� �⺻���� 0���� ����.
-- counter�� 10�� �� ������ counter �� 1�� ������Ű�鼭 counter ���� ����Ͻÿ�.
-- @@@@



-- @@@@
-- ����. emp ���̺��� ��� �����͸� �����ϴ� del_all ���ν����� ����ÿ�.
-- delete from emp;
-- @@@@


-- �Ű����� 1���� �Է� �ް� �Է� ���� ���� ����ϴ� usp_test ���ν����� ����ÿ�.



-- @@@@@
-- ����. ���� �Է� �ް� �������� ���ϴ� usp_sqrt_in ���ν����� ����ÿ�.
-- MySQL ���� �Լ� sqrt �� ����ϸ� �˴ϴ�.
-- @@@@


-- @@@@
-- ����. �Ű������� �Ѱ��� ename�� emp ���̺��� ã�Ƽ� delete�ϴ� usp_del_ename ���ν����� ����ÿ�.
--       usp_del_ename ���ν����� �̿��Ͽ� '����'�� �����Ͻÿ�.
-- @@@@


-- @@@@
-- ����. �ܷ�Ű�� ��ȸ�ϴ� usp_foreignkey ���ν����� ����ÿ�.
--       �Ű����� 2�� ���. 
--       ù��° �Ű������� �����ͺ��̽��̸�.
--       �ι�° �Ű������� ���̺��̸�.
-- 
-- �ܷ�Ű�� ��ȸ�ϴ� SQL ��.
--       select
--             table_name,column_name,referenced_table_name,referenced_column_name
--       from
--             information_schema.key_column_usage
--       where referenced_table_name is not null
--         and table_schema = 'test' 
--         and table_name = 'assign'
-- 
-- ����
--  call usp_foreignkey('test', 'emp'); --> test ����� emp ���̺��� �ܷ�Ű ������ ���
--  +------------+-------------+-----------------------+------------------------+
--  | table_name | column_name | referenced_table_name | referenced_column_name |
--  +------------+-------------+-----------------------+------------------------+
--  | emp        | DEPTNO      | dept                  | DEPTNO                 |
--  +------------+-------------+-----------------------+------------------------+
--  
--  call usp_foreignkey('test', ''   ); --> test ����� ���  �ܷ�Ű ������ ���
--  +------------+-------------+-----------------------+------------------------+
--  | table_name | column_name | referenced_table_name | referenced_column_name |
--  +------------+-------------+-----------------------+------------------------+
--  | assign     | emp_no      | employee              | emp_no                 |
--  | assign     | pro_no      | project               | pro_no                 |
--  | book       | authid      | auth                  | authid                 |
--  | emp        | DEPTNO      | dept                  | DEPTNO                 |
--  | specialty  | emp_no      | employee              | emp_no                 |
--  +------------+-------------+-----------------------+------------------------+
--  
--  call usp_foreignkey('test', null ); --> test ����� ���  �ܷ�Ű ������ ���
--  +------------+-------------+-----------------------+------------------------+
--  | table_name | column_name | referenced_table_name | referenced_column_name |
--  +------------+-------------+-----------------------+------------------------+
--  | assign     | emp_no      | employee              | emp_no                 |
--  | assign     | pro_no      | project               | pro_no                 |
--  | book       | authid      | auth                  | authid                 |
--  | emp        | DEPTNO      | dept                  | DEPTNO                 |
--  | specialty  | emp_no      | employee              | emp_no                 |
--  +------------+-------------+-----------------------+------------------------+
-- 
-- @@@@
  
  
-- ########################
-- ��� �ε����� ����ϴ� usp_indexall ���ν����� ����ÿ�.
-- �Ű����� 2�� ���. 
--   ù��° �Ű������� �����ͺ��̽��̸�.
--   �ι�° �Ű������� ���̺��̸�.
--  
-- SELECT table_name AS `Table`,
--        index_name AS `Index`,
--        GROUP_CONCAT(column_name ORDER BY seq_in_index) AS `Columns`
-- FROM information_schema.statistics
-- WHERE NON_UNIQUE = 1 
--   AND table_schema = 'test' 
--   AND table_name   = 'emp'
-- GROUP BY 1, 2;
-- 
-- ����
--  call usp_indexall('test', 'emp'); --> test ����� emp ���̺��� �ε��� ������ ���  
--  call usp_indexall('test', ''   ); --> test ����� ��� �ε��� ������ ���  
--  call usp_indexall('test', null ); --> test ����� ��� �ε� ������ ���
-- ########################


-- ########################
-- ���̺��� �ε����� �����ϴ� usp_indexdrop ���ν����� ����ÿ�.
-- drop all non-unique indexes
-- 1. drop index ������ �ӽ����̺� insert
-- 2. Ŀ���� �̿��� ���� ���� ����
-- 
-- set session group_concat_max_len=10240;
-- 
-- select concat('alter table ', `table`, ' drop index ', group_concat(`index` separator ', drop index ') )
-- from (
-- select table_name as `table`,
--        index_name as `index`
-- from information_schema.statistics
-- where non_unique   = 1 
--   and table_schema = 'test' 
--   and table_name   = 'emp'
-- group by `table`, `index`) as tmp
-- group by `table`;
-- ########################





-- ########################
-- ����� ��ȯ �޴� ���ν��� ����� 
-- 
-- MySQL���� �Ķ���ʹ� IN, OUT, INOUT�� ������ �� �ִ�.
-- IN    : read-only
-- INOUT : read-write
-- OUT   : write-only
-- 
-- �ǵ��� �޾ƾ� �ϴ� �Ű��������� out�� �����Ѵ�.
-- ########################

-- @@@@@
-- ���� �Է� �ް� �������� ���Ͽ� ����� �����ϴ� usp_sqrt_out ���ν����� ����ÿ�.
-- MySQL ���� �Լ� sqrt �� ����ϸ� �˴ϴ�.
-- IN �Ű�����   : inum, Ÿ���� �Ǽ���
-- OUT �Ű�����  : onum, Ÿ���� �Ǽ���
-- @@@@



-- @@@@@
-- INOUT �Ű������� ����Ͽ� 
-- ���� �Է� �ް� ������ ����� �����ϴ� usp_sqrt_inout ���ν����� ����ÿ�.
-- MySQL ���� �Լ� sqrt �� ����ϸ� �˴ϴ�.
-- INOUT �Ű�����   : num, Ÿ���� �Ǽ���
-- @@@@



-- @@@@@@@
-- ����. empno�� ���ڷ� �ѱ�� ename, sal, job �� ���� �޴� ���ν���, sel_empno�� ����ÿ�.
-- in  �Ű�����: empno ���� 1001���� 1010 ������ ������ ���� ����Ͻð�,
-- out �Ű�����: ename, sal, job �� �ǵ��� �޾� ���� ����Ͻÿ�. 
-- @@@@@@@



-- @@@@@@@
-- ����. �÷� ���� ���� üũ�ϴ� ���ν��� �� ����ÿ�.
--       usp_col_length('�����ͺ��̽���', '���̺��', '�÷���') ;
-- 
-- ��ȯ�� : �÷��� �����ϸ� 1 ��ȯ
--          �÷��� �������� ������ 0 ��ȯ
-- 
-- �÷� ���� ���θ� ��ȸ�ϴ� SQL��.
-- select * 
--   from information_schema.columns 
--  where table_schema = 'db_name' 
--    and table_name   = 'table_name' 
--    and column_name  = 'column_name' ; 
-- @@@@@@@



-- ########################
-- ���ν������� ���ν��� ���ϱ�
-- ########################

-- usp_callproc ���ν����� ����ÿ�.
-- ���� ���ν������� �� �ٸ� ���� �������� ȣ��
-- ù��° �Ű������� 0�̸� usp_foreignkey('test', 'emp') �� ȣ��
-- ù��° �Ű������� 1�̸� usp_indexall('test', 'emp') �� ȣ��




-- ########################
-- cursor�� ����ϴ� ���ν��� cursor_example�� ����ÿ�.
-- 1. Ŀ�� declare
-- 2 .Ŀ�� open
-- 3. Ŀ�� fetch
-- 4. Ŀ�� close
-- ########################




-- ########################
-- InsertUpdate ���ν��� vs MERGE ����
-- ########################

-- @@@@@
-- ����. usp_emp_insertupdate ���ν����� ����ÿ�.
-- emp ���̺� �Ű������� �Ѱ��� empno �����Ͱ� ������ insert,
--                                empno �����Ͱ� ������ update.
-- 
-- �Ű�����
--   vempno     int 
--   vename     nvarchar(20)
--   vjob       nvarchar(20)
--   vdeptno    int
-- @@@@@



-- @@@@@
-- ����. usp_merge ���ν����� ����ÿ�.
--  emp ���̺� �Ű������� �Ѱ��� empno �����Ͱ� ������ insert,
--                                 empno �����Ͱ� ������ update.
--  MERGE ���� ���
-- @@@@@


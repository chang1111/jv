-- @@@@@@@@@@@@@@
-- ������ ����  
--    ROLLUP     : �Ұ� ���ϱ�.Oracle, MySQL, MsSQL ����
--    CUBE 	     : �Ұ�� �Ѱ� ���ϱ�.Oracle, MySQL, MsSQL ����
--    COMPUTE	 : .Oracle����. MySQL, MsSQL ������
--    COMPUTE BY : .Oracle����. MySQL, MsSQL ������
--  
-- @@@@@@@@@@@@@@

-- ====================
-- rollup : �־��� �����͵��� �Ұ踦 ���ϴ� �Լ�
-- ROLLUP�� �μ��� ���� �����̹Ƿ� �μ� ������ �ٲ�� ���� ����� �ٲ�ȴ�
-- http://antkdi.tistory.com/27
-- MySQL 5.5 ���� ����
-- ====================


-- ====================
-- cube : �־��� �������� �Ұ�� �Ѱ���� ���ϴ� �Լ�
-- ROLLUP�� ���� �پ��� �����͸� ������ �ý��ۿ� ���ϸ� �����ش�.
-- http://antkdi.tistory.com/27
-- MySQL 5.6 ���� ���� ���� ����.
-- ====================
SELECT b.dname, a.job, SUM(a.sal) sal, COUNT(a.empno) emp_count, 
       GROUPING(b.dname) "D", GROUPING(a.job) "S"
FROM emp a, dept b
WHERE a.deptno = b.deptno
GROUP BY b.dname, a.job with CUBE





 
-- @@@@@@@@@@@@@@
-- ������ ���� �Լ� 
-- PIVOT() / UNPIVOT() / GROUPING / GROUP_ID / GROUP SETS / LISTAGG
-- 
-- PIVOT ()  : �����͸� �˻��� �� �� ������ �� �������� �����ִ� ������
-- UNPIVOT() : �����͸� �˻��� �� �� ������ �� �������� �����ִ� ������
-- oracle 
-- http://godreem.tistory.com/entry/����-����-�ٲٱ�-PIVOT-11g-�̻�-����
-- 
-- MySql
-- http://stackoverflow.com/questions/12382771/mysql-pivot-crosstab-query
-- https://en.wikibooks.org/wiki/MySQL/Pivot_table
-- http://mysql.rjweb.org/doc.php/pivot
-- @@@@@@@@@@@@@@


-- =============
-- PIVOT ()
-- =============






-- �������̺�(2014�� �������)

 
-- ���� ���ϰǼ� (PIVOT �̿�)


-- ���޺� �������� ����Ͻÿ�




-- =============
-- UNPIVOT ()
-- =============




-- @@@@@@@@@@@@@@
-- RANKS �Լ� : ROW_NUMBER() / RANK() / DENSE_RANK() / NTILE() / PARTION BY
-- http://egloos.zum.com/entireboy/v/4433510
-- @@@@@@@@@@@@@@


-- =============
-- ROW_NUMBER()
-- =============

-- deptno�� �������� ������������ �����Ͻÿ�.



-- deptno�� ROW_NUMBER()�� �����Ͻÿ�



-- =============
-- RANK ()
-- =============

-- ename�� �������� ������������ �����Ͻÿ�.



-- ename�� rank()�� �����Ͻÿ�






-- @@@@@@@@@@@@@@
-- SECECT�� �̿��Ͽ� �Ұ�� �Ѱ� ���ϱ�
-- @@@@@@@@@@@@@@
-- ORACLE ������ ( ���� �Լ��� ������ �ɼ� )






-- @@@@@@@@@@@@@@
-- �̼�
-- @@@@@@@@@@@@@@



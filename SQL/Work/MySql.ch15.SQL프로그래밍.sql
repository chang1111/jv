-- @@@@@@@@@@@@@@
-- ���� ����
-- 	User-defined variables(prefixed with @) 	: sql ����
--	Local Variables(no prefix) 					: procedure, function
--	Server System Variables(prefixed with @@)
-- 
-- http://stackoverflow.com/questions/11754781/how-to-declare-a-variable-in-mysql
-- @@@@@@@@@@@@@@


-- @@@@@
-- User-defined variables(prefixed with @) : sql ����
-- @@@@@


-- @@@@@
-- Server System Variables(prefixed with @@)
-- @@@@@


-- @@@@@
-- Local Variables(no prefix, declare)  : procedure, function
-- @@@@@


-- @@@@@@@@@@@@@@
-- SQL������ ���ù�
--      ifnull
--      if
--      case when then
-- @@@@@@@@@@@@@@

-- @@@@@
-- ifnull�� ( mysql ���� ��� )
-- ���� : ifnull ( ��1, ��2)
-- ���� - price ���� null �̸� 0��, null �� �ƴϸ� price ���� ���
-- @@@@@

-- @@@@@
-- if ��
-- ���� : if ( ���ǹ�, ���϶� ��, �����϶� ��)
-- 
-- ���� - ��� ���̺��� ���̵�(member_id) �� ������ �̴µ� null �ϰ��� - �� ���, �ƴϸ� ������ ���
-- @@@@@


-- @@@@@ 
-- sql�������� ����if 
-- 
-- case ��
-- ���� :  case (���� �Ǵ� ��)
--             when ��1 then ǥ�ð�
--             when ��2 then ǥ�ð�
--             else ǥ�ð�
--         end
-- 
-- ���� - a ���� '1'�̸� a, '2' �̸� b, �Ѵ� �ƴҰ�� c �� ���
-- @@@@@

--function
--������ �Լ� >> �� : ����Լ�-��,ī��Ʈ,�ְ�,�ּҰ�,���..
--������ �Լ� >> �� : ������ȯ�Լ�.,,

--1.����Լ�
--��ü����� �˻�
select count(*) from employees;

--�Ŵ޳����� ��ü������� �޿��� ��
select sum(salary),sum(salary)*1300 from employees;

--������� �޿��� �ְ�޿����
select max(salary) from employees;

--������� �޿��� �ּұ޿����
select min(salary) from employees;

--������� ��ձ޿����
select avg(salary) from employees;


--2. �����Լ�
select chr(65) from dual;

--|| >> concat
select concat(first_name,job_id) from employees;

--��ҹ��ں���
select first_name,lower(first_name),upper(first_name)
from employees;

--LPAD �����ֱ�
select LPAD('yangssem', 13, '*#') from dual;
select LPAD(first_name, 13, '*'),
RPAD(first_name, 13, '*') from employees;

--���� �Ǵ� Ư�� ���� ����(������ �յڿ��� ����)
select LTRIM('aa123456aa', 'aa'),
RTRIM('aa123456aa', 'aa')from dual;

--�ǵ������� ������ �ƴϰ� ��½ÿ��� ������ ����
select REPLACE('yang and sam', 'sa', 'sse') from dual;

select job_id,REPLACE(job_id, 'AC', 'TC') from employees;

select REPLACE('yang and sam', 'sa', 'sse') from dual;

--���ڿ��� �Ϻκ� ����
select SUBSTR('ABCDEFG', 2, 1) from dual;
select SUBSTR('ABCDEFG', 2, 2),SUBSTR('ABCDEFG', 2, 3) from dual;


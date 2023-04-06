--���̺��Ϻ��� DQL
select * from tab;
--* : all column

select * from countries;

desc countries;

select country_id,country_name,region_id from countries;

select * from departments;

desc departments;

-- ��� ������� ����÷����� ���(�˻�)
select * from employees;

-- 150������ ����� ū��ȣ�� ����ϴ� ������� ����÷����� ���(�˻�)
select * from employees where employee_id >= 150;

-- ��� ������� �����ȣ,�̸�,��,�޿� �÷������� ���(�˻�)-�� ��� ������������(������)
select employee_id,first_name,last_name,salary from employees order by employee_id desc;

-- ��� ������� �����ȣ,�̸�,��,�޿� �÷������� ���(�˻�)-�� �޿� ������������(������)
select employee_id,first_name,last_name,salary from employees order by salary asc;

select JOB_ID, SALARY from employees order by JOB_ID, SALARY desc;


-----------------

--��� ������� �μ���ȣ��10���� ������� �̸�,�޿���10%�̻�ݿ����� ����ϼ���.
select first_name,last_name,salary,
salary*1.1 "�޿���10%�̻�ݿ���",salary+1000,
salary/10,salary-2000 from employees
where department_id=10;

select first_name,last_name,salary
from employees
where salary=24000;

select first_name,last_name,salary
from employees
where salary >= 15000;

select first_name,last_name,salary,department_id
from employees
where department_id != 30;

select first_name,last_name,salary,department_id
from employees
where not department_id = 30;


-- &,&&, |,||
select first_name,last_name,salary,department_id
from employees
where department_id = 20 and salary > 10000;

select first_name,last_name,salary,department_id
from employees
where department_id != 20 and salary > 10000;

select first_name,last_name,salary,department_id
from employees
where salary = 11000 or salary = 12000 or salary=15000;

select first_name,last_name,salary,department_id
from employees
where salary in(11000,12000,15000);

select first_name,last_name,salary,department_id
from employees
where salary >= 10000 and salary <= 17000;

select first_name,last_name,salary,department_id
from employees
where salary between 10000 and  17000;

select first_name,last_name,salary,department_id
from employees
where not(salary between 10000 and  17000);

select first_name,last_name,salary,department_id
from employees
where not(salary between 10000 and  17000) and department_id is null;

--department_id is not null >> �μ������� �ȵȻ���� ���� ���
select first_name,last_name,salary,department_id
from employees
where not (salary between 10000 and  17000 )
and department_id is not null;

--dual table
select 1+(2*3) from dual;

select employee_id,salary from employees
where salary>=20000 or salary <= 2100
--union --�ߺ��Ȱ��� �Ѱ���
--union all --��δ�
--intersect --�ߺ��Ȱ��� ����?
minus --�����˻��� ������� �ڿ��˻������ ����.
select employee_id,salary from employees
where salary <= 2200;

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

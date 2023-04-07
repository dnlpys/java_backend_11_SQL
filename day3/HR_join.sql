--join

select employee_id,first_name,department_id
from employees;

select department_id,department_name
from departments;

select count(*) from departments; -- 27
select count(*) from employees;   --107

select 27*107 from dual;    --2889

--oracle join
select e.employee_id,e.first_name,
e.department_id,
d.department_name
from employees  e, departments d
where e.department_id = d.department_id;

select e.employee_id,
d.location_id
from employees e, departments d
where e.department_id = d.department_id
and e.employee_id=100;

--ANSI join
select e.employee_id,e.first_name,
e.department_id,
d.department_name
from employees e inner join departments d
on e.department_id = d.department_id;

select e.employee_id, d.location_id
from employees e inner join departments d
on (e.department_id = d.department_id)
and e.employee_id=100;

--emps join jobs
select e.employee_id,j.job_title
from employees e, jobs j
where e.job_id = j.job_id;

select e.employee_id,j.job_title
from employees e inner join jobs j
on (e.job_id = j.job_id);

--(emps join depts) join jobs
select e.employee_id,j.job_title,d.department_name
from employees e,departments d, jobs j
where e.department_id=d.department_id 
and e.job_id = j.job_id
and e.employee_id = 100;

--(emps join jobs) join depts
select e.employee_id,j.job_title,d.department_name
from employees e inner join jobs j
on (e.job_id = j.job_id)
inner join departments d
on (d.department_id=e.department_id)
and e.employee_id = 100;

--(depts join loc) join country
select d.department_id,d.department_name,l.city,l.country_id,c.country_name
from departments d join locations l
on(d.location_id=l.location_id)
join countries c
on(l.country_id = c.country_id);

SELECT e.first_name �̸�, e.last_name ��,
decode(d.department_name,
        'Executive','������',
        'Shipping','�߼ۺ�') �μ��� 
FROM employees e inner join departments d
on (e.department_id=d.department_id) AND e.first_name='Steven';

SELECT e.department_id �μ�ID,d.department_name �μ���, 
e.first_name �̸�,e.last_name ��, e.salary �޿�
FROM employees e join departments d
on (e.department_id=d.department_id) AND e.salary>=12000 
ORDER BY e.salary DESC;

SELECT e.first_name �̸�, e.last_name ��,
case d.department_name
        when 'Executive' then '������'
        when 'Shipping' then '�߼ۺ�'
        else '����'
end �μ��� 
FROM employees e inner join departments d
on (e.department_id=d.department_id) ;

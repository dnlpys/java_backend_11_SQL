-- sub query

--단일행 단일컬럼
select * from employees where salary < 6000;
select round(avg(salary)) from employees;

select employee_id,first_name,last_name,salary,hire_date,job_id from employees where salary > 
(select round(avg(salary)) from employees);

select * from employees 
where salary=(select max(salary) from employees);

select max(salary) from employees;

select * from employees where salary > 
(select round(avg(salary)) from employees);
-------------------------------------------------

-- 복수행 단일컬럼
--all
select * from employees 
where salary <all 
(select salary from employees where department_id=80);

select salary from employees where department_id=80
order by salary asc;

select max(salary) from employees where department_id=30;

select * from employees 
where salary > 
(select max(salary) from employees where department_id=30);

--in
select min(salary) from employees group by job_id
order by min(salary) desc;

select employee_id,first_name,last_name,
job_id,hire_date,salary,department_id
from employees
where salary 
in (select min(salary) from employees group by job_id);

-- any
select employee_id,first_name,last_name,
job_id,hire_date,salary,department_id
from employees
where salary 
<any (select avg(salary) from employees 
where salary >=14000 group by job_id);

select avg(salary) from employees
where salary >=14000 group by job_id;

-- exists
select distinct(department_id) from employees;

-- 별칭사용가능. >> 사원이 있는 부서정보
select * from departments d
where exists 
(select distinct(department_id) from employees e
where d.department_id=e.department_id);

--부하직원이 없는 사원들만 출력하세요.
select * from employees e1
where not exists 
(select employee_id from employees e2
where e1.employee_id = e2.manager_id);

select employee_id from employees;

--복수행 복수컬럼
select * from employees
where (job_id,salary) in(select job_id, min(salary) from employees
group by job_id);


select job_id, min(salary) from employees
group by job_id;

--보고받을 부하직원이 있는 사원들만 출력하세요.
select * from employees e1
where exists 
(select employee_id from employees e2
where e1.employee_id = e2.manager_id);

select * from employees e1
where salary> 
(select avg(salary) from employees e2
where e1.department_id = e2.department_id);

--insert into table_name(columns,,,) values(datas,,,,);
--update table_name set column='',column2='' where ~~~
--delete from table_name where ~~~
--commit or rollback
--특정인의 급여로 바꿔라~
update employees 
set salary=
(select salary from employees where employee_id=101) 
where employee_id=100;
select salary from employees where employee_id=101;
select * from employees;

--특정인의 업무로 바꿔라
update employees set job_id=(select job_id from employees
where first_name='John' and last_name='Chen')
where first_name='David' and last_name='Austin';

select job_id from employees
where first_name='David' and last_name='Austin';

select job_id from employees
where first_name='John' and last_name='Chen';


-- delete subquery
delete from employees where salary=(select min(salary) from employees);

select min(salary) from employees;
select * from employees order by salary asc;


-- jdbc subquery
select employee_id,first_name,last_name,salary,hire_date,job_id 
from employees 
where salary > 
(select round(avg(salary)) from employees);

--테이블목록보기 DQL
select * from tab;
--* : all column

select * from countries;

desc countries;

select country_id,country_name,region_id from countries;

select * from departments;

desc departments;

-- 모든 사원들의 모든컬럼정보 출력(검색)
select * from employees;

-- 150번보다 사번이 큰번호를 사용하는 사원들의 모든컬럼정보 출력(검색)
select * from employees where employee_id >= 150;

-- 모든 사원들의 사원번호,이름,성,급여 컬럼정보만 출력(검색)-단 사번 내림차순정렬(역정렬)
select employee_id,first_name,last_name,salary from employees order by employee_id desc;

-- 모든 사원들의 사원번호,이름,성,급여 컬럼정보만 출력(검색)-단 급여 오름차순정렬(순정렬)
select employee_id,first_name,last_name,salary from employees order by salary asc;

select JOB_ID, SALARY from employees order by JOB_ID, SALARY desc;


-----------------

--모든 사원들중 부서번호가10번인 사원들의 이름,급여의10%이상반영분을 출력하세요.
select first_name,last_name,salary,
salary*1.1 "급여의10%이상반영분",salary+1000,
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

--department_id is not null >> 부서배정이 안된사원은 빼고 출력
select first_name,last_name,salary,department_id
from employees
where not (salary between 10000 and  17000 )
and department_id is not null;

--dual table
select 1+(2*3) from dual;

select employee_id,salary from employees
where salary>=20000 or salary <= 2100
--union --중복된거은 한개만
--union all --모두다
--intersect --중복된것이 뭐냐?
minus --먼저검색한 결과에서 뒤에검색결과를 빼기.
select employee_id,salary from employees
where salary <= 2200;

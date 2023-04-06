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
union --중복된거은 한개만
--union all --모두다
--intersect --중복된것이 뭐냐?
--minus --먼저검색한 결과에서 뒤에검색결과를 빼기.
select employee_id,salary from employees
where salary <= 2200;

--in : 여러 이퀄 or 연산
SELECT DEPARTMENT_ID, SALARY FROM employees
WHERE DEPARTMENT_ID IN(50, 20, 100);

SELECT distinct DEPARTMENT_ID FROM employees
WHERE DEPARTMENT_ID IN(50, 20, 100);

--여러 크다,작다,이상,이하
--any : >일때 데이터들중에서 가장작은것보다 큰것들
--any : >=일때 데이터들중에서 가장작은것 이상인것들
--any : <일때 데이터들중에서 가장큰것보다 작은것들
SELECT DEPARTMENT_ID, SALARY FROM employees
WHERE DEPARTMENT_ID >any(50, 20, 100); -- 작큰
SELECT DEPARTMENT_ID, SALARY FROM employees
WHERE DEPARTMENT_ID <any(50, 20, 100); -- 큰작

SELECT DEPARTMENT_ID, SALARY FROM employees
WHERE DEPARTMENT_ID >all(50, 20, 100); --큰큰
SELECT DEPARTMENT_ID, SALARY FROM employees
WHERE DEPARTMENT_ID <all(50, 20, 100); --작작


SELECT employee_id, SALARY FROM employees
WHERE salary in(4400,17000,10000,12000);

SELECT employee_id, SALARY FROM employees
WHERE salary <=any(4400,17000,10000,12000);

select first_name,last_name from employees
where last_name like '%t%';
select first_name,last_name from employees
where last_name like '%in%';

select first_name,last_name from employees
where last_name like '_e%';

-- abctde a,t
select first_name,last_name from employees
where last_name like '%a%t%';

select first_name,last_name from employees
where last_name like '%a%' and last_name like '%t%';

select first_name,last_name from employees;
select first_name||last_name from employees;
select 
first_name||' '||last_name||'의 연봉['||salary||']' info
from employees;

SELECT EMPLOYEE_ID FROM employees
WHERE NOT (SALARY > 1000 AND SALARY < 12000);

SELECT EMPLOYEE_ID FROM employees
WHERE NOT SALARY > 1000 AND SALARY < 12000;

drop table test2;
create table test2(fname varchar2(20));
insert into test2 values('S1234');
insert into test2 values('1234S_1234');
insert into test2 values('$S_1234');
insert into test2 values('sssS_1234');
insert into test2 values('THE X\_Y');
insert into test2 values('THE1 X_Y');
insert into test2 values('THE X\&Y');
insert into test2 values('THE X&Y');
insert into test2 values('THE2 X_Y');
insert into test2 values('THE2 90%');
insert into test2 values('THE2 30%');

select fname from test2 where fname like '%\%%' escape '\';
select fname from test2 where fname like '%\_%' escape '\' ;
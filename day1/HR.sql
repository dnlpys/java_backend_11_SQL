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

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

SELECT e.first_name 이름, e.last_name 성,
decode(d.department_name,
        'Executive','행정부',
        'Shipping','발송부') 부서명 
FROM employees e inner join departments d
on (e.department_id=d.department_id) AND e.first_name='Steven';

SELECT e.department_id 부서ID,d.department_name 부서명, 
e.first_name 이름,e.last_name 성, e.salary 급여
FROM employees e join departments d
on (e.department_id=d.department_id) AND e.salary>=12000 
ORDER BY e.salary DESC;

SELECT e.first_name 이름, e.last_name 성,
case d.department_name
        when 'Executive' then '행정부'
        when 'Shipping' then '발송부'
        else '미정'
end 부서명 
FROM employees e inner join departments d
on (e.department_id=d.department_id) ;


-------------------------------
--30번부서 사원들의 급여목록에 급여등급테이블을 조인해서 등급을 부 
--여하려 합니다.
--각 사원의 급여가 등급별 최소급여이상 최대급여이하 범위에 따라 
--등급이 정해집니다.
select e.employee_id,e.salary,
e.department_id,s.max_sal,s.grade
from employees e join  sal_grade s
on e.salary between s.min_sal and s.max_sal
where department_id = 100;

-- self join
select e1.employee_id,e1.first_name,e2.first_name
from employees e1,employees e2
where e1.manager_id = e2.employee_id
order by e1.employee_id;

select e1.employee_id,e1.first_name,e2.first_name
from employees e1 join employees e2
on e1.manager_id = e2.employee_id
order by e1.employee_id;

--outer join
select e1.employee_id,e1.first_name,e2.first_name
from employees e1,employees e2
where e1.manager_id = e2.employee_id(+)
order by e1.employee_id;

select e1.employee_id,e1.first_name,e2.first_name
from employees e1 left join employees e2
on e1.manager_id = e2.employee_id
order by e1.employee_id;

--조인 후 사원이 없는 부서명도 같이 출력되도록 할것
select e.employee_id,e.first_name,d.department_name
from employees e , departments d
where e.department_id(+) = d.department_id;

select e.employee_id,e.first_name,d.department_name
from employees e right join departments d
on e.department_id = d.department_id;

--조인후 부서배정이안된사원도 출력할것.
select e.employee_id,e.first_name,d.department_name
from employees e left join departments d
on e.department_id = d.department_id;

--using
select e.employee_id,e.first_name,d.department_name
from employees e left join departments d
using(department_id);

--full outer join
select e.employee_id,e.first_name,d.department_name
from employees e full join departments d
using(department_id);

select 
nvl(e.employee_id,0) 사번,
nvl(e.first_name,'사원없음') 이름,
nvl(d.department_name,'부서없음') 부서명
from employees e full join departments d
using(department_id);

--natural join
select employee_id,department_name
from employees natural join departments;


--1.사원 테이블과 부서 테이블을 조인하여 모든 사원ID,사원이름,급여,부서명을 
--출력하라. (부서명 내림차순 정렬)



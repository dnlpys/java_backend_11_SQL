-- index view sequence

select rowid,rownum,deptno,dname,loc 
from test_dept order by deptno desc;

create index test_tab_idx on test_dept(dname);
drop  index test_tab_idx;

select rowid,rownum,deptno,dname,loc 
from test_dept where dname>'0';
------------------------------
select /*+index_desc(test_dept test_tab_idx)*/dname
from test_dept where dname>'0' and rownum=1;

select /*+index_desc(test_dept test_tab_idx)*/max(dname)
from test_dept where dname>'0';

------------------------------
--view

select * from EMP_DETAILS_VIEW;


SELECT
  e.employee_id,
  e.job_id,
  e.manager_id,
  e.department_id,
  d.location_id,
  l.country_id,
  e.first_name,
  e.last_name,
  e.salary,
  e.commission_pct,
  d.department_name,
  j.job_title,
  l.city,
  l.state_province,
  c.country_name,
  r.region_name
FROM
  employees e,
  departments d,
  jobs j,
  locations l,
  countries c,
  regions r
WHERE e.department_id = d.department_id
  AND d.location_id = l.location_id
  AND l.country_id = c.country_id
  AND c.region_id = r.region_id
  AND j.job_id = e.job_id;

------------------------------

select employee_id,first_name,salary from employees;

------------------------------
CREATE VIEW VIEW_EMP
AS select employee_id,first_name,salary from employees
WITH READ ONLY;

drop view view_emp;

select * from view_emp;
------------------------------

select e.employee_id,d.department_id,d.department_name,e.salary
from employees e join departments d
on e.department_id=d.department_id;

----------------------------------------
CREATE or replace VIEW VIEW_EMP_DEPT(empno,fname,deptno,dname,sal,comm)
AS select e.employee_id,e.first_name,d.department_id,d.department_name,e.salary,e.commission_pct
from employees e join departments d
on e.department_id=d.department_id
WITH READ ONLY;

select * from view_emp_dept;

---------------------------
select * from test_board;
insert into test_board(wnum,writer,title,content,vcount) 
values(10,'kim','title10','content10',0);
insert into test_board(wnum,writer,title,content,vcount) 
values(20,'kim','title10','content10',0);
insert into test_board(wnum,writer,title,content,vcount) 
values(30,'kim','title10','content10',0);

create or replace view view_board as
select wnum,writer,title,content from test_board
where wnum in(20,30)
with check option;

select * from view_board;

insert into view_board values(10,'w1','t1','con1');--ORA-01402: view WITH CHECK OPTION
insert into view_board values(40,'w1','t1','con1');--ORA-01402: view WITH CHECK OPTION

----------------------------------------------

--	private int employee_id;
--	private String first_name;
--	private String last_name;
--	private int salary;
--	private Date hire_date;
--	private String job_id;

create table emp as
select employee_id,first_name,last_name,salary,hire_date,job_id
from employees;

CREATE SEQUENCE seq_emp_id START WITH 207;

select rownum,employee_id,first_name,last_name 
from emp order by employee_id desc;
delete from emp where employee_id=206;

--사원테이블(employees)에서 
--가장 최근에 입사한 사원 순으로 5명을 출력하자. 
select employee_id,first_name,last_name,hire_date  
from employees order by hire_date desc;

select employee_id,first_name,last_name,hire_date 
from (select employee_id,first_name,last_name,hire_date  
from employees order by hire_date desc)
where rownum<=5;

--사원테이블(employees)에서 
--사원번호 내림차순으로 6번째부터 10번째까지 사원들 5명을 출력하자.
select * from (select rownum rnum,employee_id,first_name,last_name,hire_date 
from (select employee_id,first_name,last_name,hire_date  
from employees order by employee_id desc))
where rnum>=6 and rnum<=10;


select rownum rnum,employee_id,first_name,last_name,hire_date  
from employees order by employee_id desc;


create or replace view 
test4_emp_join_dept_view("부서명","최저급여","최고급여","평균급여") as
select d.dname, min(e.sal), max(e.sal), avg(e.sal)
from test4_emp e, test4_dept d
where e.deptno=d.deptno
group by d.dname;

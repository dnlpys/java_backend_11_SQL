--function
--단일행 함수 >> 예 : 통계함수-합,카운트,최고값,최소값,평균..
--복수행 함수 >> 예 : 각종변환함수.,,

--1.통계함수
--전체사원수 검색
select count(*) from employees;

--매달나가는 전체사원들의 급여의 합
select sum(salary),sum(salary)*1300 from employees;

--사원들의 급여중 최고급여출력
select max(salary) from employees;

--사원들의 급여중 최소급여출력
select min(salary) from employees;

--사원들의 평균급여출력
select avg(salary) from employees;


--2. 문자함수
select chr(65),ascii('A') from dual;

--|| >> concat
select concat(first_name,job_id) from employees;

--대소문자변형
select first_name,lower(first_name),upper(first_name)
from employees;

--LPAD 여백주기
select LPAD('yangssem', 13, '*#') from dual;
select LPAD(first_name, 13, '*'),
RPAD(first_name, 13, '*') from employees;

--공백 또는 특정 문자 제거(문장의 앞뒤에만 관여)
select LTRIM('aa123456aa', 'aa'),
RTRIM('aa123456aa', 'aa')from dual;

--실데이터의 수정이 아니고 출력시에만 테이터 수정
select REPLACE('yang and sam', 'sa', 'sse') from dual;

select job_id,REPLACE(job_id, 'AC', 'TC') from employees;

select REPLACE('yang and sam', 'sa', 'sse') from dual;

--문자열의 일부분 추출
select SUBSTR('ABCDEFG', 2, 1) from dual;
select SUBSTR('ABCDEFG', 2, 2),SUBSTR('ABCDEFG', 2, 3) from dual;

select INSTR('010-2222-8888','-') from dual;
select INSTR('CORPORATE FLOOR','OR', 1, 3) from dual;

--문자열의 길이
select length('yangssem') from dual;
select first_name,length(first_name) from employees;

--사원들의 이름중 7글자이상인 사원들만 출력
select first_name,length(first_name) from employees
where length(first_name) >= 7;

--문자열들중 최대값,최소값
select greatest('CC', 'ABCDE', 'CA','ca','cc') from dual;
select least('CC', 'ABCDE', 'CA','ca','cc') from dual;

select greatest('12', '132', '34') from dual;

--정수들중 최대값,최소값
select greatest(12, 132, 34) from dual;
select least(12, 132, 34) from dual;

--출력된 데이터들중  널값이 있을경우 대체해주는함수
select salary,commission_pct,
nvl(commission_pct, 5) ,nvl(commission_pct, 5)*salary
from employees;

select salary,commission_pct,
nvl2(commission_pct, 5,10) ,nvl2(commission_pct, 5,10)*salary
from employees;

select salary + salary * nvl2(commission_pct, 5,10)   
from employees;

--decode : 컬럼에 적용하는 분기함수
select last_name, job_id, salary,
decode( job_id, 'IT_PROG', salary*1.1,salary) AS "실수령액" 
from employees;

select last_name, job_id, salary,
decode( job_id, 
    'IT_PROG', salary*1.1,
    'AD_PRES', salary*1.2,
    'AD_VP', salary*1.3,
    salary) AS "실수령액" 
from employees;

--case when then : 컬럼에 적용하는 분기함수
select last_name, job_id, salary,
case job_id 
    when 'IT_PROG' then salary*1.1
    when 'AD_PRES' then  salary*1.2
    when 'AD_VP' then  salary*1.3
    else salary 
end AS "실수령액" 
from employees;

--2) 날짜함수
select sysdate,sysdate+1,sysdate-1 from dual;


select 
sysdate,
add_months(sysdate,1), 
add_months('23/05/06',1),
add_months('23/12/06',-3)
from dual;

--해다월의 마지막 일
select HIRE_DATE, LAST_DAY(HIRE_DATE) from employees;
select HIRE_DATE, NEW_TIME(HIRE_DATE, 'GMT', 'PDT') 
from employees where EMPLOYEE_ID=100;

--두날짜간의 개월수
select sysdate,hire_date,months_between(sysdate,hire_date) 
from employees;

--1:일요일, 2:월요일,, 가장가까운 요일의 날짜
select NEXT_DAY(sysdate ,3) from dual;
select NEXT_DAY(sysdate ,6) from dual;

--3) 문자변환함수

--to_char
select SYSDATE, 
TO_CHAR(SYSDATE, 'D'),
TO_CHAR(SYSDATE, 'DAY'),
TO_CHAR(SYSDATE, 'DY'),
TO_CHAR(SYSDATE, 'MM'),
TO_CHAR(SYSDATE, 'MONTH'),
TO_CHAR(SYSDATE, 'YYYY'),
TO_CHAR(SYSDATE, 'YY'),
TO_CHAR(SYSDATE, 'DD')
from dual;

select SYSDATE, 
TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
TO_CHAR(SYSDATE, 'HH:MI:SS')
from dual;

--숫자변환함수,오라클의 자동캐스팅기능도 있다.
select to_number('100')+1,'100'+1 from dual;

--날짜변환함수
select sysdate, TO_DATE(sysdate, 'yy/mm/dd') FROM dual;
select sysdate, TO_DATE('13-03-20', 'dd/mm/yy') FROM dual;

--시스템함수
select user from dual; --커넥트된 사용자명 반환.


--숫자함수
select 
avg(salary),    --전체평균
ceil(avg(salary)), -- 소숫점이하 올림
floor(avg(salary)),  --소숫점이하 내림,버림
round(avg(salary)),
round(avg(salary),3)   -- 반올림,자릿수 설정가능.
from employees;

--count()
select count(*) from employees;

select count(commission_pct) from employees;

select count(employee_id) from employees;

select count(department_id) from employees;
select count(salary) from employees;
--sum()
select sum(salary),avg(salary),sum(salary)/107 from employees;

--avg()
select avg(commission_pct),sum(commission_pct)/35 from employees;

select department_id , floor(avg(salary)) 
from employees
--where department_id is not null --그룹별 처리전 조건절
group by department_id
having department_id is not null;  --그룹별 처리후 조건절

select job_id , floor(avg(salary)) 
from employees
group by job_id;

select job_id , floor(sum(salary)) 
from employees
group by job_id;

select location_id,department_name
from departments
group by location_id,department_name;



---문제풀기
--Q1:연봉 8000이상인 사원들의 부서별 평균연봉의 반올림값을 출력하라.





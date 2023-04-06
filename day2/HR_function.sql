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
select chr(65) from dual;

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


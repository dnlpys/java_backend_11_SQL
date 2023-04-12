-- DDL DML TCL

--DDL - create,drop ,alter,truncate

create table sample1(
num number primary key,
fname varchar2(20),
lname varchar2(20) not null,
tel varchar2(20) not null,
addr varchar2(100),
regdate date default sysdate
);

create sequence sample1_seq;

create table emp as select * from employees;
create table emp as select * from employees where 1=2;
drop table emp;


select * from employees;

create table sample2(num number);

alter table sample2 add (fname varchar2(20));
alter table sample2 add (lname varchar2(20));
alter table sample2 add (tel varchar2(20));
alter table sample2 add (addr varchar2(100));
alter table sample2 add (memo varchar2(100));

alter table sample2 modify (memo date default sysdate);
alter table sample2 modify (num number primary key);

insert into sample2(num,fname,lname,tel,addr) 
values(SAMPLE1_SEQ.nextval,'gildong','Hong','02','seoul');

alter table sample2 rename column memo to regdate;

alter table sample2 drop column addr;

alter table sample2 add (addr1 varchar2(100));
alter table sample2 add (addr2 varchar2(100));
alter table sample2 add (addr3 varchar2(100));

alter table sample2 set unused column addr1;
alter table sample2 set unused (addr2,addr3);
alter table sample2 drop unused columns;

----------------------------
--제약조전 변경
create table sample3(
num number ,
join_id varchar2(20)
);
alter table sample3 add constraint sample3_pk primary key(num);

alter table sample3 drop constraint sample3_pk;

create table sample4(
join_id varchar2(20) primary key
);

alter table sample3 add constraint sample3_fk_join_id
foreign key(join_id) references sample4(join_id);

insert into sample4 values('j001');
insert into sample3(num,join_id) values(1,'j001');

alter table sample3 drop constraint sample3_fk_join_id;

delete from sample4 where join_id='j001';
delete from sample3 where join_id='j001';

alter table sample3 disable constraint sample3_fk_join_id;
alter table sample3 enable constraint sample3_fk_join_id;
alter table sample3 disable primary key;
alter table sample3 enable primary key;
alter table sample3 read only;
alter table sample3 read write;

drop table sample4;

truncate table sample3;

-- DML : insert ,update, delete
select floor(dbms_random.value()*49)+1 from dual;
select dbms_random.string('A',10),dbms_random.string('Q',10) from dual;

insert into 
sample1( num,fname,lname, tel, addr )
values(  sample1_seq.nextval, 
dbms_random.string('A',10), 
dbms_random.string('Q',10), 
'010-0000-000'||sample1_seq.nextval,
'seoul'||sample1_seq.nextval );

--BEGIN
--  for i in 1..50 loop
--    insert into 
--    sample1( num,fname,lname, tel, addr )
--    values(  sample1_seq.nextval, 
--    dbms_random.string('A',10), 
--    dbms_random.string('Q',10), 
--    '010-0000-000'||sample1_seq.nextval,
--    'seoul'||sample1_seq.nextval );
--  end loop;
--  commit;
--END;

select count(*) from sample1;

--프로시저 실행 명령
exec SAMPLE1_INSERT;

--update

update sample1 
set 
fname = 'yangssem',
lname = 'Yang';

select * from sample1;
select * from sample1  where num=11;

--delete 

delete from sample1
where num =12;

delete from sample1
where fname like '%yang%';


--merge : 병합
create table TEST1 (pnum number,p2num number,pcount number,price number);
insert into test1 values(1001,2001,100,5000);
insert into test1 values(1002,2002,100,3000);
insert into test1 values(1003,2003,100,2000);

update test1 set p2num=2222,pcount=111,price=5555
where pnum = 1001;

select * from test1;

create table TEST2 (pnum number,p2num number,pcount number,price number);
insert into test2 values(6001,7001,300,7000);
insert into test2 values(6002,7002,300,8000);
insert into test2 values(6003,7003,300,9000);
insert into test2 values(6004,7777,300,9000);

update test2 set p2num=8888,pcount=333 where pnum=6004;

select * from test2;

create table TEST_merge (pnum number,p2num number,pcount number,price 
number);
select * from TEST_merge;

MERGE  INTO test_merge tm USING test1 t1 
ON (tm.pnum=t1.pnum)
WHEN MATCHED THEN 
UPDATE SET tm.p2num=t1.p2num ,tm.pcount=t1.pcount,tm.price=t1.price
WHEN NOT MATCHED THEN
INSERT VALUES(t1.pnum, t1.p2num, t1.pcount, t1.price);

MERGE  INTO test_merge tm USING test2 t2 
ON (tm.pnum=t2.pnum)
WHEN MATCHED THEN 
UPDATE SET tm.p2num=t2.p2num ,tm.pcount=t2.pcount
WHEN NOT MATCHED THEN
INSERT VALUES(t2.pnum, t2.p2num, t2.pcount, t2.price);



-- TCL : commit, rollback, savepoint
create table test_tcl 
as (select * from departments);

select * from test_tcl;

commit;

update test_tcl set department_id=111
where department_id=10;

savepoint p01;

update test_tcl set department_id=111
where department_id=30;

savepoint p02;

delete from test_tcl;

rollback to p02;
rollback to p01;
select * from test_tcl;

---------------------------------------

create table test_board(
wnum number primary key,
writer varchar2(20) not null,
title varchar2(100) not null,
content varchar2(4000) not null,
wdate date default sysdate not null,
vcount number default 0
);

create sequence seq_test_board;
drop sequence seq_test_board;



--BEGIN
--  for i in 1..10 loop
--    insert into test_board(wnum,writer,title,content) 
--    values(SEQ_TEST_BOARD.nextval,
--    'kim'||SEQ_TEST_BOARD.nextval,
--    'title'||SEQ_TEST_BOARD.nextval,
--    'content'||SEQ_TEST_BOARD.nextval);
--  end loop;
--  commit;
--END;

select * from test_board order by wnum desc;

delete from test_board where wnum=4;
delete from test_board where writer='kim1';

insert into test_board(wnum,writer,title,content) 
values(SEQ_TEST_BOARD.nextval,
'YANGSSEM',
'title'||SEQ_TEST_BOARD.nextval,
'content'||SEQ_TEST_BOARD.nextval);

update test_board set content='즐거운 ORACLE SQL'
where writer='YANGSSEM';

select * from test_board
where title like '%ORACLE%' or content like '%ORACLE%';

alter table test_board add (comm_ch varchar2(1));

desc test_board;

truncate table test_board;
select * from test_board;
drop table test_board;

select * from tab;
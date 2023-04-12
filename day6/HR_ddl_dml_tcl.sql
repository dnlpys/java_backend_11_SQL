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


-- TCL : commit, rollback


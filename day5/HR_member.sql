--member table
CREATE TABLE MEMBER 
(
  NUM NUMBER NOT NULL 
, ID VARCHAR2(20) NOT NULL 
, PW VARCHAR2(20) NOT NULL 
, NAME VARCHAR2(20) NOT NULL 
, TEL VARCHAR2(20) NOT NULL 
, CONSTRAINT MEMBER_PK PRIMARY KEY 
  (
    NUM 
  )
  ENABLE 
);

drop table MEMBER ;

-- 시퀀스 : 번호 자동생성 스키마
CREATE SEQUENCE SEQ_MEMBER;
DROP SEQUENCE SEQ_MEMBER;

select * from member;

insert into member(num,id,pw,name,tel) 
values(SEQ_MEMBER.nextval,'admin2'||SEQ_MEMBER.nextval,'hi2222','lee2','012');

truncate table member; -- 모든 행 삭제,rollback불가능

commit;  --저장,확정
rollback; --취소,되돌리기


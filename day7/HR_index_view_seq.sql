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
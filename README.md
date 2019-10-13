cqlsh> create keyspace dev with replication = {'class':'SimpleStrategy','replication_factor':1};
cqlsh> use dev;
cqlsh:dev> create table emp (empid int primary key, emp_first varchar, emp_last varchar, emp_dept varchar);
cqlsh:dev> insert into emp (empid, emp_first, emp_last, emp_depat) values (1, 'vishv', 'deepak', 'soft');
InvalidRequest: Error from server: code=2200 [Invalid query] message="Unknown identifier emp_depat"
cqlsh:dev> insert into emp (empid, emp_first, emp_last, emp_dept) values (1, 'vishv', 'deepak', 'soft');
cqlsh:dev> insert into emp (empid, emp_first, emp_last, emp_dept) values (2, 'moti', 'kumar', 'soft');
cqlsh:dev> select * from emp;

 empid | emp_dept | emp_first | emp_last
-------+----------+-----------+----------
     1 |     soft |     vishv |   deepak
     2 |     soft |      moti |    kumar

(2 rows)
cqlsh:dev> select * from emp;

 empid       | emp_dept | emp_first | emp_last
-------------+----------+-----------+----------
           1 |     soft |     vishv |   deepak
           2 |     soft |      moti |    kumar
 -1360609918 |      CEO | Valli Sri |   Tolety
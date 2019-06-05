### Insert into

새로운 데이터를 추가하려면 insert  권한 또는 테이블의 소유자

insert into 테이블명 [컬럼명]

values (값)



insert into 테이블명

values (테이블에 선언된 컬럼값이 모두 와야함)



```sql
명령의 1 행에서 시작하는 중 오류 발생 -
insert into emp(empno,ename,deptno)
values (9000,'Kim',70)
오류 보고 -
ORA-02291: 무결성 제약조건(SCOTT.FK_DEPTNO)이 위배되었습니다- 부모 키가 없습니다
--FK의 참조 컬럼에 70번deptno가 없어서 오류

명령의 1 행에서 시작하는 중 오류 발생 -
insert into emp(empno,ename,deptno,hiredate)
values (9000,'Kim',50,sysdate)
오류 보고 -
ORA-02291: 무결성 제약조건(SCOTT.FK_DEPTNO)이 위배되었습니다- 부모 키가 없습니다
--FK의 참조 컬럼에 50번 deptno가 없어서 오류
```

```sql
명령의 1 행에서 시작하는 중 오류 발생 -
insert into emp(empno,ename,deptno,hiredate)
values (9001,'Lee',50,'19년3월2일')
오류 보고 -
ORA-01861: 리터럴이 형식 문자열과 일치하지 않음
--날짜 데이터의 형식이 일치하지 않다.
--to_date(형변환함수)를 사용한다.
insert into emp(empno,ename,deptno,hiredate)
values (9001,'Lee',50,to_date('19/03/02'));

```



### 구조만 생성하기CTAS

```sql
create table emp10
as (select * from emp where 1=2);

```



> select를 이용하여 데이터 넣기

```sql
insert into emp10
select * from emp where deptno =10;

7782	CLARK	MANAGER	7839	81/06/09	2450		10
7839	KING	PRESIDENT		81/11/17	5000		10
7934	MILLER	CLERK	7782	82/01/23	1300		10
```



### update 하기

update 테이블명 set 컬럼명 = new 컬럼값

```sql
update emp10 set sal =1;

update emp10 set (select sal from emp where deptno=20) where deptno=20;
```



```sql
update deptno
set deptno=100
where dname = 'IT'; --컬럼 사이즈 초과

update deptno
set deptno=40
where dname = 'IT';--deptno : 40  중복값

update deptno
set deptno=100
where dname = 'IT';--참조 무결성 제약조건 오류
```

> smith사원의 급여를 king사원의 급여와 동일하도록 변경하세요.

```sql
update emp
set sal = (select sal from emp where ename='KING')
where ename='SMITH';
```

> king사원과 동일한 부서에서 근무하는 king을 제외한 다른 사원의 급여를 20%인상수정합니다.

```sql
update emp
set sal = sal*1.2
where deptno = (select deptno from emp where ename='KING')
and ename!='KING'
```



### 삭제(delete)

```sql
delete from emp;

delete from emp where 조건~ ;
```

```sql
명령의 23 행에서 시작하는 중 오류 발생 -
delete from dept
오류 보고 -
ORA-02292: 무결성 제약조건(SCOTT.FK_DEPTNO)이 위배되었습니다- 자식 레코드가 발견되었습니다
--자식테이블에서 참조하는 값이 있을경우 삭제 불가능
```

> adams사원과 동일한 직무를 담당하는 사원 삭제(adams제외)

```sql
delete from emp 
where job=(select job from emp where ename='ADAMS') 
and ename != 'ADAMS';
```

### Merge

* ETL작업에서 많이 사용된다

```sql
merge into 대상테이블 별명1 
using 소스테이블 별명2
on 별명1.pk = 별명2.pk
when match then
update set 별명1.컬럼 = 별명2.컬럼....
[delete where 조건]
when not matched then
insert (별명1.컬럼리스트)
values (별명2.컬럼리스트)

```

### 트렌젝션

* unit of work(분리되어 수행 될 수 없는 작업단위)

ACID - 원장성,일관성,격리성,영속성

DB관점 

* 트렌젝션은 변경이 포함되면 select는 트렌젝션으로 포함되지 않는다.

* 사용중인 DML트랜잭션의 세션이 비정상종료하면 oracle server는 rollback합니다.

* 사용중인 DML트랜잭션의 세션이 정상종료하면 oracle server는 commit합니다.

  



###### 트렌젝션의 단위

* 한개 이상의 DML들로 구성 - 명시적commit ,rollback

* 한개의 DDL - auto commit

* 한개의 DCL - auto commit

   

##### 읽기일관성 

select들이 변경중인 user들을 기다리지 않아도 괜찮다.

변경 작업을 하려는 user는 select를 하여 검색을하는 유저들의 종료를 기다리지 않아도 괜찮다.

변경작업 중인 user는 중간 결과를 변경된 결과로 볼 수 있고

변경 작업 중이지 않은 user들은 commit하기 전의 결과를 볼 수 있다.



오라클 서버는 읽기 일관성을 위해서lock , undo segment등을 지원합니다.



###### SAVEPOINT 연습

```sql
insert into testtable values(1);
insert into testtable values(2);
savepoint a;
insert into testtable values(3);
insert into testtable values(4);
savepoint b;
insert into testtable values(5);
insert into testtable values(6);
rollback to savepoint b;
select * from emp;
```




### Sequence



###### 시퀀스 생성

```sql
create sequence emp_seq;
select * from user_sequences;
--시퀀스 객체를 생성하면 자동으로 시퀀스의 내장 컬럼 currval nextval을 생성

select emp_seq.currval from dual;
select emp_seq.nextval from dual;--next먼저 실행해야 current를 실행할수있다.
```

###### 시퀀스 변경

```sql
alter sequence
```

###### 시퀀스 삭제

```sql
drop sequence
```



# Synonym

테이블의 이름이 너무 길때 별칭을 붙여주는것



###### 동의어 생성하기

```sql
SQL> create synonym e for scott.emp;

동의어가 생성되었습니다.
```

###### 동의어 조회하기

```sql
SQL> select * from e;
```

###### 동의어 삭제하기

```sql
SQL> drop synonym e;

동의어가 삭제되었습니다.
```


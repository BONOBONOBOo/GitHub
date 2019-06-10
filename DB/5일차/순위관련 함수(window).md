### 순위관련 함수

rank() over() 

dense_rank()

row_number()

```sql
(partition by ~ 

order by ~

[rows(행기준) or range(열기준)] unbounded preceding | unbounded following

preceding	~

folloing	~)
```



### 행순서 관련 함수

firstvalue()

lastvalue()

lag(컬럼,n,null대체값)

lead(컬럼,n,null대체값)




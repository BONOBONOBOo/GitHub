```
http://www.apache.org/dyn/closer.cgi/hive/

[root@master local]# tar -xzvf /home/hadoop/Downloads/apache-hive-1.2.2-bin.tar.gz 
[root@master local]# chown -R hadoop:hadoop apache-hive-1.2.2-bin/

[root@master local]# ln -s apache-hive-1.2.2-bin/  hive
[root@master local]# ls -l

[root@master local]# chown -R hadoop:hadoop hive
[root@master local]# ls -l

#마스터에서 hadoop 환경설정 파일 변경
[root@master local]# su - hadoop
[hadoop@master ~]$ vi .bash_profile

export HIVE_HOME=/usr/local/hive
export PATH=$PATH:$JAVA_HOME/bin:$HADOOP_HOME/bin:$HIVE_HOME/bin:



#마스터 노드에 hive 메타스토어 mysql 구성 (로컬모드)
[root@master ~]# rpm -ivh /home/hadoop/Downloads/mysql-community-release-el6-5.noarch.rpm
[root@master ~]#  ls -la /etc/yum.repos.d/
[root@master ~]# yum install mysql-server

[root@master ~]# ls /usr/bin/mysql
[root@master ~]# ls /usr/sbin/mysqld

#mysql 서버 시작
[root@master ~]#  service mysqld start

[root@master ~]# mysql --version
[root@master ~]# netstat -anp | grep mysql



 
[root@master ~]#  mysql 
#루트 사용자의 암호를 설정한다.
 
mysql> grant all privileges on *.* to hive@localhost identified by 'hive' with grant option  
mysql> show databases;
mysql> use mysql
mysql> show tables;
mysql> select user from user;
mysql> flush privileges;
 
 
 
# hive-env.sh  설정파일 생성 및 변경
[hadoop@master ~]$ cd /usr/local/hive/conf/
[hadoop@master ~]$ cp hive-env.sh.template  hive-env.sh
[hadoop@master ~]$ vi hive-env.sh
HADOOP_HOME=/usr/local/hadoop-2.7.7
[hadoop@master ~]$  chmod 755 hive-env.sh 



# /usr/local/hive/conf/hive-site.xml을 수정
[hadoop@master ~]$ vi /usr/local/hive/conf/hive-site.xml

<?xml version="1.0"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<configuration>
<property>
  <name>hive.metastore.local</name>
  <value>true</value>
</property>
<property>
  <name>javax.jdo.option.ConnectionURL</name>
  <value>jdbc:mysql://localhost:3306/metastore_db?createDatabaseIfNotExist=true</value>
  <description>JDBC connect string for a JDBC metastore</description>
</property>
<property>
  <name>javax.jdo.option.ConnectionDriverName</name>
  <value>com.mysql.jdbc.Driver</value>
  <description>Driver class name for a JDBC metastore</description>
</property>
<property>
  <name>javax.jdo.option.ConnectionUserName</name>
  <value>hive</value>
  <description>username to use against metastore database</description>
</property>
<property>
  <name>javax.jdo.option.ConnectionPassword</name>
  <value>hive</value>
  <description>password to use against metastore database</description>
</property> 
  </configuration>
  
  
  #metastore 로 사용할 database 생성 및 metastore에 스키마 생성
[hadoop@master ~]$ su -
[root@master ~] mysql -u root -p
Enter password:
mysql> show databases;
mysql> CREATE DATABASE metastore_db;

mysql> USE metastore_db;
mysql> show tables;
mysql> SOURCE /usr/local/hive/scripts/metastore/upgrade/mysql/hive-schema-1.1.0.mysql.sql;
mysql> show tables;
 
# $HIVE_HOME/lib 아래 mysql-connector-java-5.1.36-bin.jar에 복사 
[hadoop@master ~]$ tar -xvf ./Downloads/mysql-connector-java-5.1.36.tar.gz
[hadoop@master ~]$ ls
[hadoop@master ~]$ cd  /home/hadoop/mysql-connector-java-5.1.36/
[hadoop@master ~]$ cp  mysql-connector-java-5.1.36-bin.jar /usr/local/hive/lib/


#하둡 시작
[hadoop@master ~]$ cd /usr/local/hadoop-2.7.7/sbin
[hadoop@master ~]$ ./start-all.sh

[hadoop@master ~]$ hive
hive> show databases;




hive> create database test_db;
hive> use test_db
hive> create table test ( name  varchar(10) );
hive> describe test

#하둡 DFS에 데이터베이스와 테이블은 디렉토리로 생성됨을 확인
[hadoop@master ~]$ hadoop fs -ls -R /user/

#metastore에서 생성한 데이터베이스와 테이블 메타 정보 확인
mysql> select OWNER, TBL_NAME, TBL_TYPE from TBLS;
mysql> select OWNER_NAME, OWNER_TYPE, NAME from DBS;




hive> drop database test_db cascade;
hive> show databases;

 
hive> CREATE EXTERNAL TABLE airline (
Year string,
Month string,
DayofMonth string,
DayOfWeek string,
DepTime string,
CRSDepTime string,
ArrTime string,
CRSArrTime string,
UniqueCarrier string,
FlightNum string,
TailNum string,
ActualElapsedTime string,
CRSElapsedTime string,
AirTime string,
ArrDelay string,
DepDelay string,
Origin string,
Dest string,
Distance string,
TaxiIn string,
TaxiOut string,
Cancelled string,
CancellationCode string,
Diverted string,
CarrierDelay string,
WeatherDelay string,
NASDelay string,
SecurityDelay string,
LateAircraftDelay  string
)
ROW FORMAT DELIMITED
 FIELDS TERMINATED BY ',' 
 LINES TERMINATED BY '\n'
LOCATION '/data/airline/';


#월별 도착지연횟수를 출력하는 select문
hive> SELECT Year,Month, count(DepDelay)
      FROM airline
      GROUP BY Year,Month
      SORT BY Year,Month;   --reducer 별 처리 데이터 정렬, 전체 결과 정렬되지 않음


hive> SELECT Year,Month, count(DepDelay)
      FROM airline
      GROUP BY Year,Month
      ORDER BY Year,Month;   ----reducer개수 1개로 제한, 전체 정렬


hive> explain SELECT Year,Month, count(DepDelay)
      FROM airline
      GROUP BY Year,Month
      SORT BY Year,Month;

[hadoop@master ~]$ vi /home/hadoop/dept.txt 
10,'ACCOUNTING','NEW YORK'
20,'RESEARCH','DALLAS'
30,'SALES','CHICAGO'
40,'OPERATIONS','BOSTON'


hive> CREATE TABLE IF NOT EXISTS dept (
deptno INT, dname STRING, loc STRING)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ',';

hive> describe dept

hive> load data local inpath '/home/hadoop/dept.txt' 
      overwrite into table dept;
hive> select  * from dept;

hive> !hadoop fs -ls /user/hive/warehouse/


1. carriers.csv파일을 carriers테이블을 생성하고, 데이터 로딩하고
   hive> CREATE TABLE IF NOT EXISTS carriers (
   UniqueCarrier string,
   CarrierFullName String
   ) ROW FORMAT DELIMITED
 FIELDS TERMINATED BY ',' 
 LINES TERMINATED BY '\n'
LOCATION '/data/metadata/';
   
   hive> describe carriers;
   hive> select * from carriers limit 5;
   hive> !hadoop fs -ls /user/hive/warehouse/

2.  airlineinfo 테이블 생성
   hive> CREATE TABLE IF NOT EXISTS airlineinfo (
   UniqueCarrier string,
   CarrierFullName String,
   FlightNum string,
   TailNum string,
   Dest string,
   Distance string,
   Cancelled string
   );

hive> describe airlineinfo
hive> !hadoop fs -ls /user/hive/warehouse/

3. airline테이블과 carriers테이블의 조인 결과를 airlineinfo 테이블에 로딩

hive> INSERT  OVERWRITE  TABLE  airlineinfo 
 select  a.UniqueCarrier ,
   b.CarrierFullName ,
   a.FlightNum,
   a.TailNum ,
   a.Dest ,
   a.Distance ,
   a.Cancelled 
 from  airline a , carriers b  
where a.UniqueCarrier = substr(b.UniqueCarrier2, 2);

hive> select * from airlineinfo limit 10;
hive> !hadoop fs -ls /user/hive/warehouse/

또는 

hive> drop table airlineinfo;
hive> CREATE TABLE airlineinfo 
 as
   select  a.UniqueCarrier  UniqueCarrier,
   b.CarrierFullName  CarrierFullName,
   a.FlightNum FlightNum,
   a.TailNum  TailNum ,
   a.Dest  Dest,
   a.Distance  Distance,
   a.Cancelled  Cancelled
 from  airline a , carriers b 
 where a.UniqueCarrier = substr(b.UniqueCarrier, 2, 2);

hive> select * from airlineinfo limit 10;
hive> !hadoop fs -ls /user/hive/warehouse/

hive> select count(*) from airlineinfo ;
hive> select count(*) from airline ;



https://wikidocs.net/33948


[root@master ~]# yum install epel-release
[root@master ~]# yum install npm
[root@master ~]# yum install R 
[root@master ~]# ls -l /usr/lib64
[root@master ~]# chown -R hadoop:hadoop /usr/lib64/R
[root@master ~]# ls -l /usr/lib64



#hadoop의 .bash_profile에 추가
[hadoop@master ~]$ vi .bash_profile

export HADOOP_CMD=/usr/local/hadoop-2.7.7/bin/hadoop
export HADOOP_STREAMING=/usr/local/hadoop-2.7.7/share/hadoop/tools/lib/hadoop-streaming-2.7.7.jar

[hadoop@master ~]$ source ./.bash_profile
[hadoop@master ~]$ R

> install.packages(c("rJava", "Rcpp", "RJSONIO", "bitops", "digest", "functional", "stringr", "plyr", "reshape2", "caTools"))
> install.packages(c("rhdfs", "rmr", "plyrmr"))


[root@master ~]# chown -R hadoop:hadoop /usr/share/doc/R-3.6.0/html/
> updatge.packages(c("rJava", "Rcpp", "RJSONIO", "bitops", "digest", "functional", "stringr", "plyr", "reshape2", "caTools"))


https://github.com/RevolutionAnalytics/RHadoop/wiki
 

> install.packages("/home/hadoop/Downloads/rhdfs_1.0.8.tar.gz", repos=NULL, type="source")

> install.packages("/home/hadoop/Downloads/rmr2_3.3.1.tar.gz", repos=NULL, type="source")
> install.packages("/home/hadoop/Downloads/plyrmr_0.6.0.tar.gz", repos=NULL, type="source")
> install.packages("/home/hadoop/Downloads/rhbase_1.2.1.tar.gz", repos=NULL, type="source")

> install.packages("/home/hadoop/Downloads/ravro_1.0.4.tar.gz", repos=NULL, type="source")

> install.packages(c("bit64", "rjson"))


#Swap 메모리 늘리기
1. 2G로 설정한 swap공간 확인 2048*1024=2097152
[root@master ~]# free

2.스왑 파일을 저장할 디렉토리를 만든다
[root@master ~]# mkdir /swap


3. dd 명령어를 이용하여 swapfile이라는 스왑파일을 만든다.
[root@master ~]# dd if=/dev/zero of=/swap/swapfile bs=1024 count=4194304
 


4. swap 디렉토리로 이동한다.
[root@master ~]#  cd /swap



5. mkswap 명령어를 이용하여 swapfile이 스왑공간을 쓰도록 만든다. (스왑 영역 생성)
[root@master ~]#  mkswap swapfile

 
6. 스왑파일을 즉시 활성화 할 수 있다.
[root@master ~]# swapon swapfile
[root@master ~]# swapon -s  
[root@master ~]# free
```
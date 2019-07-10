#Spring framework특성



경량 컨테이너 지원(제공)

Factory패턴이 적용된 Ioc컨테이너는 DI(의존하는 객체를 직접 생성하지 않고)의존 객체를 전달하는

AOP(관점 지향) 지원 핵심 로직과 공통 로직을 분리해서 핵심 로직 수행할때 공통로직을 사용

POJO로 Bean을 정의해서 사용할 수 있다록 지원

영속성과 관련된 다양한API지원

트랜잭션 처리를 위한 일관된 방법으로 처리,관리 지원

배치 처리,메시지 처리, 다양한 API지원

Framework를 위

Spring Core 모듈 - IoC기능 지원(Spring Container 클래스 : BeanFactory)

Spring Context core가 지원하는 기능외에 추가적인 기능을 지원

Spring AOP 모듈  

* 관점 지향 프로그래밍 지원

Spring DAO 모듈 

* JDBC보다 더 쉽고 간결하게 개발 가능

Spring ORM 모듈 

* Hibernate,MyBatis,JDO

Spring Web 모듈

* MVC패턴이 적용된 Web App개발 지원

Spring Web MVC 모듈

* 다양한 Web UI , 기술 등의 API 지원



의존 객체를 생성해서 주입 방식

1. 생성자를 이용해서 주입
2. set method를 이용해서 주입



Bean 설정 방식

1. xml 설정 방식

   <bean id = ""

   ​			name = ""

   ​			class ="" >

   <constructor-arg>ref="Bean이름"</constructor-arg>//하나일때

   <property type="" index="" value="" ref="Bean이름" />

2. 자바 클래스와 Annotation

   @Configuration

   @ 빈을 리턴하는 메서드 선언부에 @Bean선언 빈의 이름은 메서드 이름

소스에서 빈 요청 할때

컨테이너 객체.getBean("빈 이름",빈타입.class)
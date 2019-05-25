### 자바 환경변수 설정

---

1. 시스템 변수 만들기 JAVA_HOME(C:\Program Files (x86)\Java\jdk1.8.0_211)
2. 시스템 변수의 path편집 (%JAVA_HOME%\bin; 추가)
3. cmd에서 java입력해보기



## 자바 특징

1. 객체지향 언어 - 속성과 기능 설계는 클래스로 합니다.
2. 플랫폼(하드웨어,운영체제) - 한번 작성하고 어디서든 실행시킨다.
   * OS에 의존적이지 않게 하기위해 실행 환경을 제공해주는 JRE가 있기 때문에 가능
3. 컴파일 + 인터프리터 언어 ( 정적언어)
   * 이름.java소스코드
   * javac
   * 중간언어 : byte코드로 변환된.class
   * java(바이트코드 메모리에 로딩 > 실행)
4. 간단하다.
   * 기본 8개의 데이터 타입
   * pointer가 없다.
   * 메모리 할당은 자동으로 garbage collector가 처리해줌
   * 유용한 클래스 인터페이스 API제공
5. 멀티 스레드 프로그래밍 구현이 쉽다.
6. 네트워크 분산 프로그래밍 구현가능



#### java와 javac

---

* java : 실행도구
* javac : 컴파일 도구

### 

#### 프로모션과 캐스팅

---

* 프로모션 :     크기가 더 작은 자료형을 더 큰 자료형에 대입할때 자동으로 작은자료형이 큰 자료형으로 변환되는 현상이다. 

  ```java
  public class Promotion{
      public static vodi main(String[] args){
          int a = 10;
          float b = a;#프로모션
          System.out.println("a");
          System.out.println("b");
      }
  }
  ```

  

* 캐스팅 : 크기가 더 큰 자료형을 더 작은 자료형에 대입할 때 명시적으로 타입을 바꿔주는것이다.

  ~~~java
  public class Promotion{
      public static vodi main(String[] args){
          double a = 10;
          int b = (int)a;#캐스팅
          System.out.println("a");
          System.out.println("b");
      }
  }
  ~~~

  
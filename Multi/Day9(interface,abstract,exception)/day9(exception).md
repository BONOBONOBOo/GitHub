# 예외처리란?

* 개발자가 의도적으로 에러를 조절하고싶을때 사용한다.



###### 예외의 종류

* 컴파일 오류 - 문법적 문제 . 언어의 규칙에 맞지 않는 문제
* 런타임 오류 - 실행시에 발생되는 오류 - 논리오류
  * 자바의 런타임 오류
    * XXXError(프로그램을 추정할수없음,무거움)
    * 프로그램적으로 수정하면 정상적으로 프로그램흐름을 유도
  * 자바의 예외 
    * checked exception : 실행범위가 JRE를 벗어나는 코드에 대해서 컴파일시 check해줌
      * ex)소켓,10exception
    * unchecked exception : 실행범위가 JRE를 벗어나지 않음 사용자부주의 또는 논리 오류에 의해서 발생될 수 있는 Exception
      * NullPointException(객체를 생성하지 않고 그 객체를 참조한 경우 , 배열,)

## 예외처리 방식(Declear)

* 예외처리(decleare) throw
  * declear방식 - throws 예외 클래스이름을 매서드 선언부에 선언함.
  * 예외처리대신에 메서드를 호출한 곳으로 예외 처리를 넘긴다.

``` java
import java.io.IOException;

public class ThrowTest {
	public static void methodA() throws IOException {
		methodB();
		System.out.println("methodA processed");
	}
	public static void methodB() throws IOException {
		methodC();
		System.out.println("methodB processed");
	}
	public static void methodC() throws IOException {
		//processint code
		//if(특정 조건 체크) 더이상 코드 진행이 불가능할 때 예외를 던져서 호출한곳에 메세지를줌
		if(true) throw new IOException("예외처리 연습");
		
		System.out.println("methodC processed");
	}
	public static void main(String[] args) throws IOException {
		methodA();
	}
}
		
```



* 예외처리(handle) : try ~ catch ~ finally

```
try{
	예외 발생 가능성 문장;
	문장;
}
chatch(예외 클래스 타입 객체){//여러번 사용가능 
	예외 처리 문장;		   //catch를 여러개 지정 할 때 하위에서 상위 에외까지 순차적으로 진행
}
finally{//finally block안에 다시 try~catch구문을 사용할 수 있다.
예외 발생과 무관하게 수행해야하는 문장;
}
```

```java
public class EventTest {

	public static void main(String[] args) {
		System.out.println("main start");
		
		int num = -1;
		
		try {
			num = Integer.parseInt(args[0]);
			System.out.println("other statement processing ...");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열관련 예외 처리");
		}
		catch(NumberFormatException e) {
			System.out.println("숫자 형식 관련 예외 처리");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("resource 정리");
		}
		
		if(num%2==0 && num>0) {
			System.out.println("짝");
		}
		else if(num%2==1 && num>0){
			System.out.println("짝");
		}
		System.out.println("main end");
		
	}

}
```

* 사용자 정의 예외 클래스

  API
	java.lang.Throwable 
  						- java.lang.Error 
	
  						- java.lang.Exception
	
  의 구조를 갖고 있는데 사용자가 원하는 exception의 종류를 임의로 만들기 위해 사용자 정의 예외 클래스라는 구체적인 예외처리 관련 API의 예외의 속성과 메서드를 추가해서 만듭니다.

  

  만드는 형식

  ​	사용자 정의 예외 클래스를 정의 할때 exception 을상속을 받아서 예외처리에 속성과 메서드를 추가해서 만듭니다.
  
  ​	public class XXXException extends Exception{
  
  ​	속성
  
  ​	생성자
  
  ​	멤버 메서드
  
  ​    }

```java
AbnomalValueException.java

public class AbnomalValueException extends Exception{
	private double oldTall = 161.2;
	
	public AbnomalValueException(String message) {
		super(message);
	}
	
	public double getOldTall() {
		return oldTall;
	}
}
```




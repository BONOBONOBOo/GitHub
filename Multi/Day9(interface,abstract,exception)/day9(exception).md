# 예외처리란?

* 개발자가 의도적으로 에러를 무시하고싶을때 사용한다.





## 예외처리 방법

* 예외처리(decleare) throw

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

  try{
  	예외 발생 가능성 문장;
  	문장;
  }
  chatch(예외 클래스 타입 객체){//여러번 사용가능
  	예외 처리 문장;
  }
  finally{
  예외 발생과 무관하게 수행해야하는 문장;
  }

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

  구체적인 예외처리 관련 API의 예외의 속성과 메서드를 추가해서 만듭니다.

  사용자 정의 예외 클래스를 정의 할때 exception 을상속을 받아서 예외처리에 속성과 메서드를 추가해서 만듭니다.

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




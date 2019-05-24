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
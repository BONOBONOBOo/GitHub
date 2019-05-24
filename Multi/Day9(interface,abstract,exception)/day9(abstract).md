# Abstract란?

* 구현할 메서드를 지정해놓은것
* 상속을 통해서 구현 해야함



### abstract class 의 특징

* new사용해서 객체 생성이 불가능하다.
* 추상메서드가 정의되어있지 않아도 추상 클래스로 구현할 수 있습니다.

```java
abstract public class Processor {
	public String name() {
		return "Processor";	
	}
	abstract Object process(Object input);
}
```


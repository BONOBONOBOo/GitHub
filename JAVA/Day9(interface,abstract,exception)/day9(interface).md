## 인터페이스란?

- 사용자와 제공자의 연결
- 관리자가 서로 다른 개발자에게 같은 메서드의 구현을 원할때 획일화된 형식을 제공해주는것 

### 인터페이스의 구성요소

- public static final 상수속성 abstract 메서드 
- static method :
- default method : 인터페이스를 수정 할 때 인터페이스를 임플리먼트 받은 객체의 수정을 번거롭지 않게 하기위함

```
클래스 -> 일원화된 구조 -> 선언과 구현이 함께 이루어 져야함
인터페이스 -> 이원화된 구조 -> 선언과 구현이 개별로 이루어짐
```

**인터페이스와 인터페이스의 상속은 다중 상속이 가능하고 _extends_ 로 구현한다. **

#### 인터페이스의 특징

* 인터페이스는 reference변수 생성자 타입으로 선언 가능하다.

  * ```
    Interface[] interface = new Interface[NUM];
    ```

* 인터페이스는 new키워드를 이용한 객체를 생성하려면 구현한 클래스로 객체 생성 가능 => 다형성 객체

  * ```
    Interface interface[] = new Interface[3];
    		
    		interface[0] = new Piano();
    		interface[1] = new Flute();
    		interface[2] = new Drum();
    ```

* interface의 구현 클래스들은 인자로 전달한경우 자동으로 upcasting이 되고 생성자클래스의 method가 필요한 경우 downcasting을 해서 사용할 수 있다.

  * ```java
    			Instrument.java
    
    interface Interface {
    	public void playStart();
    	
    }
    public class Strat implements Interface{
    	
    	@Override
    	public void playStart() {
    		System.out.printf("%s 시작\n",this.toString());	
    	}
    	public String toString() {
    		return "건반악기";
    	}
    }
    			Action.java
    public class Action extends Start{
    	
    	@Override
    	public String toString() {
    		return super.toString()+":"+"행동";
    	}
    }
    			MusicTest.java
    			
    public class InterfaceTest {
    	public static void main(String[] args) {
    		Interface interface[] = new Action();
    		Start(interface);
    	
    	}
    	public static void Start(Instrument interface) { # 업캐스팅
    		System.out.println("=====연주 시작=====");
    		interface.playStart();
    		System.out.print(((Action)interface).toString());
    	}
    }
    ```








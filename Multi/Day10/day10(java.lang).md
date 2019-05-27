# Java.lang package

### Object Class

 * .clone()
   	* 깊은 복사

``` java
package day10;

public class cloneTest {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		//int[] arrcl = arr;
        /*
        얕은 복사 
        객체의 레퍼런스를 복사하기 때문에 복사 할 대상의 정보를 바꾸면 복사 된 객체에서도 변경된다.
        */
		int[] arrcl = arr.clone();
        /*
        깊은 복사 
        객체의 레퍼런스가 아닌 값을 복사하기 때문에 복사 할 대상의 정보를 바꾸면 복사 된 객체에서는 변		  경되지 않는다.
        */
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		
		System.out.println();
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arrcl[i]+" ");
		
		System.out.println();
		System.out.println();
		
		arr[0] = 9;
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		
		System.out.println();
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arrcl[i]+" ");
        
        /*
        얕은복사
        1 2 3 4 5 
        1 2 3 4 5 

        9 2 3 4 5 
        9 2 3 4 5 
        */
        
        
        /* 
        깊은복사
        1 2 3 4 5 
        1 2 3 4 5 

        9 2 3 4 5 
        1 2 3 4 5 
        */
	}

}

```

* equals()
  * 객체의 레퍼런스와 속성으 값이 같은지 확인하는것
* hashCode()
  * 같은 값을 갖고있는 hash코드가 있을수는 있지만 Object의 hashcode는 주소값을 기반으로 하기때문에
  * 같은 identityhashcode를 가질 수 없다.
  * 데이터의 균등한 분포를 할 수 있다.

* toString()
  * 원래는 객체의 hash값을 받지만 오버라이드해서 사용자가 원하는 정보를 받을 수 있다.

---

### String Class

* equals()
  * 문자열 자체를 비교한다.
* charAt()
  * 하나하나의 문자열을 인덱스로 얻어오기
* join()
  * 여러문자열 사이에 구분자를 넣고 결합

```java
String phone = "010,1234,5678";
String[] arr = phone.split(",");
String number = String.join("-",arr);

System.out.println("결과 : " + number);

// 결과 : 010-1234-5678
```

#### StringBuffer Class , StringBuilder Class

StringBuffer : String class를 편집하기 위해 만들어진 클래스

StringBuilder : StringBuffer에서 스레드 동기화 기능을 뺀 클래스




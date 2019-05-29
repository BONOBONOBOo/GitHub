Collection

Framework



#### 배열

​	생성시에 배열의 크기를 정적으로 줘야한다.

#### Collection

​	생성후 Collection의 크기가 유동적이다.





## Collection - List,Set

### List 

* 지정한 순서 보장,중복된 객체 저장

* ArrayList(싱글 스레드) , LinkedList ,  Vector(멀티스레드),Stack

* add(객체) -

  * 순차적으로 저장

* add(객체,index) 

  *  해당 인덱스에 객체를 저장

* remove(index) 

  * 해당 인덱스의 객체를 제거

* clear() 

  * 모든 객체를 제거

* size() 

  * 리스트의 크기

* contains() 

  * 해당 객체가 리스트 안에 들어있는지

* get((index)

  * 해당 인덱스를 리턴함

* Iterator<Book> - iterator()

  * 리스트에 저장 할 때 제네릭 타입을 확인 후 저장하는것 처럼 iterator도 꺼내올 때 제네릭 타입을 확인하고 가져온다.

  * ```
    Iterator<Book> iterator = new Iterator();
    	while(iterator.hashNext()){
    		Book b = iterator.next()
    }
    ```

  ###### LinkedList

* 데이터를 입출력 할 때 순서를 보장한다 하지만 불연속 적인 데이터를 저장 할 때 LinkedList는 필요없다.

#### Stack

* push(),pop()
  * 넣고 뺀다.
* peek()
  * 가장 위에있는데이터를 확인

#### Queue(FIFO)

### Set 

* 중복 객체 저장 불가,순서 보장 안됨

HashSet

TreeSet

### Map

* 1대1매칭
* 맵의 요소를 꺼내서 처리하는법
  * 키집합을 리턴받고 - keySet()
  * 키집합에 대한 lterator생성
  * iterator로 키를 꺼내서 map에저장된 value객체를 꺼냅니다.get(Key)
* entrySet()
  * key와 value를 둘다 리턴한다.

## Arrays

배열을 다루는데 유용한 메서드



##### copyOf(배열,인덱스) , copyOfRandge(배열,시작인덱스,끝인덱스)

* 배열의 복사

```
int arr1[] = {0,1,2,3,4,5};
int arr2[] = Arrays.copyOf(arr1,arr1.length);

//arr2 = 0,1,2,3,4,5
```

##### fill() , setAll()

* 배열 채우기

```
int arr = new int[5];
Arrays.fill(arr,9);
//arr = 9,9,9,9,9
```

##### sort()

* 배열의 정렬과 검색

```
int arr1[] = {0,1,2,3,4,5};
int idx = Array.binarySearch(arr1,2);
```



## Comparator ,Comparable



### 제네릭스

* 컴파일시 타입을 체크해주는 기능

### enums

```java
class Card{
	enum Kind {CLOVER,HEART,DIAMOND,SPADE}
	
	final Kind kind;
}
/*
	COVER = 0;
	HEART = 1;
	DIAMOND =2;
	SPADE = 3;
*/
```



### 에너테이션 annotation

* 실행하고 있는 프로세스에게 메타 데이터를 준다.
  * 메타데이터 : 데이터에의한 데이터
* 실행문장과 주석 사이에 있음




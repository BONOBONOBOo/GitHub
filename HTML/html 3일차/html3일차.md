#### 다이얼로그

​	마우스 올렸을때 나오는거



#### div 

​	페이지에서 영역 나오는거



#### embed

​	플래시 플러그인



#### fieldset

필수조건이랑 선택사항이랑 나눔



### figure

사진 넣기

figure caption

사진의 부가설명 보기



글꼴은css를 사용하기



#### I frame

​	페이지에 다른 사이트를 넣을때 사용



# link

```html
  <link rel="stylesheet" type="text/css"href="styles.css">

type가 stylesheet이면 생략하기도 한다.
```



Map

이미지안에 이미지 링크 넣기

```html
<!DOCTYPE html>
<html>
<body>

<p>Click on the sun or on one of the planets to watch it closer:</p>

<img src="planets.gif" width="145" height="126" alt="Planets" usemap="#planetmap">

<map name="planetmap">
  <area shape="rect" coords="0,0,82,126" alt="Sun" href="sun.htm">
  <area shape="circle" coords="90,58,3" alt="Mercury" href="mercur.htm">
  <area shape="circle" coords="124,58,8" alt="Venus" href="venus.htm">
</map>

    
</body>
</html>

```



Mark

형광펜 긋기

```html
<!DOCTYPE html>
<html>
<body>

<p>Do not forget to buy <mark>milk</mark> today.</p>

<p><strong>Note:</strong> The mark tag is not supported in Internet Explorer 8 and earlier versions.</p>

</body>
</html>
```



Meta

뷰포트를 사용하면 디바이스의 크기에따라 자연스러운 변환이 가능하다.

css에서 상세 설정을 한다.

```html
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```





---



text-shadow : textshadow로 사용 가능

```css
text-shadow : 2px 2px 10px gray

x,y축으로 2px,2px만큼 이동하고 10만큼의 크기의 gray shadow 넣는다.
```



동일한 태그라도 id,name,class로 구분할 수 있다.



<! 

* html에서 선언의 의미이다.

valudator 

* html문법 검사기
* 잘 작성 >> wellformed



link

```html
<link rel="stylesheet" href="day1CssPractice.css">
```



```html
body>div>p>span

div p span {/*공백으로 경로를 지정한다.*/


}
```

#

* id를 지정할때

.

* class를 지정할때





#### 박스모델

margin

* 컨텐츠 간의 거리

padding

* 경계선과 내부 컨텐츠 와의 거리

border

* 컨텐츠의 크기
* 경계선 스타일
  * solid
  * double
  * dotted
  * dasged
* 두께
* 색상





#### 레이아웃

인라인 요소 : 가로배치

* img
* span

블록 요소 : 세로 배치

* p
* div



### 속성 선택자

선택자[속성~=값]

* 속성 안의 값이 특정 값을 단어로 포함하는 태그를 선택합니다.

선택자[속성!=값]

* 속성 안의 값이 특정 값을 단어로 포함하는 태그를 선택합니다.

선택자[속성^=값]

* 속성 안의 값이 특정 값을 단어로 포함하는 태그를 선택합니다.

선택자[속성$=값]

* 속성 안의 값이 특정 값을 단어로 포함하는 태그를 선택합니다.

선택자[속성*=값]

* 속성 안의 값이 특정 값을 포함하는 태그를 선택합니다.





### location

```css
.box{
	width: 100px;
	height: 100px;
	position: absolute;
}
.box:nth-child(1){
	background-color: red;
	left:50px;
	top:50px;
	z-index: 3
	}
```

z-index

* 클수록 컴포넌트 상단에 위치한다.








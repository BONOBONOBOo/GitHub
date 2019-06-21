# JQUERY()

* JQuery는 js보다 코드가 간결해서 코드량을 1/3으로 줄여줍니다.

* 기본효과를 조합하면 멋진 효과를 만들수 있습니다.

JQuery(),$() -> 같은 의미



#### 색변경

```js
$(document).ready(function(){
	$("h3").css("color","blue");
});
```

* 체이닝을 이요한 색변경

```js
$(document).ready(function(){
	$("h3").css("color","blue").css("backgroundColor","yellow");
});
```





### 전체 속성 변경

```js
$(document).ready(function(){
		$(*).css("color","blue").css("backgroundColor","yellow");
	});
```

### 부분 속성 변경

```js
$(document).ready(function(){
		$("div,p").css("color","blue").css("backgroundColor","yellow");
	});
```



### #id를 이용한 속성 변경

```js
$(document).ready(function(){
		$("#simple").css("color","blue").css("backgroundColor","yellow");
	});
```



### .class를 이용한 속성 변경

```js
$(document).ready(function(){
		$(".todo").css("color","green").css("backgroundColor","yellow");
	});
```



### div dldyd





### 타임아웃

```js
$(document).ready(function(){
	//5초 후에 코드 실행.
	setTimeout(function(){
		var value = $('select > option:selected').val();
		alert(value);
	},5000);
});
```


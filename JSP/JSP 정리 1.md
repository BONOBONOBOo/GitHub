#Http 포로토콜은 접속시 생성된 상태 정보를 유지하지 않는 stateless프로토콜



#접속시 웹 컨테이너에서 생성한 JSESSION ID,로그인 정보,쇼핑키트에 저장된



1.url의 쿼리 스트링으로 추가

http://ip:port/웹컨텍스트/xxx.jsp?JSESSION=636447485938272636	

2.html 페이지에 <input type=hidden name="" value = "">form전송

3.

Cookie사용 - 클라이언트 브라우저 저장소에 저장

Cookie c = new Cooke(key,value);

HttpSeveletResponse.addCookie()로 응답(클라에게 전송)

HttpSeveletRequest.getCookies():Cookie[]클라이언트 요청으로부터 쿠키를

4.Session 사용 웹 컨테이너의 메모리에 저장(JAVA기반이므로 객체로 저장)

Session객체는 최초 요청시에 웹 컨테이너가 HttpSession 구ㅜ현 객체를 생성

요청시에 생성된 Session 객체를 받아오려면 HttpSeveletRequest.getSession()

SetAttribute(Key,value)

removeAttribute(key)

getAttribibute(Key)

웹 컨테이너가 생성한 HttpSession객체에 생성된 

JESSION에 반환된 ID를 받아오는 메서드 getId()

getLastAccessTime()

클라이언트가 요청을 하지 않아도 HttpSession을 웹 컨테이너의 메모리에 유지 시간 설정

SetMaxInactiveInterval(초)

웹 컨텍스트 전역으로 세션기간 설정은 web.xml에 다음 설정을 추가합니다.

<session-config>

​	<session-timeout>30</session-timeout>

<session-comfig>

세선에 저장된 상태정보를 삭제하고 세션 객체를 만료시키려면 invalidate()

#요청을 재지정  -  클라이언가 요청한 서블릿이나 jsp에서 응답을 하는대신요청을 다른 자원(JSP,SEVELET)에 전달

* request dispatcher방식

  * 동일한 웹 컨텍스트의 컴포넌트에게 요청을 전달

  * url주소 표현은 처음 요청한 sevelt이나 jsp

  * ```
    SeveletContext sc = request.getSevletContext()
    RequestDispatcher rd =sc.getRequestDisatcher("/요청 재지정 자원의 경로");
    request.setAttrbtue(key,value)
    rd.forward(request,response)
    ```

* request.redirect방식

  * 동일한 웹 컨텍스트의 컴포넌트에게 요청을 전달
  * 다른 웹 컨텍스트의 컴포넌트에게 전달 가능
  * 다른 웹 서버로 요청 재지정 가능
  * url주소 표현은 처음 요청한 sevelt이나 jsp또는 웹 서버의 주소

  ```
  / : 루트 컨텍스트 절대경로
  ./ : 현재 디렉토리 상대경로
  http://~ : url의 path형식
  
  response.sendRedirect("url의 path형식")
  최초 요청시 컨테이터가 생성한 새로운request와 response객체가 redirect된 자원으로 
  get방식으로 전달 가능하다.
  동일한 웹 서버내에 컨텍스트 또는 다른 웹 컨텍스트에 공유해야 할 정보를 전달하러면 HttpSession.serAttribute() 또는 SeveletContext.setAttibute(key,value)
  ```

  

## JSP

HTML또는 XML기반의 동적인 웹 컨텐츠를 개발하는 스크립트 응답되는 웹 페이지의 컨텐츠를 만들기 위해 사용

자바 코드 로직을 가능한한 포함하지 않고 태그 , el컨텐츠를 생성 권장



* JSP의 요소

  * 정적 지시자

    * <%@ page contentType="text/html;charset=ut-8"

      ​                   session

      ​					buffer

      ​					isThreadSafe

       					errorPage 

      ​									isErrorPage

      ​                     info

      ​                     language   / 언어

      ​					import 패키지

      ​					extends

      ​					isELIgnored

      ​						

    ```
    text/xml
    text/plain
    image/jpeg
    application/vmd.ms~
    ```

    * JSP페이지 내에 다른 JSP페이지를 포함
    * <%@ include file="" %>
      * 포함될 페이지에서 <html><head><body>태그를 제외하고 <body>의 내용들만 지정
    * <%@ taglib prefix="" uri="http://java.sun/com/jsp/jstl/~" %>
      * JSP페이지 내에 html이 아닌 태그를 만나면 태그에 매핑된 JAVA calss를 실행
      * JSTL을 사용하기 위한 선언 core,sql,xml
      * prefix는 c java xml font
        * c - 
          * <c:if ~
          * <c:foreach :foreach에 매핑된 JAVA 클래스가 있는데 이 결과를 리턴해준다.
        * java

    최초요청 -> 컨테이너가 변환된 서블릿 파일을 검색> 존재하지 않으면 서블릿 java파일 변환 -> 컴파일 -> 클래스를 메모리에 로딩 -> 서블릿 객체 생성->lifecycle 메서드 호출

    * 선언자      <%!   전역변수 or 메서드 정의   %> : 변환된 서블릿의 멤버
    * scriptlet  <%     자바 실행 문장 ; %>  : _jspService()메서드에 문장으로 포함
    * 출력         <%=   출력 내용  %> : 변수,연산식,값을 리턴하는 함수
    *  웹페이지에 출력할 내용 <% out.println(javascript) or ${} %> 사용



동적인 요청을 처리하는 JSP를 요청하면 응답을 처리하기위해서 JSP컨테이너가 서블리승로 변화하면서 내장 객체들을 생성해서 _jspSevice()로 전달

jsp에서는 내장객체를 new로 생성하지 않고 컨테이너가 정의해놓을 이름으로 사용한다.

내장객체

* request = javax.servelt.http.HttpServletRequest
* response = javax.servelt.http.HttpServletResponse
* session - javax.servelt.http.HttpSession
* application - javax.servelt.ServletContext
* out - javax.servelt.jsp.JSPWriter
* exception - java.lang.Throwable
* page - java.lang.Object
* config - javax.servelt.ServletConfig
* pageContext - javax.servlet.jsp.PageContext



내장객체들의 유효범위 - 컨테이너 메모리에 유지되는 범위

page - 요청된 JSP가 수행되는 동안에만 유지

request - 요청이 종료 될때까지

	* <jsp:include>
	* jsp:forward

session -  

application - 웹컨텍스트가 사라지기 전까지 

* 공통으로 가지는 메서드
  * getAttribute()
  * setAttribute()
  * removeAttribute()
  * getAttributeNames()



자주 사용하는 기능을 태그로 정의

표준 액션 태그 : <jsp:useBean ~~~

​								JSP스펙에 정의도니 기능, 모든 JSP컨테이너가 지우너하므로 항상

커스텀 액션 태그 : 개발자가 직접 태그 클래스 , tld파일을 정의해서



EL(expression Language) : 표현 언어, JSP2.0에서 추가

<c:out ...> 또는 <jsp:getProperty...>보다 간결하게 사용가능

page,session,requestapplication에 저장된 객체를 간결하게 표현함



표준 액션태그

* <jsp:useBean ~>
* <jsp:setProperty>
* <jsp:getProperry>
* 
































<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta  charset="utf-8">
    <title>login</title>     
  </head>
  <link href="mystyle.css" rel="stylesheet" type="text/css">
  <body>
    <table border="1">
      <tr><td colspan="2" align="center"><font size=15><b>로그인</b></font></td></tr>
      <tr>
         <td><form action="login.do" method='post'>
               <div id="confirmed">
                 <table>
                    <tr>
                      <td>아이디</td>
                      <td><input type="text" name="userid" size="15" maxlength="12"/></td>
                    </tr>
                    <tr>
                      <td>비밀번호</td>
                      <td><input type="password" name="userpwd" size="15" maxlength="12"/></td>
                    </tr>
                    <tr><td colspan="2" align="center">
                        <input type="submit" id="login" value="로그인" /></td>
                    </tr>
                </table>
              </div>
             </form>
         </td>
    </table>
  </body>
</html>
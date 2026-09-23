<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World! Codegym" %></h1>
<br/>
<a href="/sum?num1=11&num2=22">Sum</a>
<form action = "/tinh-tong" method ="get">
 <input name = "num1"/>
 <input name = "num2"/>
 <button>Tính Tổng</button>
</form>
</body>
</html>
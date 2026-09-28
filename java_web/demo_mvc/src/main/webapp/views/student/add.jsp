<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 9/28/2026
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student?action=add" method="post">
    <h2>Add new student</h2>
    Id: <input name="id"><br>
    Name: <input name="name">
    Gender: <input type="radio" name="gender" value="true">Male
     <input type="radio" name="gender" value="false">Female<br>
    Score : <input name="score" type="number"><br>
    <button>Save</button>
</form>
</body>
</html>

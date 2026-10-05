<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student?action=add" method="post">
    <h2>Add new student</h2>
    Name: <input name="name"><br>
    Gender: <input type="radio" name="gender" value="true">Male
     <input type="radio" name="gender" value="false">Female<br>
    Score : <input name="score" type="number"><br>
    <select name="classId">
        <option>--------Chon lợp-------</option>
         <c:forEach var="cls" items="${classList}">
             <option value="${cls.id}">${cls.name}</option>
         </c:forEach>
    </select>
    <button>Save</button>
</form>
</body>
</html>

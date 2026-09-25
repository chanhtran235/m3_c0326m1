<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
    <c:import url="../library/library.jsp"/>
  </head>
  <body>
  <c:import url="../layout/header.jsp"/>
   <h1>Danh sách sinh viên</h1>
  <table class="table table-dark">
    <tr>
      <th>STT</th>
      <th>ID</th>
      <th>Name</th>
      <th>Gender</th>
      <th>Score</th>
      <th>Rank</th>
    </tr>
    <c:forEach var="student" varStatus="status" items="${studentList}">
      <tr>
        <td>${status.count}</td>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>
          <c:if test="${student.gender}">
            Nam
          </c:if>
          <c:if test="${!student.gender}">
            Nữ
          </c:if>
        </td>
        <td>${student.score}</td>
        <td>
          <c:choose>
            <c:when test="${student.score>=8}">
              Giỏi
            </c:when>
            <c:when test="${student.score>=7}">
              Khá
            </c:when>
            <c:when test="${student.score>=5}">
              Trung bình
            </c:when>
            <c:otherwise>
              Yếu
            </c:otherwise>
          </c:choose>
        </td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>

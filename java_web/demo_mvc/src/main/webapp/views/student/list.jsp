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
  <p class="text-danger">${param.mess}</p>
  <a class="btn btn-primary btn-sm" href="/student?action=add">Thêm mới</a>
  <table class="table table-dark">
    <tr>
      <th>STT</th>
      <th>ID</th>
      <th>Name</th>
      <th>Gender</th>
      <th>Score</th>
      <th>Rank</th>
      <th>Delete</th>
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
        <td>
          <button onclick="getInfoDelete(`${student.id}`,'${student.name}')" type="button" class="btn btn-sm btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
            Delete
          </button>
        </td>
      </tr>
    </c:forEach>
  </table>
  <!-- Modal -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <form action="/student?action=delete" method="post">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <input hidden="hidden" name="deleteId" id="deleteId">
            <span>Bạn có muốn xoá sinh viên </span><span id="deleteName"></span>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="submit" class="btn btn-primary">Delete</button>
          </div>
        </div>
      </form>

    </div>
  </div>
  <script>
    function getInfoDelete(id,name){
        document.getElementById("deleteName").innerHTML=name;
        document.getElementById("deleteId").value=id;
    }
  </script>
  </body>
</html>

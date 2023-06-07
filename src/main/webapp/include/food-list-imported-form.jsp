<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 07/06/2023
  Time: 4:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<nav class="nav nav-pills nav-justified">
  <a class="nav-item nav-link " href="updatefood?foodID=${productId}">Thông tin chung</a>
  <a class="nav-item nav-link " href="food-import?productId=${productId}">Nhập hàng</a>
  <a class="nav-item nav-link active" href="#">Xem danh sách nhập</a>
  <a class="nav-item nav-link " href="food-image-manager?productId=${productId}">Quản lí hình ảnh</a>
</nav>
<div class="container mt-3">
  <h2>Quản lí danh sách nhập hàng của thức ăn ${productId}</h2>
  <p>Nhân viên có thể xem được danh sách nhập hàng ở đây</p>
  <input class="form-control" id="myInput" type="text" placeholder="Tìm kiếm">
  <br>
  <table class="table table-bordered">
    <thead>
    <tr>
      <th>ID thức ăn</th>
      <th>Tên lô hàng</th>
      <th>Số lượng</th>
      <th>Ngày nhập</th>

    </tr>
    </thead>
    <tbody id="myTable">

    <c:forEach var="importedFood" items="${listImportedFood}">
      <tr>
        <td>${importedFood.foodID}</td>
        <td>${importedFood.importName}</td>
        <td>${importedFood.importAmount}</td>
        <td>${importedFood.importDate}</td>

      </tr>

    </c:forEach>

    </tbody>
  </table>


</div>

<script>
  $(document).ready(function () {
    $("#myInput").on("keyup", function () {
      var value = $(this).val().toLowerCase();
      $("#myTable tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
      });
    });
  });
</script>




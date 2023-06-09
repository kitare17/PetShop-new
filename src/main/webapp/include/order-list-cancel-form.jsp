<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<nav class="nav nav-pills nav-justified">
  <a class="nav-item nav-link " href="order-list-manager">Đơn hàng đang chờ</a>
  <a class="nav-item nav-link" href="list-order-accepted">Đơn hàng đã xác nhận</a>
  <a class="nav-item nav-link active" href="#">Đơn hàng đã hủy</a>

</nav>
<div class="container mt-3">
  <h2>Quản lí danh sách đặt hàng bị hủy</h2>
  <p>Nhân viên có thể xem được danh sách đặt hàng bị hủy ở đây</p>
  <input class="form-control" id="myInput" type="text" placeholder="Tìm kiếm">
  <br>
  <table class="table table-bordered">
    <thead>
    <tr>
      <th>Mã số đơn hàng</th>
      <th>Người duyệt đơn</th>
      <th>ID khách hàng</th>
      <th>Địa chỉ</th>
      <th>Ngày đặt</th>
      <th>Mã giảm giá</th>
      <th>Trạng thái</th>

    </tr>
    </thead>
    <tbody id="myTable">

    <c:forEach var="order" items="${listOrder}">
      <tr>
        <td>${order.idOrder}</td>
        <td>${order.employeeID}</td>
        <td>${order.username}</td>
        <td>${order.address}</td>
        <td>${order.date}</td>
        <td>${order.discountId}</td>
        <td>${order.orderStatus}</td>


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



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<nav class="nav nav-pills nav-justified">
  <a class="nav-item nav-link " href="order-list-manager">Đơn hàng đang chờ</a>
  <a class="nav-item nav-link " href="list-order-accepted">Đơn hàng đã xác nhận</a>
  <a class="nav-item nav-link active" href="#">Đơn hàng đã thanh toán</a>
  <a class="nav-item nav-link  " href="list-order-cancel">Đơn hàng đã hủy</a>

</nav>
<style>
  #pagination {
    margin-top: 10px;
  }

  .paging-button {
    display: inline-block;
    padding: 5px 10px;
    border: 1px solid #ccc;
    background-color: #f7f7f7;
    cursor: pointer;
    text-decoration: none;
  }

  .paging-button.active {
    background-color: #ccc;
  }

</style>
<div class="container mt-3">
  <h2>Quản lí danh sách đơn đã thanh toán</h2>
  <p>Nhân viên có thể xem được danh sách đơn đã thanh toán ở đây</p>
  <input class="form-control" id="myInput" type="text" placeholder="Tìm kiếm">
  <br>
  <table class="table table-bordered" id="data-table">
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
        <td><a href="getordereddetailemp?orderId=${order.idOrder}">${order.idOrder}</a></td>
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
<div id="pagination" class="text-center"></div>
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
<script>
  var currentPage = 1;
  var recordsPerPage = 10;
  var table = document.getElementById("data-table");
  var rows = table.getElementsByTagName("tr");
  var totalPage = Math.ceil(rows.length / recordsPerPage);

  function showTable(page) {
    var start = (page - 1) * recordsPerPage;
    var end = start + recordsPerPage;

    for (var i = 0; i < rows.length; i++) {
      if (i >= start && i < end) {
        rows[i].style.display = "table-row";
      } else {
        rows[i].style.display = "none";
      }
    }
  }

  function createPagination() {
    var pagination = document.getElementById("pagination");
    pagination.innerHTML = "";

    for (var i = 1; i <= totalPage; i++) {
      var button = document.createElement("a");
      button.href = "#";
      button.innerHTML = i;

      if (i === currentPage) {
        button.classList.add("paging-button", "active");
      } else {
        button.classList.add("paging-button");
      }

      button.addEventListener("click", function () {
        currentPage = parseInt(this.innerHTML);
        showTable(currentPage);

        var currentButton = document.querySelector(".paging-button.active");
        currentButton.classList.remove("active");

        this.classList.add("active");
      });

      pagination.appendChild(button);
    }
  }

  showTable(currentPage);
  createPagination();

</script>



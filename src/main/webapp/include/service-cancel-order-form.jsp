<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<nav class="nav nav-pills nav-justified">
    <a class="nav-item nav-link " href="getserviceorder">Đơn hàng đang chờ</a>
    <a class="nav-item nav-link" href="getserviceacceptedorder">Đơn hàng đã xác nhận</a>
    <a class="nav-item nav-link" href="getservicepaidorder">Đơn hàng đã thanh toán</a>
    <a class="nav-item nav-link active "href="#">Đơn hàng đã hủy</a>

</nav>
<div class="container mt-3">
    <h2>Quản lí danh sách đặt dịch vụ</h2>
    <p>Nhân viên có thể xem được danh sách đặt dịch vụ ở đây</p>
    <input class="form-control" id="myInput" type="text" placeholder="Tìm kiếm">
    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Mã số đơn dịch vụ</th>
            <th>ID khách hàng</th>
            <th>Ngày tạo đơn</th>
            <th>Mã dịch vụ</th>
            <th>Mã ca</th>
            <th>Ngày đặt</th>
            <th>Số lượng thú cưng</th>>
            <th>Trạng thái</th>

        </tr>
        </thead>
        <tbody id="myTable">

        <c:forEach var="order" items="${listServiceOrder}">
            <tr>
                <td>${order.billID}</td>
                <td>${order.customerID}</td>
                <td>${order.dateCreate}</td>
                <td>${order.serviceID}</td>
                <td>${order.shiftID}</td>
                <td>${order.day}</td>
                <td>${order.amount}</td>
                <td>${order.status==3?"Đã hủy":""}</td>


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



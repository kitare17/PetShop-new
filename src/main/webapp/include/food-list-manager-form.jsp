<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<nav class="nav nav-pills nav-justified">
    <a class="nav-item nav-link " href="food-add.jsp">Thêm thức ăn</a>
    <a class="nav-item nav-link" href="pet-add.jsp">Thêm thú cưng</a>
    <a class="nav-item nav-link active " href="#">Danh sách thức ăn</a>
    <a class="nav-item nav-link  " href="pet-list-manager">Danh sách thú cưng</a>
</nav>
<div class="container mt-3">
    <h2>Quản lí danh sách thức ăn</h2>
    <p>Nhân viên có thể xem được danh sách thú cưng ở đây</p>
    <input class="form-control" id="myInput" type="text" placeholder="Tìm kiếm">
    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>FoodID</th>
            <th>Tên thức ăn</th>
            <th>Loại</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Trạng thái</th>
            <th>Ảnh</th>
            <th></th>
        </tr>
        </thead>
        <tbody id="myTable">

        <c:forEach var="food" items="${listFood}">
            <tr>
                <td>${food.productId}</td>
                <td>${food.productName}</td>
                <td>${food.productType}</td>
                <td>${food.getPriceString()}</td>
                <td>${food.productAmount}</td>
                <td>${food.status}</td>
                <td><img style="width: 100%" src="${food.listImg.get(0).url}" alt="${food.productId}"></td>
                <td> <a class="btn btn-success " href="updatefood?foodID=${food.productId}">Cập nhật</a> </td>
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



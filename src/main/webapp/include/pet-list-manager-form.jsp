<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<nav class="nav nav-pills nav-justified">
    <a class="nav-item nav-link " href="food-add.jsp">Thêm thức ăn</a>
    <a class="nav-item nav-link" href="pet-add.jsp">Thêm thú cưng</a>
    <a class="nav-item nav-link " href="food-list-manager">Danh sách thức ăn</a>
    <a class="nav-item nav-link active " href="#">Danh sách thú cưng</a>
</nav>
<div class="container mt-3">
    <h2>Quản lí danh sách thú cưng</h2>
    <p>Nhân viên có thể xem được danh sách thức ăn ở đây</p>
    <input class="form-control" id="myInput" type="text" placeholder="Tìm kiếm">
    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>PetID</th>
            <th>Tên thú cưng</th>
            <th>Loại</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Trạng thái</th>
            <th>Ảnh</th>
            <th></th>
        </tr>
        </thead>
        <tbody id="myTable">

        <c:forEach var="pet" items="${listPet}">
            <tr>
                <td>${pet.productId}</td>
                <td>${pet.productName}</td>
                <td>${pet.productType}</td>
                <td>${pet.getPriceString()}</td>
                <td>${pet.productAmount}</td>
                <td>${pet.status}</td>
                <td><img style="width: 100%" src="${pet.listImg.get(0).url}" alt="${pet.productId}"></td>
                <td> <a class="btn btn-success " href="updatepet?petID=${pet.productId}">Cập nhật</a> </td>
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



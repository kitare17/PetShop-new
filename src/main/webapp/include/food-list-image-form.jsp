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
    <a class="nav-item nav-link " href="food-list-import?productId=${productId}">Xem danh sách nhập</a>
    <a class="nav-item nav-link active " href="food-image-manager?productId=${productId}">Quản lí hình ảnh</a>
</nav>


<div class="container">

    <div class="row ">
        <form class="needs-validation mt-3" novalidate action="food-add-image" method="post">

            <div class="row">
                <div class="col-12" style="background-color:#7ab730;border-radius: 10px ">
                    <h2>Thêm hình ảnh mới </h2>
                </div>
                <%--input id thức ăn --%>
                <div class="col-md-6 offset-3 mb-3 mt-3">
                    <label for="foodID">ID thức ăn <strong>${productId}</strong> </label>
                    <div class="input-group">
                        <input type="hidden" class="form-control" id="foodID" placeholder="Id thức ăn" name="productId"
                               aria-describedby="inputGroupPrepend" value="${productId}" required>
                        <div class="invalid-feedback">
                            Username bắt đầu bằng chữ cái và từ 8 đến 20 kí tự không chứa kí tự đặc biệt
                        </div>
                    </div>
                </div>
                <%--input url--%>
                <div class="col-md-6 offset-3 mb-3 mt-3">
                    <label for="urlImage">Url ảnh</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="urlImage" placeholder="Nhập url ảnh"
                               name="urlImage"
                               aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Username bắt đầu bằng chữ cái và từ 8 đến 20 kí tự không chứa kí tự đặc biệt
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="col-3 offset-3">
                        <button class="btn btn-primary" type="submit">Thêm hình ảnh</button>
                    </div>
                    <div class="col-6">${thongbao} </div>
                </div>
            </div>
        </form>


    </div>
</div>


<!-- Contact End -->

<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict';
        window.addEventListener('load', function () {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>


<div class="container mt-3">
    <h2>Quản lí danh sách hình ảnh của thức ăn ${productId}</h2>
    <p>Nhân viên có thể xem được danh sách hình ảnh ở đây</p>
    <input class="form-control" id="myInput" type="text" placeholder="Tìm kiếm">
    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID thức ăn</th>
            <th>Ảnh</th>
            <th></th>

        </tr>
        </thead>
        <tbody id="myTable">

        <c:forEach var="img" items="${listImage}">
            <tr>
                <td>${img.id}</td>
                <td><img src="${img.url}" style="width: 100%" alt="${img.url}"></td>
                <td><a class="btn btn-danger" href="remove-food?productId=${img.id}&urlImage=${img.url}" >Xóa</a></td>
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




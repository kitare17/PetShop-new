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
    <a class="nav-item nav-link active " href="#">Tạo mã giảm giá</a>
    <a class="nav-item nav-link " href="listdiscount">Danh sách mã giảm giá</a>

</nav>


<div class="container">

    <div class="row ">
        <form class="needs-validation mt-3" novalidate action="creatediscount" method="get">

            <div class="row">
                <div class="col-12" style="background-color:#7ab730;border-radius: 10px ">
                    <h2>Thêm mã mới </h2>
                </div>

                <%--input url--%>
                <div class="col-md-6 offset-3 mb-3 mt-3">
                    <label for="preferentialName">Tên mã giảm giá</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="preferentialName" placeholder="Nhập tên mã giảm"
                               name="preferentialName" pattern="^.{1,50}$"
                               aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Trường này là bắt buộc và nhập tối đa 50 kí tụ
                        </div>
                    </div>
                </div>



                <%--input url--%>
                <div class="col-md-6 offset-3 mb-3 mt-3">
                    <label for="startDay">Ngày bắt đầu</label>
                    <div class="input-group">
                        <input type="date" class="form-control" id="startDay"
                               name="startDay"
                               aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Trường này là bắt buộc
                        </div>
                    </div>
                </div>
                <div class="col-md-6 offset-3 mb-3 mt-3">
                    <label for="endDay">Ngày kết thúc</label>
                    <div class="input-group">
                        <input type="date" class="form-control" id="endDay"
                               name="endDay"
                               aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Trường này là bắt buộc
                        </div>
                    </div>
                </div>
                <div class="col-md-6 offset-3 mb-3 mt-3">
                    <label for="rate">Tỷ lệ giảm</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="rate"
                               name="rate" max="100" min="1"
                               aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Trường này là bắt buộc, tối thiểu 1 ,tối đa 100
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-3 offset-3">
                        <button class="btn btn-primary" type="submit">Thêm mã</button>
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
        document.addEventListener('DOMContentLoaded', function() {
        var startDayInput = document.getElementById('startDay');
        var endDayInput = document.getElementById('endDay');
        var form = document.querySelector('form');

        form.addEventListener('submit', function(event) {
        var startDay = new Date(startDayInput.value);
        var endDay = new Date(endDayInput.value);

        if (startDay > endDay) {
        event.preventDefault(); //ặn việc gửi form

        alert('Ngày bắt đầu phải nhỏ hơn ngày kết thúc');
    }
    });
    });
</script>



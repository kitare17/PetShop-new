<%@page contentType="text/html" pageEncoding="UTF-8" %>

<nav class="nav nav-pills nav-justified">
    <a class="nav-item nav-link active" href="#">Thêm thức ăn</a>
    <a class="nav-item nav-link " href="pet-add.jsp">Thêm thú cưng</a>
    <a class="nav-item nav-link  " href="food-list-manager">Danh sách thức ăn</a>
    <a class="nav-item nav-link  " href="pet-list-manager">Danh sách thú cưng</a>
</nav>

<div class="container">

    <div class="row ">
        <form class="needs-validation mt-3" novalidate action="addfood" method="post">

            <div class="row">
                <div class="col-12" style="background-color:#7ab730;border-radius: 10px ">
                    <h2>Thêm thức ăn mới</h2>
                </div>


                <%--input ten food--%>
                <div class="col-md-6 offset-3 mb-3 mt-3">
                    <label for="foodName">Tên thức ăn</label>
                    <div class="input-group">
                        <input pattern="^.{1,50}$" type="text" class="form-control" id="foodName" placeholder="Tên thức ăn" name="foodName"
                               aria-describedby="inputGroupPrepend"  required>
                        <div class="invalid-feedback">
                            Tối đa từ 1-50 ký tự
                        </div>
                    </div>
                </div>


                <%--input giá food--%>
                <div class="col-md-6 offset-3 mb-3">
                    <label for="foodPrice">Giá thức ăn</label>
                    <div class="input-group">
                        <input type="text" pattern="^(?:\d+|\d*\.\d+)$" class="form-control" id="foodPrice" placeholder="Giá thức ăn" name="foodPrice"
                               aria-describedby="inputGroupPrepend"  required>
                        <div class="invalid-feedback">
                            Giá tiền chỉ bao gồm chữ số
                        </div>
                    </div>
                </div>
                <%--input loại Food--%>
                <div class="col-md-6 offset-3 mb-3">
                    <label for="foodType" class="form-label">Chọn loại thức ăn</label>
                    <select class="form-select" id="foodType" name="foodType">
                        <option value="dogFood">Cho chó</option>
                        <option value="catFood">Cho mèo</option>
                    </select>
                </div>
                <%--input xuất xứ food--%>
                <div class="col-md-6 offset-3 mb-3">
                    <label for="foodOrigin">Xuất xứ</label>
                    <div class="input-group">
                        <input type="text" pattern="^.{1,30}$" class="form-control" id="foodOrigin" placeholder="Xuất xứ" name="foodOrigin"
                               aria-describedby="inputGroupPrepend"  required>
                        <div class="invalid-feedback">
                            Trường này là bắt buộc, độ dài tối đa 30 ký tự
                        </div>
                    </div>
                </div>
                <div class="col-md-6 offset-3 mb-3">
                    <label for="foodUrlImg">Đường dẫn ảnh</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="foodUrlImg" placeholder="URL" name="foodUrlImg"
                               aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                             chưa sửa ?
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-3 offset-3">
                        <button class="btn btn-primary" type="submit">Thêm</button>
                    </div>
                    <div class="col-6">${thongbao}  </div>
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
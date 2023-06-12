<%@page contentType="text/html" pageEncoding="UTF-8" %>

<nav class="nav nav-pills nav-justified">
    <a class="nav-item nav-link " href="food-add.jsp">Thêm thức ăn</a>
    <a class="nav-item nav-link active" href="#">Thêm thú cưng</a>
    <a class="nav-item nav-link  " href="food-list-manager">Danh sách thức ăn</a>
    <a class="nav-item nav-link  " href="pet-list-manager">Danh sách thú cưng</a>
</nav>

<div class="container">

    <div class="row ">
        <form class="needs-validation mt-3" novalidate action="addpet" method="post">

            <div class="row">
                <div class="col-12" style="background-color:#7ab730;border-radius: 10px ">
                    <h2>Thêm một thú cưng mới</h2>
                </div>


                <%--input ten pet--%>
                <div class="col-md-6 offset-3 mb-3 mt-3">
                    <label for="petName">Tên thú cưng</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="petName" placeholder="Tên thú cưng" name="petName"
                               aria-describedby="inputGroupPrepend" pattern="^[a-zA-Z][a-zA-Z0-9]{7,20}$" required>
                        <div class="invalid-feedback">
                            Tối đa 1-50 ký tự
                        </div>
                    </div>
                </div>


                <%--input giá pet--%>
                <div class="col-md-6 offset-3 mb-3">
                    <label for="petPrice">Giá thú cưng</label>
                    <div class="input-group">
                        <input  pattern="^(?:\d+|\d*\.\d+)$" type="number" class="form-control" id="petPrice" placeholder="Giá thú cưng" name="petPrice"
                               aria-describedby="inputGroupPrepend"  required>
                        <div class="invalid-feedback">
                            Giá tiền chỉ bao gồm chữ số
                        </div>
                    </div>
                </div>
                <%--input loại pet--%>
                <div class="col-md-6 offset-3 mb-3">
                    <label for="petType" class="form-label">Chọn loại thú cưng</label>
                    <select class="form-select" id="petType" name="petType">
                        <option value="dog">Chó</option>
                        <option value="cat">Mèo</option>
                    </select>
                </div>
                <div class="col-md-6 offset-3 mb-3">
                    <label for="petUrlImg">Đường dẫn ảnh</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="petUrlImg" placeholder="URL" name="petUrlImg"
                               aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Trường này là bắt buộc
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
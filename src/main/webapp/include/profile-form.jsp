<%@page contentType="text/html" pageEncoding="UTF-8" %>


<div class="container mt-3">
    <form class="needs-validation" novalidate action="changepass" method="post">

        <div class="row">
            <div class="col-12" style="background-color:#7ab730;border-radius: 10px ">
                <h2>Đổi mật khẩu</h2>
            </div>
            <%--input old password--%>
            <div class="col-md-6 offset-3 mb-3">
                <label for="old-password">Mật khẩu</label>
                <div class="input-group">
                    <input type="password" class="form-control" id="old-password" placeholder="Mật khẩu cũ" name="oldPassword"
                           aria-describedby="inputGroupPrepend" pattern="^[a-zA-Z0-9]{7,32}$" required>
                    <div class="invalid-feedback">
                        Mật khẩu chứa số hoặc chữ cái độ dài từ 7 đến 32 kí tự
                    </div>
                </div>
            </div>

            <%--input password--%>
            <div class="col-md-6 offset-3 mb-3">
                <label for="password">Mật khẩu</label>
                <div class="input-group">
                    <input type="password" class="form-control" id="password" placeholder="Mật khẩu" name="password"
                           aria-describedby="inputGroupPrepend" pattern="^[a-zA-Z0-9]{7,32}$" required>
                    <div class="invalid-feedback">
                        Mật khẩu chứa số hoặc chữ cái độ dài từ 7 đến 32 kí tự
                    </div>
                </div>
            </div>

            <%--input re-password--%>
            <div class="col-md-6 offset-3 mb-3">
                <label for="re-password">Nhập mật khẩu</label>
                <div class="input-group">
                    <input type="password" class="form-control" id="re-password" placeholder="Nhập lại mật khẩu"
                           name="re-password"
                           aria-describedby="inputGroupPrepend" pattern="^[a-zA-Z0-9]{7,32}$" required>
                    <div class="invalid-feedback">
                        Mật khẩu không trùng nhau
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-3 offset-3">
                    <button class="btn btn-primary" type="submit">Cập nhật</button>
                    <pc style="color: green">${thongbao2}</pc>
                </div>

            </div>

    </form>
</div>

<div class="container mt-3">
    <form class="needs-validation" novalidate action="updateprofile" method="post">

        <div class="row">
            <div class="col-12" style="background-color:#7ab730;border-radius: 10px ">
                <h2>Thông tin cá nhân của bạn</h2>
            </div>
            <%--input fistname--%>
            <div class="col-md-6 offset-3 mb-3">
                <label for="firstname">Họ</label>
                <div class="input-group">
                    <input type="text" class="form-control" id="firstname" placeholder="Họ" name="firstname"
                           value="${firstname}"
                           aria-describedby="inputGroupPrepend" pattern="^[A-Za-z ]{1,50}$" required>
                    <div class="invalid-feedback">
                        Họ chứa từ 1 đến 50 kí tự
                    </div>
                </div>
            </div>
            <%-- input lastname--%>
            <div class="col-md-6 offset-3 mb-3">
                <label for="lastname">Lastname</label>
                <div class="input-group">
                    <input type="text" class="form-control" id="lastname" placeholder="Lastname" name="lastname"
                           value="${lastname}"
                           aria-describedby="inputGroupPrepend" pattern="^[A-Za-z ]{1,50}$" required>
                    <div class="invalid-feedback">
                        Tên chứa từ 1 đến 50 kí tự
                    </div>
                </div>
            </div>

            <%--        input address--%>
            <div class="col-md-6 offset-3 ol mb-3">
                <label for="address">Address</label>
                <div class="input-group">
                    <input type="text" class="form-control" id="address" placeholder="Address" name="address"
                           value="${address}"
                           aria-describedby="inputGroupPrepend" pattern="^[a-zA-Z0-9\s#-_,./()]{1,100}$" required>
                    <div class="invalid-feedback">
                        Địa chỉ có độ dài 100 kí tự
                    </div>
                </div>
            </div>

            <%--        input phone--%>
            <div class="col-md-6 offset-3 mb-3">
                <label for="address">Phone</label>
                <div class="input-group">
                    <input type="text" class="form-control" id="phone" placeholder="Phone" name="phone" value="${phone}"
                           aria-describedby="inputGroupPrepend" pattern="^[0-9]{10}$" required>
                    <div class="invalid-feedback">
                        Số điện thoại có dộ dài 10 kí tự
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="col-3 offset-3">
                <button class="btn btn-primary" type="submit">Cập nhật</button>
                <pc style="color: green">${thongbao}</pc>
            </div>

        </div>

    </form>
</div>
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
    // Lấy đối tượng của 2 trường password
    const passwordField = document.getElementById("password");
    const rePasswordField = document.getElementById("re-password");

    // Thêm sự kiện khi thay đổi giá trị của trường re-password
    rePasswordField.addEventListener("input", function() {
        // Kiểm tra xem giá trị của 2 trường có giống nhau hay không
        if (passwordField.value !== rePasswordField.value) {
            // Nếu không giống nhau, hiển thị thông báo lỗi
            rePasswordField.setCustomValidity("Mật khẩu không khớp");
        } else {
            // Nếu giống nhau, xóa thông báo lỗi đi
            rePasswordField.setCustomValidity("");
        }
    });

    // Thêm sự kiện submit cho form
    document.querySelector("form").addEventListener("submit", function(event) {
        // Kiểm tra xem giá trị của 2 trường có giống nhau hay không
        if (passwordField.value !== rePasswordField.value) {
            // Nếu không giống nhau, ngăn chặn form được submit
            event.preventDefault();
        }
    });

</script>
<%-- 
    Document   : register-form
    Created on : Mar 6, 2023, 4:58:46 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!-- Contact Start -->
<div class="container-fluid pt-5">
    <div class="container">

        <div class="row g-5">
            <div class="col-lg-7">
                <h1>${message}</h1>

                <form class="needs-validation" novalidate action="register" method="post">

                    <div class="row">
                        <div class="col-12" style="background-color:#7ab730;border-radius: 10px ">
                            <h2>Đăng kí thành viên mới</h2>
                        </div>


                        <%--input username--%>
                        <div class="col-md-6 offset-3 mb-3">
                            <label for="username">Username<span class="text-danger">*</span></label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="username" placeholder="Username"
                                       name="username"
                                       aria-describedby="inputGroupPrepend" pattern="^[a-zA-Z][a-zA-Z0-9]{7,20}$"
                                       required>
                                <div class="invalid-feedback">
                                    Username bắt đầu bằng chữ cái và từ 8 đến 20 kí tự không chứa kí tự đặc biệt
                                </div>
                            </div>
                        </div>
                        <%--input password--%>
                        <div class="col-md-6 offset-3 mb-3">
                            <label for="password">Mật khẩu<span class="text-danger">*</span></label>
                            <div class="input-group">
                                <input type="password" class="form-control" id="password" placeholder="Mật khẩu"
                                       name="password"
                                       aria-describedby="inputGroupPrepend" pattern="^[a-zA-Z0-9]{7,32}$" required>
                                <div class="invalid-feedback">
                                    Mật khẩu chứa số hoặc chữ cái độ dài từ 7 đến 32 kí tự
                                </div>
                            </div>
                        </div>

                        <%--input re-password--%>
                        <div class="col-md-6 offset-3 mb-3">
                            <label for="re-password">Nhập mật khẩu<span class="text-danger">*</span></label>
                            <div class="input-group">
                                <input type="password" class="form-control" id="re-password"
                                       placeholder="Nhập lại mật khẩu" name="re-password"
                                       aria-describedby="inputGroupPrepend" pattern="^[a-zA-Z0-9]{7,32}$" required>
                                <div class="invalid-feedback">
                                    Mật khẩu không trùng nhau
                                </div>
                            </div>
                        </div>


                        <%--input fistname--%>
                        <div class="col-md-6 offset-3 mb-3">
                            <label for="firstname">Họ<span class="text-danger">*</span></label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="firstname" placeholder="Họ" name="firstname"
                                       aria-describedby="inputGroupPrepend" pattern="^[\p{Lu}\p{Ll}\sA-Za-záàảãạăắằẳẵặâấầẩẫậéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵ]{1,50}$" required>
                                <div class="invalid-feedback">
                                    Họ chứa từ 1 đến 50 kí tự
                                </div>
                            </div>
                        </div>
                        <%-- input lastname--%>
                        <div class="col-md-6 offset-3 mb-3">
                            <label for="lastname">Tên<span class="text-danger">*</span></label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="lastname" placeholder="Tên" name="lastname"
                                       aria-describedby="inputGroupPrepend" pattern="^[\p{Lu}\p{Ll}\sA-Za-záàảãạăắằẳẵặâấầẩẫậéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵ]{1,50}$" required>
                                <div class="invalid-feedback">
                                    Tên chứa từ 1 đến 50 kí tự
                                </div>
                            </div>
                        </div>

                        <%--        input address--%>
                        <div class="col-md-6 offset-3 ol mb-3">
                            <label for="address">Địa chỉ<span class="text-danger">*</span></label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="address" placeholder="Địa chỉ"
                                       name="address"
                                       aria-describedby="inputGroupPrepend" pattern="^.{1,100}$"
                                       required>
                                <div class="invalid-feedback">
                                    Địa chỉ có độ dài tối đa 100 kí tự
                                </div>
                            </div>
                        </div>

                        <%--        input phone--%>
                        <div class="col-md-6 offset-3 mb-3">
                            <label for="phone">Điện thoại<span class="text-danger">*</span></label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="phone" placeholder="Điện thoại" name="phone"
                                       aria-describedby="inputGroupPrepend" pattern="^[0-9]{10}$" required>
                                <div class="invalid-feedback">
                                    Số điện thoại có dộ dài 10 kí tự
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 offset-3 mb-3">
                            <label for="email">Email<span class="text-danger">*</span></label>
                            <div class="input-group">
                                <input type="email" class="form-control" id="email" placeholder="Email" name="email"
                                       aria-describedby="inputGroupPrepend"  required>
                                <div class="invalid-feedback">
                                    Địa chỉ email không hợp lệ
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-3 offset-3">
                            <button class="btn btn-primary" type="submit">Đăng kí</button>
                        </div>

                    </div>

                </form>
                <h3 class="text-danger">${thongbao}</h3>
            </div>
            <div class="col-lg-5">
                <div class="bg-light mb-5 p-5">
                    <div class="d-flex align-items-center mb-2">
                        <i class="bi bi-geo-alt fs-1 text-primary me-3"></i>
                        <div class="text-start">
                            <h6 class="text-uppercase mb-1">Our Office</h6>
                            <span>123 Street, Danang, VietNam</span>
                        </div>
                    </div>
                    <div class="d-flex align-items-center mb-2">
                        <i class="bi bi-envelope-open fs-1 text-primary me-3"></i>
                        <div class="text-start">
                            <h6 class="text-uppercase mb-1">Email Us</h6>
                            <span>info@fpt.edu.vn</span>
                        </div>
                    </div>
                    <div class="d-flex align-items-center mb-4">
                        <i class="bi bi-phone-vibrate fs-1 text-primary me-3"></i>
                        <div class="text-start">
                            <h6 class="text-uppercase mb-1">Call Us</h6>
                            <span>+012 345 6789</span>
                        </div>
                    </div>
                    <div>
                        <iframe class="position-relative w-100"
                                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3835.863822872289!2d108.25633498226848!3d15.968486316307787!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3142116949840599%3A0x365b35580f52e8d5!2zxJDhuqFpIGjhu41jIEZQVCAoRlBUIHVuaXZlcnNpdHkp!5e0!3m2!1sen!2s!4v1677941614321!5m2!1sen!2s"
                                frameborder="0" style="height: 205px; border:0;" allowfullscreen="" aria-hidden="false"
                                tabindex="0"></iframe>
                    </div>
                </div>
            </div>
        </div>
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
    // Lấy đối tượng của 2 trường password
    const passwordField = document.getElementById("password");
    const rePasswordField = document.getElementById("re-password");

    // Thêm sự kiện khi thay đổi giá trị của trường re-password
    rePasswordField.addEventListener("input", function () {
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
    document.querySelector("form").addEventListener("submit", function (event) {
        // Kiểm tra xem giá trị của 2 trường có giống nhau hay không
        if (passwordField.value !== rePasswordField.value) {
            // Nếu không giống nhau, ngăn chặn form được submit
            event.preventDefault();
        }
    });

</script>
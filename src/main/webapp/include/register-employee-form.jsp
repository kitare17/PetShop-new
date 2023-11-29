<%--
    Document   : register-form
    Created on : Mar 6, 2023, 4:58:46 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>


<nav class="nav nav-pills nav-justified">
  <a class="nav-item nav-link " href="manage-emp-account">Danh sách tài khoản nhân viên</a>
  <a class="nav-item nav-link active" href="#">Thêm tài khoản nhân viên</a>

</nav>
<!-- Contact Start -->
<div class="container-fluid pt-5">
  <div class="container">
    <div class="border-start border-5 border-primary ps-5 mb-5" style="max-width: 600px;">
      <h6 class="text-primary text-uppercase">Đăng kí tài khoản cho nhân viên mới</h6>
      <h1 class="display-5 text-uppercase mb-0">Đăng kí tài khoản</h1>
    </div>
    <div class="row g-5">
      <div class="col-12">
        <h1>${message}</h1>

        <form class="needs-validation" novalidate action="registeremp" method="post">

          <div class="row">
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
                       aria-describedby="inputGroupPrepend" pattern="^.{1,50}$" required>
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
                       aria-describedby="inputGroupPrepend" pattern="^.{1,50}$" required>
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
                  Địa chỉ có độ dài 100 kí tự
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

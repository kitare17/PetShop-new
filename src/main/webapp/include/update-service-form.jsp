<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 02/06/2023
  Time: 3:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="container mt-3">
  <form class="needs-validation" novalidate action="changepass" method="post">

    <div class="row">
      <div class="col-12" style="background-color:#7ab730;border-radius: 10px ">
        <h2>Cập nhật dịch vụ</h2>
      </div>
      <%--input Tên dịch vụ--%>
      <div class="col-md-6 offset-3 mb-3">
        <label for="sname">Tên dịch vụ</label>
        <div class="input-group">
          <input type="password" class="form-control" id="sname" placeholder="Tên dịch vụ mới" name="serviceName"
                 aria-describedby="inputGroupPrepend" pattern="^[a-zA-Z0-9]{7,32}$" required>
          <div class="invalid-feedback">
            Mật khẩu chứa số hoặc chữ cái độ dài từ 7 đến 32 kí tự
          </div>
        </div>
      </div>


      <%--input giá dịch vụ--%>
      <div class="col-md-6 offset-3 mb-3">
        <label for="serviceprice">Giá dịch vụ</label>
        <div class="input-group">
          <input type="number" class="form-control" id="serviceprice" placeholder="Giá dịch vụ mới"
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


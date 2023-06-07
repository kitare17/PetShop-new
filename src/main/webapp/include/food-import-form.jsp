<%@page contentType="text/html" pageEncoding="UTF-8" %>

<nav class="nav nav-pills nav-justified">
  <a class="nav-item nav-link " href="updatefood?foodID=${productId}">Thông tin chung</a>
  <a class="nav-item nav-link active" href="#">Nhập hàng</a>
  <a class="nav-item nav-link " href="food-list-import?productId=${productId}">Xem danh sách nhập</a>
  <a class="nav-item nav-link " href="food-image-manager?productId=${productId}">Quản lí hình ảnh</a>
</nav>

<div class="container">

  <div class="row ">
    <form class="needs-validation mt-3" novalidate action="food-import" method="post">

      <div class="row">
        <div class="col-12" style="background-color:#7ab730;border-radius: 10px ">
          <h2> Thêm lô hàng thức ăn mới </h2>
        </div>
        <%--input id thức ăn --%>
        <div class="col-md-6 offset-3 mb-3 mt-3">
          <label for="foodID">ID thức ăn <strong>${productId}</strong> </label>
          <div class="input-group">
            <input type="hidden" class="form-control" id="foodID" placeholder="Id thức ăn" name="productId"
                   aria-describedby="inputGroupPrepend"  value="${productId}" required>
            <div class="invalid-feedback">
              Username bắt đầu bằng chữ cái và từ 8 đến 20 kí tự không chứa kí tự đặc biệt
            </div>
          </div>
        </div>
        <%--input ten lô thức ăn--%>
        <div class="col-md-6 offset-3 mb-3 mt-3">
          <label for="importName">Tên lô hàng  </label>
          <div class="input-group">
            <input type="text" class="form-control" id="importName" placeholder="Tên lô thức ăn" name="importName"
                   aria-describedby="inputGroupPrepend"  required>
            <div class="invalid-feedback">
              Username bắt đầu bằng chữ cái và từ 8 đến 20 kí tự không chứa kí tự đặc biệt
            </div>
          </div>
        </div>

        <%--input số lượng thức ăn--%>
        <div class="col-md-6 offset-3 mb-3 mt-3">
          <label for="importAmount">Số lượng thức ăn  </label>
          <div class="input-group">
            <input type="number" class="form-control" id="importAmount" placeholder="Số lượng thức ăn" name="importAmount"
                   aria-describedby="inputGroupPrepend"  required>
            <div class="invalid-feedback">
              Username bắt đầu bằng chữ cái và từ 8 đến 20 kí tự không chứa kí tự đặc biệt
            </div>
          </div>
        </div>

        <%--input ngày nhập thức ăn--%>
        <div class="col-md-6 offset-3 mb-3 mt-3">
          <label for="importDate">Ngày nhập  </label>
          <div class="input-group">
            <input type="date" class="form-control" id="importDate" placeholder="Ngày nhập" name="importDate"
                   aria-describedby="inputGroupPrepend"  required>
            <div class="invalid-feedback">
              Username bắt đầu bằng chữ cái và từ 8 đến 20 kí tự không chứa kí tự đặc biệt
            </div>
          </div>
        </div>



        <div class="row">
          <div class="col-3 offset-3">
            <button class="btn btn-primary" type="submit">Nhập hàng</button>
          </div>
          <div class="col-6">${thongbao}  </div>
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
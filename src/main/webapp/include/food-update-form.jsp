<%@page contentType="text/html" pageEncoding="UTF-8" %>

<nav class="nav nav-pills nav-justified">
  <a class="nav-item nav-link active" href="#">Thông tin chung</a>
  <a class="nav-item nav-link " href="food-import?productId=${food.productId}">Nhập hàng</a>
  <a class="nav-item nav-link " href="food-list-import?productId=${food.productId}">Xem danh sách nhập</a>
  <a class="nav-item nav-link " href="food-image-manager?productId=${food.productId}">Quản lí hình ảnh</a>
</nav>

<div class="container">

  <div class="row ">
    <form class="needs-validation mt-3" novalidate action="updatefood" method="post">

      <div class="row">
        <div class="col-12" style="background-color:#7ab730;border-radius: 10px ">
          <h2>Cập nhật thức ăn </h2>
        </div>
          <%--input ten food--%>
          <div class="col-md-6 offset-3 mb-3 mt-3">
              <label for="foodID">ID thức ăn <strong>${food.productId}</strong> </label>
              <div class="input-group">
                  <input type="hidden" class="form-control" id="foodID" placeholder="Id thức ăn" name="productId"
                         aria-describedby="inputGroupPrepend" value="${food.productId}" required>
                  <div class="invalid-feedback">
                      Username bắt đầu bằng chữ cái và từ 8 đến 20 kí tự không chứa kí tự đặc biệt
                  </div>
              </div>
          </div>

        <%--input ten food--%>
        <div class="col-md-6 offset-3 mb-3 mt-3">
          <label for="foodName">Tên thức ăn</label>
          <div class="input-group">
            <input type="text" class="form-control" id="foodName" placeholder="Tên thức ăn" name="foodName"
                   aria-describedby="inputGroupPrepend" value="${food.productName}" required>
            <div class="invalid-feedback">
              Username bắt đầu bằng chữ cái và từ 8 đến 20 kí tự không chứa kí tự đặc biệt
            </div>
          </div>
        </div>


        <%--input giá food--%>
        <div class="col-md-6 offset-3 mb-3">
          <label for="foodPrice">Giá thức ăn</label>
          <div class="input-group">
            <input type="number" class="form-control" id="foodPrice" placeholder="Giá thức ăn" name="foodPrice"
                   aria-describedby="inputGroupPrepend"  value="${food.productPrice}" required>
            <div class="invalid-feedback">
              Username bắt đầu bằng chữ cái và từ 8 đến 20 kí tự không chứa kí tự đặc biệt
            </div>
          </div>
        </div>
        <%--input loại Food--%>
        <div class="col-md-6 offset-3 mb-3">
          <label for="foodType" class="form-label">Chọn loại thức ăn</label>
          <select class="form-select" id="foodType" name="foodType" >
            <option value="dogFood" ${(food.productType.equals("dogFood")?"selected":" ")}>Cho chó</option>
            <option value="catFood" ${(food.productType.equals("catFood")?"selected":" ")}>Cho mèo</option>
          </select>
        </div>
        <%--input xuất xứ food--%>
        <div class="col-md-6 offset-3 mb-3">
          <label for="foodOrigin">Xuất xứ</label>
          <div class="input-group">
            <input type="text" class="form-control" id="foodOrigin" placeholder="Xuất xứ" name="foodOrigin" value="${food.origin}"
                   aria-describedby="inputGroupPrepend"  required>
            <div class="invalid-feedback">
              Username bắt đầu bằng chữ cái và từ 8 đến 20 kí tự không chứa kí tự đặc biệt
            </div>
          </div>
        </div>
        <div class="col-md-6 offset-3 mb-3">
          <label for="status" class="form-label">Trạng thái</label>
          <select class="form-select" id="status" name="status">
            <option value="0" ${(food.status.equals("0")?"selected":" ")}>Ngừng bán</option>
            <option value="1" ${(food.status.equals("1")?"selected":" ")}>Đang bán</option>
          </select>
        </div>
        <div class="row">
          <div class="col-3 offset-3">
            <button class="btn btn-primary" type="submit">Cập nhật</button>
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
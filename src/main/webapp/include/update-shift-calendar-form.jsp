<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 22/06/2023
  Time: 5:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="container">

  <div class="row ">
    <form class="needs-validation mt-3" novalidate action="updateshiftcalendar" method="post">

      <div class="row">
        <div class="col-12" style="background-color:#7ab730;border-radius: 10px ">
          <h2>Cập nhật ca</h2>
        </div>


        <%--input shiftID--%>
        <div class="col-md-6 offset-3 mb-3 mt-3">
          <label for="shiftID">ID ca</label>
          <div class="input-group">
            <input type="hidden" class="form-control" id="shiftID" name="shiftID" value="${shiftID}"
                   aria-describedby="inputGroupPrepend"  required>
            <h3>${shiftID}</h3>
            <div class="invalid-feedback">
              Tối đa từ 1-50 ký tự
            </div>
          </div>
        </div>


        <%--input  serviceID--%>
        <div class="col-md-6 offset-3 mb-3">
          <label for="serviceID">ID service</label>
          <div class="input-group">
            <input type="hidden"  class="form-control" id="serviceID" name="serviceID" value="${serviceID}"
                   aria-describedby="inputGroupPrepend"  required>
            <h3>${serviceID}</h3>
            <div class="invalid-feedback">
              Giá tiền chỉ bao gồm chữ số
            </div>
          </div>
        </div>

        <%--input số lương thú cưng--%>
        <div class="col-md-6 offset-3  mb-3">
          <label for="numberOfResponses">Số lượng thú cưng đáp ứng (Lưu ý phải lớn hơn ${numberOfResponses} )</label>
          <div class="input-group">
            <input type="number" min="${numberOfResponses+1}"    class="form-control" id="numberOfResponses" placeholder="Số lượng" name="numberOfResponses"
                   aria-describedby="inputGroupPrepend"  required>
            <div class="invalid-feedback">
              Số lượng thú cưng đáp ứng phải lớn hơn số lượng cũ
            </div>
          </div>
        </div>


        <%--ngày đặt--%>
        <div class="col-md-6 offset-3  mb-3">
          <label for="setDay">Ngày đặt</label>
          <div class="input-group">
            <input type="hidden"  class="form-control" id="setDay" placeholder="Số lượng" name="setDay" value="${day}"
                   aria-describedby="inputGroupPrepend"  required>
            <h3>${day}</h3>
            <div class="invalid-feedback">
              Số lượng từ 1 trở lên
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
<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 6/23/2023
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="cart-page">
  <style>
    .cart-page {
      position: relative;
      margin-top: 30px;
    }

    .cart-page .cart-page-inner {
      padding: 30px;
      margin-bottom: 30px;
      background: #ffffff;
    }

    .table-responsive {
      display: block;
      width: 100%;
      overflow-x: auto;
      -webkit-overflow-scrolling: touch;
    }

    .cart-page .table {
      width: 100%;
      text-align: center;
      margin-bottom: 0;
    }

    .table-responsive>.table-bordered {
      border: 0;
    }

    .table-bordered {
      border: 1px solid #dee2e6;
    }

    .cart-page .table td {
      font-size: 16px;
      vertical-align: middle;
    }
    .table-bordered td, .table-bordered th {
      border: 1px solid #dee2e6;
    }
    .table td, .table th {
      padding: 0.75rem;
      vertical-align: top;
      border-top: 1px solid #dee2e6;
    }

    .cart a {
      color: #7AB730;
    }

    .cart-page .table .img {
      display: flex;
      align-items: center;
    }
    .cart-page .table .img img {
      max-width: 60px;
      max-height: 60px;
      margin-right: 15px;
    }
    img {
      vertical-align: middle;
      border-style: none;
    }

    .cart-page .table .qty {
      display: inline-block;
      width: 100px;
      font-size: 0;
    }
    .cart-page .table button.btn-minus {
      border-radius: 4px 0 0 4px;
    }
    .cart-page .table button.btn-plus {
      border-radius: 0 4px 4px 0;
    }
    .cart-page .table button {
      width: 30px;
      height: 30px;
      font-size: 14px;
      text-align: center;
      color: #ffffff;
      background: #7AB730;
      border: none;
      border-radius: 4px;
    }
    .cart-page .table input {
      width: 40px;
      height: 29px;
      font-size: 16px;
      color: #ffffff;
      text-align: center;
      background: #333333;
      border: none;
    }

    .cart-page .cart-page-inner {
      padding: 30px;
      margin-bottom: 30px;
      background: #ffffff;
    }
    .row {
      display: -ms-flexbox;
      display: flex;
      -ms-flex-wrap: wrap;
      flex-wrap: wrap;
      margin-right: -15px;
      margin-left: -15px;
    }
    .cart-page .coupon {
      display: flex;
      position: relative;
      width: 100%;
      margin-bottom: 15px;
      font-size: 0;
    }
    .cart-page .coupon input {
      width: calc(100% - 135px);
      height: 40px;
      padding: 0 15px;
      font-size: 16px;
      color: #999999;
      background: #ffffff;
      border: 1px solid #dddddd;
      border-radius: 4px;
      margin-right: 15px;
      transition: all .3s;
    }
    .cart-page .coupon .button {
      width: 120px;
      height: 40px;
      padding: 2px 0;
      font-size: 16px;
      text-align: center;
      color: #7AB730;
      background: #ffffff;
      border: 1px solid #7AB730;
      border-radius: 4px;
    }
    .cart-page .coupon .button:hover{
      background-color: #7AB730;
      color: white;
    }
    .cart-page .cart-summary {
      position: relative;
      width: 100%;
    }
    .cart-page .cart-summary .cart-content {
      padding: 30px;
      background: #f3f6ff;
    }
    .cart-page .cart-summary .cart-content h1 {
      font-size: 22px;
      margin-bottom: 20px;
    }
    .cart-page .cart-summary .cart-content h2 {
      font-size: 20px;
      font-weight: 600;
      padding-top: 12px;
      border-top: 1px solid #dddddd;
      margin: 0;
    }
    .cart-page .cart-summary .cart-btn button:first-child {
      margin-right: 25px;
      color: #7AB730;
      background: #ffffff;
      border: 1px solid #7AB730;
      transition: 200ms;
    }
    .cart-page .cart-summary .cart-btn button:first-child:hover{
      background-color: #7AB730;
      color: white;
    }
    .cart-page .cart-summary .cart-btn button {
      margin-top: 15px;
      width: calc(50% - 15px);
      height: 50px;
      padding: 2px 10px;
      text-align: center;
      color: #ffffff;
      background: #7AB730;
      border: none;
      border-radius: 4px;
      transition: 200ms;
    }
    .cart-page .cart-summary .cart-btn button:hover{
      color: #7AB730;
      background-color: white;
      border: 1px solid #7AB730;
    }


    <c:if test="${sessionScope.user==null}">
    <% response.sendRedirect("login.jsp");%>
    </c:if>
  </style>
  <div class="container-fluid">
    <div class="row">
      <div class="col-lg-8">
        <div class="cart-page-inner">
  <form class="needs-validation" novalidate action="createcheckout" method="post">
    <input type="hidden" name="ServiceID" value="${ServiceID}">
    <input type="hidden" name="setDay" value="${setDay}">
    <input type="hidden" name="shiftID" value="${shiftID}">

    <div class="row">
      <div class="col-12" style="background-color:#7ab730;border-radius: 10px ">
<%--        <h2>Xác nhận dặt dịch vụ ${ServiceID} ${servicePrice} ${max}</h2>--%>
        <h2>Xác nhận dặt dịch vụ ngày ${setDay}</h2>
      </div>
      <%--input fistname--%>
      <div class="col-md-6 offset-3 mb-3">
        <label for="firstname">Họ</label>
        <div class="input-group">
          <input type="text" class="form-control" id="firstname" placeholder="Họ" name="firstname"
                 value="${sessionScope.user.firstname}"
                 aria-describedby="inputGroupPrepend" pattern="^[\p{Lu}\p{Ll}\sA-Za-záàảãạăắằẳẵặâấầẩẫậéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵ]{1,50}$" required>
          <div class="invalid-feedback">
            Họ chứa từ 1 đến 50 kí tự, không chứa ký tự đặc biệt và chữ số
          </div>
        </div>
      </div>
      <%-- input lastname--%>
      <div class="col-md-6 offset-3 mb-3">
        <label for="lastname">Tên</label>
        <div class="input-group">
          <input type="text" class="form-control" id="lastname" placeholder="Tên" name="lastname"
                 value="${sessionScope.user.lastname}"
                 aria-describedby="inputGroupPrepend" pattern="^[\p{Lu}\p{Ll}\sA-Za-záàảãạăắằẳẵặâấầẩẫậéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵ]{1,50}$" required>
          <div class="invalid-feedback">
            Tên chứa từ 1 đến 50 kí tự, không chứa ký tự đặc biệt và chữ số
          </div>
        </div>
      </div>

      <%--        input address--%>
      <div class="col-md-6 offset-3 ol mb-3">
        <label for="address">Địa chỉ</label>
        <div class="input-group">
          <input type="text" class="form-control" id="address" placeholder="Địa chỉ" name="address"
                 value="${sessionScope.user.address}"
                 aria-describedby="inputGroupPrepend" pattern="^[^@#$%^&*\\(\\)\\-+=]+{1,100}$" required>
          <div class="invalid-feedback">
            Địa chỉ có độ dài 100 kí tự
          </div>
        </div>
      </div>

      <%--        input phone--%>
      <div class="col-md-6 offset-3 mb-3">
        <label for="address">Điện thoại</label>
        <div class="input-group">
          <input type="text" class="form-control" id="phone" placeholder="Điện thoại" name="phone" value="${sessionScope.user.phone}"
                 aria-describedby="inputGroupPrepend" pattern="^[0-9]{10}$" required>
          <div class="invalid-feedback">
            Số điện thoại có dộ dài 10 kí tự
          </div>
        </div>
<%--input pet--%>
<%--        <div class="form-group">--%>
<%--          <label for="numberInput">Nhập số lượng pet</label>--%>
<%--          <input type="number" name="ammount" class="form-control" id="numberInput" max="${max}" oninput="calculate()">--%>
<%--        </div>--%>

        <div class="col-md-6 offset-3  mb-3">
          <label for="numberInput">Số lượng thú cưng đáp ứng (Lưu ý phải bé hơn ${max} )</label>
          <div class="input-group">
            <input type="number" min="1"  max = "${max}"   class="form-control" id="numberInput" placeholder="Số lượng" name="ammount"
                   aria-describedby="inputGroupPrepend"  required oninput="calculate()">
            <div class="invalid-feedback">
              Số lượng thú cưng đáp ứng không đủ
            </div>
          </div>
        </div>

      </div>
    </div>
    <div class="row">
      <div class="col-3 offset-3">
        <button class="btn btn-primary" type="submit">Xác nhận</button>
        <pc style="color: green">${thongbao}</pc>
      </div>

    </div>

  </form>
        </div>
      </div>
      <div class="col-lg-4">
        <div class="cart-page-inner">
          <div class="row">
            <div class="col-md-12">
              <div class="coupon">
                <input type="text" placeholder="Nhập mã giảm giá tại đây">
                <input class="button" type="submit" value="Áp dụng">
              </div>
            </div>
            <div class="col-md-12">
              <div class="cart-summary">
                <div class="cart-content">
                  <h1>Thanh toán dịch vụ</h1>
                  <p>Tạm tính  <span id="result1"></span></p>
                  <p>Chi phí khác  <span>0đ</span></p>
                  <h2>Thành tiền  <span id="result2"></span></h2>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script>
  function calculate() {
    var userInput = document.getElementById("numberInput").value;
    var result = userInput * parseFloat(${servicePrice}) * 1000;
    document.getElementById("result1").innerHTML = result + " đ";
    document.getElementById("result2").innerHTML = result + " đ";
  }
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

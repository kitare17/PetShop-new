<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 7/19/2023
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<div class="container-fluid">
    <div class="container">
        <div class="col-md-12 col-sm-9 col-xx-6 col-xs-12 gach_line">
            <div class="border-start border-5 border-primary ps-5 mb-5 mt-5" style="max-width: 600px;">
                <h6 class="text-primary text-uppercase">Lịch sử đặt dịch vụ</h6>
                <h1 class="display-5 text-uppercase mb-0">Các đơn dịch vụ bạn đã đặt</h1>
            </div>
            <div id="tab1" class="content_tab">
                <table width="100%" cellspacing="0" cellpadding="0" class="table-bordered text-center table-hover">
                    <thead class="">
                    <td style="padding-left:5px;">Mã đơn hàng</td>
                    <td>Tên dịch vụ</td>
                    <td>Ngày tạo đơn</td>
                    <td>Ngày đặt dịch vụ</td>
                    <td>Khung giờ</td>
                    <td>Số lượng</td>
                    <td>Giá tiền</td>
                    <td>Tình trạng</td>

                    </thead>
                    <tbody>
                    <c:forEach items="${listOrdered}" var="i">
                        <tr>
<%--                            getPriceAtPurchaseReal()--%>
                            <td><a href="getbookeddetail?billID=${i.billID}&serviceName=${i.serviceName}&ammount=${i.ammount}&priceAtPurchase=${i.getPriceAtPurchaseReal()}&status=${i.status}">${i.billID}</a></td>
                            <td>${i.serviceName}</td>
                            <td>${i.dateCreate}</td>
                            <td>${i.setDay}</td>
                            <td>${i.getTimeToString()}</td>
                            <td>${i.ammount}</td>
                            <td>${i.getPriceAtPurchaseReal()}</td>
                            <td>${i.status}</td>


                        </tr>
<%--                        ${orderedCart.getThanhTienStringAfterPurchaseDiscount(30000)}--%>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>

    </div>
</div>
<%-- <table>
     <tr>
         <td>Mã đơn hàng</td>
         <td>Ngày mua</td>
         <td>Sản phẩm</td>
         <td>Tổng tiền</td>
         <td>Tình trạng</td>

     </tr>
     <c:forEach items="${listOrdered}" var="i">
         <tr>
             <td><a href="getordereddetail?orderId=${i.orderedId}">${i.orderedId}</a></td>
             <td>${i.date}</td>
             <td>
                 <c:forEach items="${i.cart}" var="item">
                     +${item.product.productName}: x${item.ammout} <br>
                 </c:forEach>

             </td>
             <td>${i.getThanhTienString(30000)}</td>
             <td>${i.orderStatus}</td>
         </tr>
     </c:forEach>

 </table>
</body>--%>

</html>

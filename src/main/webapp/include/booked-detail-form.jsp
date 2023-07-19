<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 7/19/2023
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container-fluid">
    <div class="container">
        <div class="donhang">
            <div class="border-start border-5 border-primary ps-5 mb-5 mt-5">
                <h6 class="text-primary text-uppercase">Đơn hàng</h6>
                <h1 class="display-5 text-uppercase mb-0">Kiểm tra đơn hàng của bạn </h1>

            </div>
            <div class="d-flex justify-content-center">
                <h2 class="text-primary m-1 p-0">Tình trạng đơn hàng của bạn: </h2>
                <h2 class="text-danger m-1 p-0"> ${status}</h2>
            </div>
            <div class="mt-5 text-center">
                <p class="">Khách vui lòng đến đúng thời gian đã hẹn</p>
<%--                <p>Đơn hàng của quý khách đã được gửi cho hãng vận chuyển Viettel Post</p>--%>
                <p class="text-danger">Mã đơn hàng: ${billID}</p>
            </div>
            <div class="d-flex justify-content-around">
                <div class="border-top pt-3 col-md-7 kt-left">
                    <h3>Thông tin đơn hàng</h3>
                        <div class="border-bottom">
                            <div class="d-flex">
<%--                                <div class="p-1">--%>
<%--                                    <img width="60px" height="60px" src="img/product/${i.product.productId}.jpg" alt="">--%>
<%--                                </div>--%>
                                <div class="p-1">
                                    <strong>${serviceName}</strong>
                                </div>
                            </div>
                            <div style="text-align: right; font-size: larger;" class="p-1">
                                <strong>X ${ammount}</strong>
                            </div>
                        </div>
                    <div class="mt-3">
                        <div class="w-50 d-flex justify-content-between">
                            <span>Tổng tiền phải trả</span>
                            <strong style="font-size: larger;">${priceAtPurchase}</strong>
                        </div>
                        <div class="w-50 d-flex justify-content-between">
                            <span>Chi phí khác :</span>
                            <strong style="font-size: larger;">0đ</strong>
                        </div>
                        <div class="w-50 border-top pt-2 mt-3 d-flex justify-content-between">
                            <span>Tổng cộng:</span>
                                <strong style="font-size: x-large;">${priceAtPurchase}</strong>

                        </div>
                    </div>
                </div>
                <div class="border-top pt-3 col-md-4 kt-right">
                    <h3>Thông tin khách hàng</h3>
                    <div>
                        <p>${sessionScope.user.firstname} ${sessionScope.user.lastname}</p>
                        <p>Số điện thoại: ${sessionScope.user.phone}</p>
                        <%--                        <p>Gmail: thằng khoa nó chua bo? email =((</p>--%>
                        <p>Địa chỉ: ${sessionScope.user.address}</p>
                    </div>
                </div>
            </div>
            <div class="mt-5 d-flex justify-content-center">
                <p>Nếu bạn có bất cứ câu hỏi nào, đừng ngần ngại liên lạc với chúng tôi qua Hotline: 0123456789 (9h
                    -
                    19h các ngày thứ 2 đến thứ 7)</p>
            </div>
        </div>

    </div>
</div>

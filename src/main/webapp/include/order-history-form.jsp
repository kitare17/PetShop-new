<%-- 
    Document   : order-history-form
    Created on : Mar 19, 2023, 10:17:18 AM
    Author     : quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        #pagination {
            margin-top: 10px;
        }

        .paging-button {
            display: inline-block;
            padding: 5px 10px;
            border: 1px solid #ccc;
            background-color: #f7f7f7;
            cursor: pointer;
            text-decoration: none;
        }

        .paging-button.active {
            background-color: #ccc;
        }

    </style>
    <body>
        <div class="container-fluid">
            <div class="container">
                <div class="col-md-12 col-sm-9 col-xx-6 col-xs-12 gach_line">
                    <div class="border-start border-5 border-primary ps-5 mb-5 mt-5" style="max-width: 600px;">
                        <h6 class="text-primary text-uppercase">Lịch sử đơn hàng</h6>
                        <h1 class="display-5 text-uppercase mb-0">Các đơn hàng bạn đã đặt</h1>
                    </div>
                    <div id="tab1" class="content_tab">
                        <table width="100%" cellspacing="0" cellpadding="0" class="table-bordered text-center table-hover" id="data-table">
                            <thead class="">
                            <td style="padding-left:5px;">Mã đơn hàng</td>
                            <td>Ngày mua</td>
                            <td>Sản phẩm</td>
                            <td>Tổng tiền</td>
                            <td>Tình trạng</td>

                            </thead>
                            <tbody>    
                                <c:forEach items="${listOrdered}" var="i">
                                    <tr>
                                        <td><a href="getordereddetail?orderId=${i.orderedId}">${i.orderedId}</a></td>
                                        <td>${i.date}</td>
                                        <td>
                                            <c:forEach items="${i.cart}" var="item">
                                                <div><p>+${item.product.productName}: x${item.ammout}</p><div>
                                            </c:forEach>
                                            
                                        </td>
                                            <td width="15%">
                                                <c:if test="${i.discountCode == null}">
                                                    ${i.getThanhTienStringAfterPurchase(30000)}
                                                </c:if>
                                                <c:if test="${i.discountCode != null}">
                                                    <del>${i.getThanhTienStringAfterPurchase(30000)}</del> ${i.getThanhTienStringAfterPurchaseDiscount(30000)}
                                                </c:if>
                                            </td>
                                        <td width="15%">
                                            ${i.orderStatus}</td>
                                    </tr>
                                    ${orderedCart.getThanhTienStringAfterPurchaseDiscount(30000)}
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>

            </div>
        </div>
        <div id="pagination" class="text-center"></div>


        <script>
            var currentPage = 1;
            var recordsPerPage = 10;
            var table = document.getElementById("data-table");
            var rows = table.getElementsByTagName("tr");
            var totalPage = Math.ceil(rows.length / recordsPerPage);

            function showTable(page) {
                var start = (page - 1) * recordsPerPage;
                var end = start + recordsPerPage;

                for (var i = 0; i < rows.length; i++) {
                    if (i >= start && i < end) {
                        rows[i].style.display = "table-row";
                    } else {
                        rows[i].style.display = "none";
                    }
                }
            }

            function createPagination() {
                var pagination = document.getElementById("pagination");
                pagination.innerHTML = "";

                for (var i = 1; i <= totalPage; i++) {
                    var button = document.createElement("a");
                    button.href = "#";
                    button.innerHTML = i;

                    if (i === currentPage) {
                        button.classList.add("paging-button", "active");
                    } else {
                        button.classList.add("paging-button");
                    }

                    button.addEventListener("click", function () {
                        currentPage = parseInt(this.innerHTML);
                        showTable(currentPage);

                        var currentButton = document.querySelector(".paging-button.active");
                        currentButton.classList.remove("active");

                        this.classList.add("active");
                    });

                    pagination.appendChild(button);
                }
            }

            showTable(currentPage);
            createPagination();

        </script>

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

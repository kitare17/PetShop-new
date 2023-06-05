<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 02/06/2023
  Time: 2:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%--<c:if test="${!sessionScope.user.userRole.equals('admin')}">--%>
<%--    <% response.sendRedirect("index.jsp"); %>--%>
<%--</c:if>--%>


<div class="container-fluid pt-5 ">
    <div class="container">
        <div class="border-start border-5 border-primary ps-5 mb-5" style="max-width: 600px;">
            <h6 class="text-primary text-uppercase">Welcome admin</h6>
            <h1 class="display-5 text-uppercase mb-0">Admin management page</h1>
        </div>
        <div class="col-md-12 statistical d-flex justify-content-around mb-5">
            <div class="d-flex register m-1">
                <div style="background-color: orange;" class="icon"><i class="fa-solid fa-person-circle-check"></i>
                </div>
                <div class="detail">
                    <div>${show.getAmountUser()}</div>
                    <div>account registrant</div>
                </div>
            </div>
            <div class="d-flex user m-1">
                <div style="background-color: rgba(0, 0, 255, 0.726);" class="icon"><i
                        class=" fa-solid fa-user"></i></div>
                <div class="detail">
                    <div>${show.getCustomerOrder()}</div>
                    <div>customer has at least 1 order</div>
                </div>
            </div>
            <div class="d-flex pet-sold m-1">
                <div style="background-color: #7AB730;" class="icon"><i class="fa-solid fa-paw"></i></div>
                <div class="detail">
                    <div>120</div>
                    <div>total pet sold</div>
                </div>
            </div>
            <div class="d-flex service m-1">
                <div style="background-color: rgb(255, 108, 133);" class="icon"><i
                        class="fa-solid fa-hand-holding-heart"></i></div>
                <div class="detail">
                    <div>120</div>
                    <div>total service used</div>
                </div>
            </div>
            <div class="d-flex money m-1">
                <div style="background-color: rgb(204, 0, 204);" class="icon"><i class=" fa-solid fa-coins"></i>
                </div>
                <div class="detail">
                    <div>120.000.000</div>
                    <div>revenue</div>
                </div>
            </div>
        </div>
    </div>
</div>





<!-- Thêm dich vu -->
<button type="button" class="btn btn-primary m-2 col-md-2" data-bs-toggle="modal" data-bs-target="#exampleModal"
        data-bs-whatever="@mdo">Thêm dịch vụ</button>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Thêm Dịch vụ</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="addfood" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
                    <div class="mb-3">
                        <label for="sname" class="col-form-label">Tên dịch vụ:</label>
                        <input type="text" class="form-control" id="sname" name="serviceName">
                    </div>
                    <div class="mb-3">
                        <label for="sprice" class="col-form-label">Giá dịch vụ:</label>
                        <input type="text" class="form-control" id="sprice" name="servicePrice">
                    </div>
                    <div class="mb-3">
                        <label for="surl" class="col-form-label">Url ảnh:</label>
                        <input type="text" class="form-control" id="surl" name="serviceUrl">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary" >Add</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>


<!-- ------List dich vu----- -->


<button type="button" class="btn btn-primary m-2 col-md-2" data-bs-toggle="modal" data-bs-target="#listFood">
    Danh sách dịch vụ
</button>

<div class="modal fade" id="listFood" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Danh sách dịch vụ</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <table class="table" style="width: 100%;">
                    <thead>
                    <td>ID dịch vụ</td>
                    <td>Tên dịch vụ</td>
                    <td>Giá dịch vụ</td>
                    <td>Trạng thái dịch vụ</td>
                    <td></td>
                    <td></td>
                    </thead>
                    <tbody>

                    <tr>
                        <td>fd</td>
                        <td>cuat</td>
                        <td>5000</td>
                        <td>ok</td>
                        <td><a class="btn btn-primary m-0" href="#">Cập nhật</a></td>
                        <td><a class="btn btn-danger m-0" onclick="deletePro('${i.productId}')">Dừng phục vụ</a></td>
                    </tr>

                    <c:forEach items="${show.getAllFood()}" var="i" >
                        <tr id="row${i.productId}">
                            <td>${i.productId}</td>
                            <td>${i.productName}</td>
                            <td>${i.productType}</td>
                            <td>${i.productPrice}</td>
                            <td>${i.productAmount}</td>
                            <td><img class="w-25" src="img/product/${i.productId}.jpg" alt=""></td>
                            <td><a class="btn btn-primary m-0" href="#">Update</a></td>
                            <td><a class="btn btn-danger m-0" onclick="deletePro('${i.productId}')">Delete</a></td>
                        </tr>

                    </c:forEach>

                    </tbody>
                </table>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>






<!-- Style -->
<style>
    .statistical .icon {

        color: white;
        align-self: center;
        padding: 30px 20px;
        font-size: xx-large;
        border-radius: 10% 0 0 10%;
    }

    .statistical .detail {
        background-color: rgba(128, 128, 128, 0.116);
        border-radius: 0 10% 10% 0;
        width: 150px;
        font-size: smaller;
        text-align: center;
    }

    .statistical .detail :first-child {
        font-size: 40px;
        width: 100%;

        padding-top: 5%;
    }

    .statistical .money .detail {
        width: 250px !important;
    }
</style>
<script>
    function deletePro(id){
        $.ajax({
            url: '/pet-shop/removeproduct',
            type: 'GET',
            data: {
                id: id,
            },
            success: function (data) {
                document.getElementById("row" + id).remove();
            }
        });
    }
</script>


<%-- 
    Document   : admin_form
    Created on : 22-03-2023, 10:58:35
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


 <c:if test="${!sessionScope.user.userRole.equals('admin')}">
     <% response.sendRedirect("index.jsp"); %>
                                </c:if>


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





<!-- Thêm Food -->
<button type="button" class="btn btn-primary m-2 col-md-2" data-bs-toggle="modal" data-bs-target="#exampleModal"
        data-bs-whatever="@mdo">Thêm Food</button>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Thêm Food</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="addfood" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
                    <div class="mb-3">
                        <label for="fname" class="col-form-label">Food Name:</label>
                        <input type="text" class="form-control" id="fname" name="productName">
                    </div>
                    <div class="mb-3">
                        <label for="ftype" class="col-form-label">Food Type:</label>
                        <input type="text" class="form-control" id="ftype" name="productType">
                    </div>
                    <div class="mb-3">
                        <label for="fprice" class="col-form-label">Food Price:</label>
                        <input type="text" class="form-control" id="fprice" name="productPrice">
                    </div>
                    <div class="mb-3">
                        <label for="famount" class="col-form-label">Food Amount:</label>
                        <input type="text" class="form-control" id="famount" name="productAmount">
                    </div>
                    <div class="mb-3">
                        <label for="fpic" class="col-form-label">Food Picture:</label>
                        <input type="file" class="form-control" id="fpic" name="file">
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


<!-- Thêm Pet -->
<button type="button" class="btn btn-primary m-2 col-md-2" data-bs-toggle="modal" data-bs-target="#addPet"
        data-bs-whatever="@mdo">Thêm Pet</button>
<div class="modal fade" id="addPet" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Thêm Pet</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="addpet" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
                    <div class="mb-3">
                        <label for="name" class="col-form-label">Pet Name:</label>
                        <input type="text" class="form-control" id="name" name="productName">
                    </div>
                    <div class="mb-3">
                        <label for="color" class="col-form-label">Pet Color:</label>
                        <input type="text" class="form-control" id="color" name="petColor">
                    </div>
                    <div class="mb-3">
                        <label for="type" class="col-form-label">Pet Type:</label>
                        <input type="text" class="form-control" id="type" name="productType">
                    </div>
                    <div class="mb-3">
                        <label for="price" class="col-form-label">Pet Price:</label>
                        <input type="text" class="form-control" id="price" name="productPrice">
                    </div>
                    <div class="mb-3">
                        <label for="amount" class="col-form-label">Pet Amount:</label>
                        <input type="text" class="form-control" id="amount" name="productAmount">
                    </div>
                    <div class="mb-3">
                        <label for="pic" class="col-form-label">Pet Picture:</label>
                        <input type="file" class="form-control" id="pic" name="file">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Add</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>


<!-- ------List Food----- -->


<button type="button" class="btn btn-primary m-2 col-md-2" data-bs-toggle="modal" data-bs-target="#listFood">
    List Food
</button>

<div class="modal fade" id="listFood" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">List Food</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <table class="table" style="width: 100%;">
                    <thead>
                    <td>FoodID</td>
                    <td>FoodName</td>
                    <td>FoodType</td>
                    <td>FoodPrice</td>
                    <td>FoodAmount</td>
                    </thead>
                    <tbody>

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


<!-- ------List Pet------- -->

<button type="button" class="btn btn-primary m-2 col-md-2" data-bs-toggle="modal" data-bs-target="#listPet">
    List Pet
</button>

<div class="modal fade" id="listPet" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">List Pet</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <table class="table" style="width: 100%;">
                    <thead class="thead-dark w-100">
                    <td>PetID</td>
                    <td>PetName</td>
                    <td>PetColor</td>
                    <td>FoodType</td>
                    <td>FoodPrice</td>
                    <td>FoodAmount</td>
                    </thead>
                    <tbody class="w-100">

                        <c:forEach items="${show.getAllPet()}" var="i" >
                            <tr>
                                <td>${i.productId}</td>
                                <td>${i.productName}</td>
                                <td>${i.petColor}</td>
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
<!-- ----------Duyệt đơn hàng--------- -->
<button type="button" class="btn btn-primary m-2 col-md-2" data-bs-toggle="modal" data-bs-target="#accept">
    Order Accept
</button>

<div class="modal fade" id="accept" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Duyệt đơn hàng</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <table class="table" style="width: 100%;">
                    <thead class="thead-dark w-100">
                    <td style="padding-left:5px;">Mã đơn hàng</td>
                    <td>Người mua</td>
                    <td>Ngày đặt</td>
                    <td>Mã giảm giá</td>
                    <td>Tổng tiền</td>
                    <td>Tình trạng</td>
                    </thead>
                    <tbody class="w-100">
                        <c:forEach items="${show.getAllOrder()}" var="i">
                            <tr>
                                <td>${i.idOrder}</td>
                                <td>${i.username}</td>
                                <td>${i.date}</td>
                                <td>${i.getDiscountId()==null?"Khong ma":"co ma"}</td>
                                <td>${i.total}</td>
                                <td>${i.orderStatus}</td>
                                <td><a class="btn btn-primary m-0" href="acceptorder?id=${i.idOrder}">Duyệt</a></td>
                                <td><a class="btn btn-danger m-0" href="removeorder?id=${i.idOrder}">Hủy</a></td>
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
<!-- JavaScript Libraries 
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/waypoints/waypoints.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script> -->

<!-- Template Javascript 
<script src="js/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
crossorigin="anonymous"></script>-->

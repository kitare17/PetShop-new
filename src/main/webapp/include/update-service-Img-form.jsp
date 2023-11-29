<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 02/06/2023
  Time: 3:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<button type="button" class="btn btn-primary m-2 col-md-2" data-bs-toggle="modal" data-bs-target="#listFood">
   Danh sách ảnh
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
                    <td>Anh</td>
                    <td></td>

                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <img class="w-25" src="https://tse1.mm.bing.net/th?id=OIP.9U6ZvbMYvlmVJ7RwuBaajAHaLJ&pid=Api&P=0&h=180" alt="">
                            </td>
                            <td><a class="btn btn-danger m-0" onclick="deletePro('${i.productId}')">Delete</a></td>
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
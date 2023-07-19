<%--
    Document   : food_form
    Created on : 14-03-2023, 13:01:50
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
<div>
    ${food.productId}
    ${food.productName}
    ${food.productType}
    ${food.productPrice}
    ${food.productAmount}
</div>
--%>

<div class="container-fluid d-none d-lg-block pt-5 mb-5">
    <div class="container">
        <div class="border-start border-5 border-primary ps-5 mb-5" style="max-width: 600px;">
            <h6 class="text-primary text-uppercase">Thức ăn</h6>
            <h1 class="display-5 text-uppercase mb-0">Thức ăn cho thú cưng</h1>
        </div>
       <div class="row">
           <c:forEach var="food" items="${listFood}">
               <div style="height: 350px;" class="pb-5 mb-5 mt-5 col-4 ">
                   <div class="product-item owl-item position-relative bg-light d-flex flex-column text-center">
                       <img class="img-fluid mb-4 w-100" src="${food.getListImg().get(0).url}" alt="">
                       <h6 class="text-uppercase">${food.productName}</h6>
                       <h5 class="text-primary mb-0">${food.getPriceString()}</h5>
                       <div class="btn-action d-flex justify-content-center">
                           <a class="btn btn-primary py-2 px-3" href="getfooddetail?id=${food.productId}"><i class="bi bi-cart"></i></a>
                           <a class="btn btn-primary py-2 px-3" href="getfooddetail?id=${food.productId}"><i class="bi bi-eye"></i></a>
                       </div>
                   </div>
               </div>
           </c:forEach>
        <div class="w-100"> </div>

       </div>
    </div>
</div>
<div class="container" style="margin-top: 100px;font-size: larger" >
    <div class="row ">
        <div class="col-12 d-flex justify-content-center">
            <c:forEach var="i" begin="1" end="${maxPage}">
                <a class="btn btn-light" href="food?page=${i}">${i}</a>
            </c:forEach>
        </div>
    </div>
</div>





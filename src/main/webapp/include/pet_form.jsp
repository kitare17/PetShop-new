<%-- 
    Document   : pet_form
    Created on : 14-03-2023, 13:01:58
    Author     : PC
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
        <div class="container-fluid d-none d-lg-block pt-5">
            <div class="container">
                <div class="border-start border-5 border-primary ps-5 mb-5" style="max-width: 600px;">
                    <h6 class="text-primary text-uppercase">Pets</h6>
                    <h1 class="display-5 text-uppercase mb-0">A FRIEND FOR YOUR LIFE</h1>
                </div>
                <div class="row g-5 d-flex flex-row">
                    <c:forEach var="pet" items="${listPet}">
                        <div class="pb-5 col-md-3">
                            <div class="product-item position-relative bg-light d-flex flex-column text-center">
                                <img class="img-fluid mb-4 w-100" src="img/product/${pet.productId}.jpg" alt="">
                                <h6 class="text-uppercase">${pet.productName}</h6>
                                <h5 class="text-primary mb-0">${pet.getPriceString()}</h5>
                                <div class="btn-action d-flex justify-content-center">
                                    <a class="btn btn-primary py-2 px-3" href="getpetdetail?id=${pet.productId}"><i class="bi bi-cart"></i></a>
                                    <a class="btn btn-primary py-2 px-3" href="getpetdetail?id=${pet.productId}"><i class="bi bi-eye"></i></a>
                                </div>
                            </div>
                        </div>    
                    </c:forEach>
                </div>
            </div>
        </div>
          
    
<%--       <div>
            ${pet.productId}

            ${pet.productName}
            ${pet.productType}
            ${pet.productPrice}
            ${pet.productAmount}
            ${pet.petColor}
        </div>
--%>
    </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 13/06/2023
  Time: 7:49 CH
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container-fluid d-none d-lg-block pt-5">
  <div class="container">
    <div class="border-start border-5 border-primary ps-5 mb-5" style="max-width: 600px;">
      <h6 class="text-primary text-uppercase">Pet's Food</h6>
      <h1 class="display-5 text-uppercase mb-0">PRODUCTS FOR YOUR BEST FRIENDS</h1>
    </div>
    <div class="row g-5 d-flex flex-row owl-carousel product-carousel">
      <c:forEach var="food" items="${listFood}">
        <div style="height: 350px;" class="pb-5 mb-4 ">
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
    </div>
  </div>
</div>
<div class="d-flex justify-content-center "><a href="food" style="margin-bottom: 50px" class="btn btn-primary p-2">See more</a></div>



<div class="container-fluid d-none d-lg-block pt-5">
  <div class="container">
    <div class="border-start border-5 border-primary ps-5 mb-5" style="max-width: 600px;">
      <h6 class="text-primary text-uppercase">Pets</h6>
      <h1 class="display-5 text-uppercase mb-0">A FRIEND FOR YOUR LIFE</h1>
    </div>


    <div class=" ">
      <form class="" action="pet" method="get">

        <select style="padding: 8px; border-radius: 10px; outline: none" class="input-group w-25 mt-5 " name="type">
          <option class="" value="all">All</option>
          <option value="dog">Dog</option>
          <option value="cat">Cat</option>
        </select>
        <input class="btn btn-primary h5 m-2" type="submit" value="Filter">
      </form>
    </div>

    <div class="owl-carousel product-carousel row g-5 d-flex flex-row">
      <c:forEach var="pet" items="${listPet}">
        <div style="height: 350px;" class="pb-5 d-flex">
          <div class="product-item owl-item position-relative bg-light d-flex flex-column text-center">
            <img class="img-fluid mb-4 w-100" src="${pet.getListImg().get(0).url}" alt="loi">
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
<div class="d-flex justify-content-center "><a  href="pet" style="margin-bottom: 50px" class="btn btn-primary p-2">See more</a></div>
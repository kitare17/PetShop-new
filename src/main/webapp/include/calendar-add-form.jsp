<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 19/06/2023
  Time: 3:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1 class="m-5">Thông tin chung về dịch vụ ${serviceName} đặt ngày ${day} ${serviceID}</h1>
<div class="container">
    <div class="row">



        <c:forEach items="${listShift}" var="l">
            <%--        slot 1  --%>

                <div class="col-md-3 col-6 mb-3">
                    <div class="card " style="width: 100%;">
                        <div class="card-header bg-warning">
                            <h2>${l.shiftName}</h2>
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">Thông tin chung:</h5>
                            <p class="card-text"> <strong>Số lượng khách đã đặt</strong>  <span class="badge bg-primary"> 0/${l.numberOfResponse}</span></p>
                            <p class="card-text"> <strong>Trạng thái</strong>
                                <c:if test="${l.numberOfResponse!=0}">
                                    <span class="badge bg-success"> Đã lên lịch</span>
                                </c:if>
                                <c:if test="${l.numberOfResponse==0}">
                                    <span class="badge bg-danger">Chưa lên lịch</span>
                                </c:if>

                            </p>
                            <c:if test="${l.numberOfResponse!=0}">
                                <a href="#" class="btn btn-primary">Cập nhật</a>
                                <p class="text-danger">* Lưu ý  cách ngày hôm nay ít nhất 2 ngày</p>
                            </c:if>
                            <c:if test="${l.numberOfResponse==0}">
                                <a href="#" class="btn btn-primary">Lên lịch ngay</a>
                                <p class="text-danger">* Lưu ý  cách ngày hôm nay ít nhất 2 ngày</p>
                            </c:if>

                        </div>
                    </div>

                </div>





        </c:forEach>




    </div>
</div>


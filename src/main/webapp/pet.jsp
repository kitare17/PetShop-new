<%-- 
    Document   : pet.jsp
    Created on : 17-03-2023, 13:24:00
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/header.jsp" %>
<form action="pet" method="get">
    
    <select name="type">
        <option value="all">All</option>
        <option value="dog">Dog</option>
        <option value="cat">Cat</option> 
    </select>
    <input type="submit" value="Filter">
</form>
<%@include file="include/pet_form.jsp" %>
<a href="pet?page=first&type=${param.type}">First</a>
<c:choose>
    <c:when test="${page<=3}">
        <c:forEach var="i" begin="1" end="5">
            <c:if test="${i>0 and i<=maxPage}"><a href="pet?page=${i}&type=${param.type}">${i}</a></c:if>
        </c:forEach>

    </c:when>
    <c:when test="${page>=maxPage-2}">
        <c:forEach var="i" begin="${maxPage-4}" end="${maxPage}">
            <c:if test="${i>0 and i<=maxPage}"><a href="pet?page=${i}&type=${param.type}">${i}</a></c:if>

        </c:forEach>
    </c:when>
    <c:otherwise>
        <c:forEach var="i" begin="${page-2}" end="${page+2}">
            <c:if test="${i>0 and i<=maxPage}"><a href="pet?page=${i}&type=${param.type}">${i}</a></c:if>

        </c:forEach>
    </c:otherwise>
</c:choose>
<a href="pet?page=last&type=${param.type}">last</a>
<%@include file="include/footer.jsp" %>

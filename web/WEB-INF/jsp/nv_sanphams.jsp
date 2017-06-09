<%-- 
    Document   : nv_sanphams
    Created on : Jun 5, 2017, 11:35:35 PM
    Author     : VuQuang
--%>
<%@ page import=" model.dao.SanphamDAO"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script  src="/assests/js/bootstrap.min.js"></script>
<link href="<c:url value="/assests/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
              <div class="navbar-header">
                <a class="navbar-brand" href="viewProducts.htm">Product Management</a>
              </div>
              <ul class="nav navbar-nav">
                <li class="active"><a href="viewProducts.htm">Product List</a></li>
                <li><a href="viewPerInfo.htm">Personal Information</a></li>
                <li><a href="logout.htm">Logout</a></li>
              </ul>
            </div>
        </nav>
        <h1>Product List</h1>
        <table class="table table-bordered">
            <tr>
              <th>id</th>
              <th>Name</th> 
              <th>Description</th>
              <th>Price</th>
              <th>Quantity</th>
            </tr>
            <c:forEach var="product" items="${products}">   
            <tr>  
                <td>${product.id}</td>  
                <td>${product.tenSp}</td>  
                <td>${product.mieuTa}</td>  
                <td>${product.gia}</td>   
                <td>${product.soLuong}</td>
            </tr>  
            </c:forEach>  
        </table>
<!--        <button class="btn btn-default" onclick="window.location.href='viewPerInfo.htm'">View Personal Info</button>
        <button class="btn btn-default" onclick="window.location.href='logout.htm'">Logout</button>-->
    </body>
</html>
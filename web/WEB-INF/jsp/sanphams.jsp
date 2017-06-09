<%-- 
    Document   : sanphams
    Created on : Jun 4, 2017, 8:58:58 AM
    Author     : VuQuang
--%>
<%@ page import=" model.dao.SanphamDAO"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script  src="/assests/js/bootstrap.min.js"></script>
<link href="<c:url value="/assests/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/assests/css/myCss.css" />" rel="stylesheet" type="text/css" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
              <div class="navbar-header">
                <a class="navbar-brand" href="products.htm">Product Management</a>
              </div>
              <ul class="nav navbar-nav">
                <li><a href="addProduct.htm">Add Product</a></li>
                <li><a href="editProduct.htm">Edit Product</a></li>
                <li><a href="logout.htm">Logout</a></li>
              </ul>
            </div>
        </nav>
        <h1>Product Management</h1>
        <form action="${pageContext.request.contextPath}/ProductServlet" method="post">
            <table class="table table-bordered">
                <tr>
                  <th>id</th>
                  <th>Name</th> 
                  <th>Description</th>
                  <th>Price</th>
                  <th>Quantity</th>
                  <th>
                    <button class="btn btn-primary" type="submit" name="btnXoa">Delete products</button>
                  </th>
                </tr>
                <c:forEach var="product" items="${products}">   
                <tr>  
                    <td>${product.id}</td>  
                    <td>${product.tenSp}</td>  
                    <td>${product.mieuTa}</td>  
                    <td>${product.gia}</td>   
                    <td>${product.soLuong}</td>
                    <td><div class="material-switch" style="margin-top: 10px;margin-left: 20px;">
                            <input id="${product.id}" name="checkboxXoa" type="checkbox" value="${product.id}"/>
                            <label for="${product.id}" class="label-default"></label>
                        </div>
                    </td>
                </tr>  
                </c:forEach>  
            </table>
        </form>
    </body>
</html>

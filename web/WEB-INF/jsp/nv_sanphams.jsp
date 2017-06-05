<%-- 
    Document   : nv_sanphams
    Created on : Jun 5, 2017, 11:35:35 PM
    Author     : VuQuang
--%>

<%@ page import=" model.dao.SanphamDAO"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
    </head>
    <body>
        <h1>Product List</h1>
        <table>
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
        <button onclick="window.location.href='viewPerInfo.htm'">View Personal Info</button>
        <button onclick="window.location.href='index.htm'">Logout</button>
    </body>
</html>
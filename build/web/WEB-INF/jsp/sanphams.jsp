<%-- 
    Document   : sanphams
    Created on : Jun 4, 2017, 8:58:58 AM
    Author     : VuQuang
--%>
<%@ page import=" model.dao.SanphamDAO"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
    </head>
    <body>
        <h1>Product Management</h1>
        <div style="display: inline">
            <button onclick="window.location.href='addProduct.htm'">Them</button>
            <button onclick="window.location.href='editProduct.htm'">Sua</button>
        </div>
        <form action="${pageContext.request.contextPath}/ProductServlet" method="post">
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
                    <td><input type="checkbox" name="checkboxXoa" value="${product.id}"></td>
                </tr>  
                </c:forEach>  
            </table>
            <input type="submit" name="btnXoa" value="Xoa" />
        </form>
        </div>
        <button onclick="window.location.href='index.htm'">Logout</button>
        
    </body>
</html>

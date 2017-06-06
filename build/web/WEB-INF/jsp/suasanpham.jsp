<%-- 
    Document   : suasanpham
    Created on : Jun 5, 2017, 3:20:06 PM
    Author     : VuQuang
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
    <head>
            <title>Edit product</title>
    </head>
    <body>
        <h2>Edit product</h2>
        <form method="POST" commandName="suasanpham">

            <table>
                <tr>
                        <td><label path="id">Product ID</label></td>
                        <td>
                            <select name="listIDProduct">
                                <c:forEach var="product" items="${products}"> 
                                    <option value="${product.id}">${product.id}</option>
                                </c:forEach>
                            </select>
                        </td> 
                </tr>
                <tr>
                        <td><label path="tenSp">Product Name</label></td>
                        <td><input type="text" name="tenSp"/></td> 
                </tr>
                <tr>
                        <td><label path="mieuTa">Description</label></td>
                        <td><input type="text" name="mieuTa"/></td>
                </tr>
                <tr>
                        <td><label path="gia">Price</label></td>
                        <td><input type="number" name="gia" /></td>
                </tr>
                <tr>
                        <td><label path="soLuong">Quantity</label></td>
                        <td><input type="number" name="soLuong" /></td>
                </tr>
                <tr>
                        <td colspan="2">
                                <input type="submit" value="Sua"/>
                        </td>
                </tr>
            </table>
        </form>	
        <button onclick="window.location.href='index.htm'">Logout</button>
    </body>
</html>

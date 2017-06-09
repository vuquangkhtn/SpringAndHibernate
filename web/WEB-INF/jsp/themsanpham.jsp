<%-- 
    Document   : themsanpham
    Created on : Jun 4, 2017, 2:58:05 PM
    Author     : VuQuang
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script  src="/assests/js/bootstrap.min.js"></script>
<link href="<c:url value="/assests/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
<!DOCTYPE html>
<html>
    <head>
            <title>Add product</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
              <div class="navbar-header">
                <a class="navbar-brand" href="products.htm">Product Management</a>
              </div>
              <ul class="nav navbar-nav">
                <li class="active"><a href="addProduct.htm">Add Product</a></li>
                <li><a href="editProduct.htm">Edit Product</a></li>
                <li><a href="logout.htm">Logout</a></li>
              </ul>
            </div>
        </nav>
        <h2>Add product</h2>
        <form style="width:30%;margin-left: 10%" method="POST" commandName="themsanpham">

            <div class="form-group">
                    <label path="tenSp">Product Name</label>
                    <input type="text" class="form-control" name="tenSp" required=""/> 
            </div>
            <div class="form-group">
                    <label path="mieuTa">Description</label>
                    <input type="text" class="form-control" name="mieuTa" required=""/>
            </div>
            <div class="form-group">
                    <label path="gia">Price</label>
                    <input type="number" class="form-control" name="gia" required="" />
            </div>
            <div class="form-group">
                    <label path="soLuong">Quantity</label>
                    <input type="number" class="form-control" name="soLuong" required="" />
            </div>

            <br>    
            <button class="btn btn-primary" type="submit" value="Them">Add product</button>
            <button  style="margin-left: 30px" class="btn btn-primary" onclick="window.location.href='products.htm'" value="Cancel">Cancel</button>
        </form>
    </body>
</html>

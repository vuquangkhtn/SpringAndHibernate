<%-- 
    Document   : nv_thongtincanhan
    Created on : Jun 5, 2017, 11:41:21 PM
    Author     : VuQuang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script  src="/assests/js/bootstrap.min.js"></script>
<link href="<c:url value="/assests/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal Information</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
              <div class="navbar-header">
                <a class="navbar-brand" href="viewProducts.htm">Product Management</a>
              </div>
              <ul class="nav navbar-nav">
                <li><a href="viewProducts.htm">Product List</a></li>
                <li class="active"><a href="viewPerInfo.htm">Personal Information</a></li>
                <li><a href="logout.htm">Logout</a></li>
              </ul>
            </div>
        </nav>
        <h1>Personal Information</h1>
        <table class="table">
            <tr>
                    <td><label path="idnhanvien">Staff ID:</label></td>
                    <td>${staff.idnhanvien}</td>
            </tr>
            <tr>
                    <td><label path="hoten">Full name:</label></td>
                    <td>${staff.hoten}</td>
            </tr>
            <tr>
                    <td><label path="tendn">Username:</label></td>
                    <td>${staff.tendn}</td>
            </tr>
        </table>
    </body>
</html>

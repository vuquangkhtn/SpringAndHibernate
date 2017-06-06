<%-- 
    Document   : nv_thongtincanhan
    Created on : Jun 5, 2017, 11:41:21 PM
    Author     : VuQuang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal Information</title>
    </head>
    <body>
        <h1>Personal Information</h1>
        <table>
            <tr>
                    <td><label path="idnhanvien">Staff ID:</label></td>
                    <td>${staff.idnhanvien}</td>
            </tr>
            <tr>
                    <td><label path="hoten">Full name:</label></td>
                    <td>${staff.hoten}</td>
            </tr>
            <tr>
                    <td><label path="tendangnhap">Username:</label></td>
                    <td>${staff.tendangnhap}</td>
            </tr>
        </table>
        <button onclick="window.location.href='viewProducts.htm'">View Products</button>
        <button onclick="window.location.href='index.htm'">Logout</button>
    </body>
</html>

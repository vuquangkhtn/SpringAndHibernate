<%-- 
    Document   : themsanpham
    Created on : Jun 4, 2017, 2:58:05 PM
    Author     : VuQuang
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<!DOCTYPE html>
<html>
    <head>
            <title>Add product</title>
    </head>
    <body>
    <h2>Add product</h2>
    <form method="POST" commandName="themsanpham">

        <table>
            <tr>
                    <td><label path="tensp">Product Name</label></td>
                    <td><input type="text" name="tenSp"/></td> 
            </tr>
            <tr>
                    <td><label path="mieuta">Description</label></td>
                    <td><input type="text" name="mieuTa"/></td>
            </tr>
            <tr>
                    <td><label path="gia">Price</label></td>
                    <td><input type="number" name="gia" /></td>
            </tr>
            <tr>
                    <td><label path="soluong">Quantity</label></td>
                    <td><input type="number" name="soLuong" /></td>
            </tr>
            <tr>
                    <td colspan="2">
                            <input type="submit" value="Them"/>
                    </td>
            </tr>
        </table>	

    </form>
    </body>
</html>

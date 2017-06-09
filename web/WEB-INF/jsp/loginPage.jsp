<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script  src="/assests/js/bootstrap.min.js"></script>
<link href="<c:url value="/assests/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
 
<html>
<head><title>Login</title></head>
<body>
     <!-- /login?error=true -->
     <c:if test="${param.error == 'true'}">
         <div style="color:red;margin:10px 0px;">
          
                Login Failed!!!<br />
                Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                 
         </div>
    </c:if>
       
     <div class="wrapper" style="width:30%; margin-left: 33%; margin-top: 10%">
        <form class="form-signin" name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
            <h2 class="form-signin-heading">Please login</h2>
            
            <input style="margin: 10px" class="form-control" type='text' name='username' placeholder="Username"  value='' autofocus="" required=""/>
             <input style="margin: 10px" class="form-control" type='password' name='password' placeholder="Password" required=""/>
             <button style="margin: 10px" class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="Login">Login</button>
            
        </form>
    </div>
</body>
</html>
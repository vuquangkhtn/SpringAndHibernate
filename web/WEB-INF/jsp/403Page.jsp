<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script  src="/assests/js/bootstrap.min.js"></script>
<link href="<c:url value="/assests/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
<%@page session="false"%>
<html>
<head>
    <title>Access Denied</title>
</head>
<body>
    <div class="container">
        <div class="row">
          <div class="span12">
            <div class="hero-unit center">
                <h1>Page Not Found <small><font face="Tahoma" color="red">Error 404</font></small></h1>
                <br />
                <h3>${message}</h3>
                <p>The page you requested is denied, either contact your webmaster or try again. Use your browsers <b>Back</b> button to navigate to the page you have prevously come from</p>
                
            </div>  
          </div>
        </div>
    </div>

</body>
</html>
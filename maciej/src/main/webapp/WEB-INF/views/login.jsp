<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<html ng-app="appModule">  
<head>  
	<title>Login Page</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/> 
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/signin.css"/> 
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/angular-toastr.css"/> 
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/angular.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/pie-chart.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/ui-bootstrap-tpls-0.13.0.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/angular-animate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/angular-toastr.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/angular-toastr.tpls.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/appAngular/app.module.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/appAngular/controller/login.ctrl.js"></script>
</head>  
<body ng-controller="loginController as loginCtrl">
   <div class="container">
   		<form class="form-signin" method="post" action="<c:url value='maciej/j_spring_security_check' />">  
  			<h2 class="form-signin-heading">Please sign in</h2>  
  			<input type="text" name="username" id="inputEmail" class="form-control" placeholder="Login" required="" autofocus="">
  			<input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required="">
  			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
   		</form>  
   </div>
</body>  
</html>  
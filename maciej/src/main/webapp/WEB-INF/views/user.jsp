<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<html ng-app="appModule">  
<head>  
	<title>Finance page</title> 
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/> 
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/carousel.css"/> 
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/angular-toastr.css"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/d3.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/angular.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/pie-chart.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/angular-animate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/angular-toastr.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/angular-toastr.tpls.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/ui-bootstrap-tpls-0.13.0.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/appAngular/app.module.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/appAngular/service/userSales.service.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/appAngular/controller/userSales.ctrl.js"></script>
</head>  
<body ng-controller="userSalesController as userSalesCtrl" ng-cloak>
  <c:url value="/j_spring_security_logout" var="logoutUrl" />   
    	<div class="jumbotron">
    		<div class="row">
    			<div class="col-md-6 col-md-offset-1">
    				<h1>Raport section </h1>
    			</div>
    			<div class="col-md-3 col-md-offset-2">
    				<p>{{userSalesCtrl.person.firstName + ' ' + userSalesCtrl.person.lastName}}</p>
    				<a href="${logoutUrl}" class="btn btn-primary">Logout</a>
    			</div>
    		</div>
    	</div>
    <br /><br />
    <div class="container">
    <div class="row">
    	<div class="col-md-5">
    		<div class="row"> 
    			<div class="col-md-6">
    				<h4>Item's on page:</h4>
    			</div> 
    			<div class="col-md-4">
    				<div class="btn-group" dropdown is-open="status.isopen" >
    					<button type="button" class="btn btn-primary dropdown-toggle" dropdown-toggle ng-disabled="disabled">
        					{{userSalesCtrl.itemsPerPage}} <span class="caret"></span>
      					</button>
      					<ul class="dropdown-menu" role="menu">
      						<li  ng-repeat="item in userSalesCtrl.pages"><a ng-click="userSalesCtrl.setSelectedPage(item)"  href="#">{{item}}</a></li>
      					</ul>
    				</div>
    			</div>
    		</div>
    		<br/>
    		<table class="table table-hover">
				<thead>
					<tr>
						<th>Sale Date:</th>
						<th>Amount</th>
					</tr>
				</thead>
				<tbody ng-repeat="item in userSalesCtrl.sales.sales">
					<tr>
						<td>{{item.saleDate | date:'yyyy-MM'}}</td>
						<td>{{item.amount}}</td>
					</tr>
				</tbody>
				<tr>
					<td>Total in row:</td>
					<td>{{userSalesCtrl.sales.totalAmountInRow}}</td>
				</tr>
			</table>
    		<div class="row">
    			<div class="col-md-10">
    				<pagination max-size="userSalesCtrl.maxSize" class="pagination-sm" boundary-links="true" total-items="userSalesCtrl.sales.countOfSales" ng-model="userSalesCtrl.currentPage" items-per-page="userSalesCtrl.itemsPerPage" ng-change="userSalesCtrl.getSales()"></pagination>
    			</div>
    		</div>
    		<div class="row">
    			<div class="col-md-6" style="text-align: center">
    				<button class="btn btn-primary" ng-click="userSalesCtrl.showFilters()">{{userSalesCtrl.filterTitle}}</button>
    			</div>
    			<div class="col-md-6" style="text-align: center">
    				<button class="btn btn-primary" ng-click="userSalesCtrl.refresh()">Refresh</button>
    			</div>
    				<div class="col-md-4" style="text-align: center">
    			</div>
    		</div>
    		<div collapse="userSalesCtrl.isCollapsed">
				<div class="well well-lg">
					<div class="row">
						<div class="col-md-6">
							Start Date:
							<p class="input-group">
								<input type="text" class="form-control" datepicker-popup ng-model="userSalesCtrl.startDate" ng-required="true" close-text="Close"
								is-open="userSalesCtrl.openedStart" max-date="userSalesCtrl.endDate" ng-change="userSalesCtrl.getSales()"/>
								<span class="input-group-btn">
                					<button type="button" class="btn btn-default" ng-click="userSalesCtrl.openCalendar($event,'startDate')"><i class="glyphicon glyphicon-calendar"></i></button>
              					</span>
							</p>
						</div>
						<div class="col-md-6">
							End Date:
							<p class="input-group">
								<input type="text" class="form-control" datepicker-popup ng-model="userSalesCtrl.endDate" ng-required="true" close-text="Close"
								is-open="userSalesCtrl.openedEnd" min-date='userSalesCtrl.startDate' ng-change="userSalesCtrl.getSales()"/>
								<span class="input-group-btn">
                					<button type="button" class="btn btn-default" ng-click="userSalesCtrl.openCalendar($event,'endDate')"><i class="glyphicon glyphicon-calendar"></i></button>
              					</span>
							</p>
						</div>
					</div>
				</div> 
			</div> 
    	</div>
    	<div class="col-md-5">
    		<h2>Total: {{userSalesCtrl.sales.totalAmount}}</h2>
    	</div>
    </div>
    </div>
</body>  
</html>  
(function(){
	var app = angular.module("appModule", ['ngAnimate', 'toastr','ui.bootstrap'])
	
	app.config(function ($locationProvider)
	{
	  $locationProvider.html5Mode(false).hashPrefix("!");
	});
})();
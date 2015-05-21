(function(){
	angular.module("appModule").controller("loginController",function($location,toastr) {
		var vm = this;
		angular.element(document).ready(function () {
	        var url = $location.absUrl();
	        if(url.indexOf('authfailed') > -1)
	        {
	        	toastr.error('Incorrect', 'Your entered values are incorrect, check and try again');
	        }
	        else if(url.indexOf('logout') > -1)
	        {
	        	toastr.success('Logout', 'You logout successfull!');
	        }
	    });
	});
})();
(function(){
	angular.module("appModule")
		.factory("userSalesService",['$http', function($http) {
			var getPerson = function(){
				return $http.post('/maciej/sales/userDescription', {headers: {'Content-Type': 'application/json'}});
			};
			var getSales = function(searchString){
				return $http.post('/maciej/sales/userSales',searchString, {headers: {'Content-Type': 'application/json'}});
			}
			return {
				getPerson: getPerson,
				getSales: getSales
			}
		}])
})();
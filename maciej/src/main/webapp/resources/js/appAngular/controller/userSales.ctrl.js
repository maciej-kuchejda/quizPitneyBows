(function(){
	angular.module("appModule").controller("userSalesController",['userSalesService','toastr',function(userSalesService,toastr){
		
		var vm = this;
		vm.startDate = new Date("2012-01-10");
		vm.endDate = new Date("2012-11-10");
		vm.currentPage = 1;
		vm.itemsPerPage = 2;
		vm.maxSize = 5;
		vm.totalItems = 0;
		vm.isCollapsed = true;
		vm.filterTitle = "Show filters";
		vm.pages = [2,5,10];
		vm.openCalendar = function($event,filter) {
		    $event.preventDefault();
		    $event.stopPropagation();
		    if(filter == "startDate"){
			    vm.openedStart = true;
		    }else{
			    vm.openedEnd = true;
		    }
		};
		vm.showFilters = function()
		{
			vm.isCollapsed = !vm.isCollapsed;
			if(vm.filterTitle == "Show filters"){
				vm.filterTitle = "Hide filters";
			}else{
				vm.filterTitle = "Show filters";
			}
		}
		vm.getPersonData = function(){
			userSalesService.getPerson().success(function(data){
				vm.person = data;
				toastr.success('Success', 'Data loaded successfull!',{
					progressBar: true,
					closeButton: true
				});
			}).error(function(data){
				toastr.error('Error occured', data,{
					progressBar: true,
					closeButton: true
				});
			});
	  };
	  vm.getSales = function(){
		  var data = {startDate: vm.startDate.toISOString().substring(0, 10), endDate: vm.endDate.toISOString().substring(0, 10), currentPage: vm.currentPage, itemsPerPage: vm.itemsPerPage};
		  userSalesService.getSales(data).success(function(data){
			  vm.sales = data;
		  }).error(function(data){
			  toastr.error('Error occured', data,{
					progressBar: true,
					closeButton: true
				});
		  });
	  };
	  vm.refresh = function(){
		  vm.getPersonData();
		  vm.getSales();
	  }
	  vm.setSelectedPage = function(page){
		  vm.itemsPerPage = page;
		  vm.getSales();
	  }
	  vm.getPersonData();
	  vm.getSales();
	}]);
})();
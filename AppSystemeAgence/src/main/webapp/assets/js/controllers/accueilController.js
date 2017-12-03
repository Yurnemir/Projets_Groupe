monApp.controller("accueilCtrl", function($scope, $rootScope, visiteProvider) {
	$scope.message = "Journal de bord";
	$scope.date = new Date();
	$scope.init = function(callBack) {
		
		visiteProvider.getListNextVisites($scope.date, function(callBack) {
			$scope.nextVisiteListeToday = callBack;
		});
		
//		var tomorrow = $scope.date.setDate(date.getDate+1);
//		visiteProvider.getListNextVisites(tomorrow, function(callBack) {
//			$scope.nextVisiteListeTomorrow = callBack;
//		});
//		
//		var afterTomorrow = tomorrow.setDate(date.getDate+1);
//		visiteProvider.getListNextVisites(afterTomorrow, function(callBack) {
//			$scope.nextVisiteListeAfterTomorrow = callBack;
//		});
	}
})

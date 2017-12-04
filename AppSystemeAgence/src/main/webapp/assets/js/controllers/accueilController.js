monApp.controller("accueilCtrl", function($scope, $cookies, $location,
		visiteProvider) {
	$scope.message = "Journal de bord";
	$scope.date = new Date();
	$scope.init = function(callBack) {

		visiteProvider.getListNextVisites($scope.date, function(callBack) {
			if (callBack != undefined && callBack != "") {
				$scope.nextVisiteListeToday = callBack;
			}else{
				$scope.messageVisite = "Aucune visite prévu pour aujourd'hui.";
			}
		});

		// var tomorrow = $scope.date.setDate(date.getDate+1);
		// visiteProvider.getListNextVisites(tomorrow, function(callBack) {
		// $scope.nextVisiteListeTomorrow = callBack;
		// });
		//		
		// var afterTomorrow = tomorrow.setDate(date.getDate+1);
		// visiteProvider.getListNextVisites(afterTomorrow, function(callBack) {
		// $scope.nextVisiteListeAfterTomorrow = callBack;
		// });
	}
	$scope.logout = function() {
		$cookies.remove("username");
		$cookies.remove("password");
		$location.path("/login");
	}
})

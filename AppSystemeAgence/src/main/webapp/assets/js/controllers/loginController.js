monApp.controller("loginCtrl", function($scope, $rootScope, $cookies, $location, agentProvider) {
	$scope.login = function() {
		agentProvider.getBienAchat($scope.username, $scope.password, function(callBack) {
			if (callBack!="") {
				$cookies.put("username", $scope.username);
				$cookies.put("password", $scope.password);
				$location.path("/accueil");
			}
		});
	}
});


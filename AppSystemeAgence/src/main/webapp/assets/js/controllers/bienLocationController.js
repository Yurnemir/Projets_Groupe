
monApp.controller("listeBiensLocationCtrl", function($scope, bienLocationProvider) {
	bienLocationProvider.getAllBiensLocation(function(callBack) {
		$scope.listeBiensLocation = callBack;
	});
});

monApp.controller("rechercheBienLocationCtrl", function($scope, bienLocationProvider) {
	$scope.displayResult = false;
	$scope.getBienLocationById = function() {
		bienLocationProvider.getBienLocationById($scope.idRecherche, function(callBack) {
			$scope.bienLocationTrouve = callBack;
			$scope.displayResult = true;
		});
	}
});

monApp.controller("ajoutBienLocationCtrl", function($scope, bienLocationProvider) {
	$scope.bienLocationForm = {
			nom:"",
			capitale:"",
			population:0
		}
		$scope.addBienAchat = function() {
			bienLocationProvider.addBienLocation($scope.bienLocationForm, function(callBack) {
				if (callBack!=undefined && callBack!="") {
					$location.path("listeBiensLocation");
				}
			});
		}
});

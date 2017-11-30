
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

monApp.controller("ajoutBienLocationCtrl", function($scope, $location, bienLocationProvider) {
	$scope.bienLocationForm = {
		id:undefined,
//		dateSoumission:undefined,
//		dateDispo:undefined,
		disponible:false,
		typeBien:1,
		loyer:0,
		caution:0,
		charges:0,
		meuble:false,
		typeBail:1
	}
	$scope.addBienLocation = function() {
		bienLocationProvider.addBienLocation($scope.bienLocationForm, function(callBack) {
			if (callBack!=undefined && callBack!="") {
				$location.path("listeBiensLocation");
			}
		});
	}
});

monApp.controller("modifBienLocationCtrl", function($scope, $location, bienLocationProvider) {
	$scope.bienLocationForm = {
		id:undefined,
//		dateSoumission:undefined,
//		dateDispo:undefined,
		disponible:false,
		typeBien:1,
		loyer:0,
		caution:0,
		charges:0,
		meuble:false,
		typeBail:1
	}
	$scope.updateBienLocation = function() {
		bienLocationProvider.updateBienLocation($scope.bienLocationForm, function(callBack) {
			if (callBack!=undefined && callBack!="") {
				$location.path("listeBiensLocation");
			}
		});
	}
});

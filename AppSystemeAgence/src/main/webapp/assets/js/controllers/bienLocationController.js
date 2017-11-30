
monApp.controller("listeBiensLocationCtrl", function($scope, $rootScope, $location, bienLocationProvider) {
	bienLocationProvider.getAllBiensLocation(function(callBack) {
		$scope.listeBiensLocation = callBack;
	});
	$scope.modifBienLocationViaLien = function(bienLocation) {
		$rootScope.bienLocationForm = {
			id:bienLocation.id,
			dateSoumission:bienLocation.dateSoumission,
			dateDispo:bienLocation.dateDispo,
			disponible:bienLocation.disponible,
			typeBien:bienLocation.typeBien,
			loyer:bienLocation.loyer,
			caution:bienLocation.caution,
			charges:bienLocation.charges,
			meuble:bienLocation.meuble,
			typeBail:bienLocation.typeBail
		};
		$location.path("modifBienLocation");
	}
	$scope.supprBienLocationViaLien = function(idSuppr) {
		bienLocationProvider.deleteBienLocation(idSuppr, function(callBack) {
			bienLocationProvider.getAllBiensLocation(function(callBack) {
				$scope.listeBiensLocation = callBack;
			});
		});
	}
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
	$scope.listeTypesBien = listeTypesBien;
	$scope.listeTypesBail = listeTypesBail;
	$scope.bienLocationForm = {
		id:undefined,
		dateSoumission:undefined,
		dateDispo:undefined,
		disponible:false,
		typeBien:0,
		loyer:0,
		caution:0,
		charges:0,
		meuble:false,
		typeBail:0
	}
	$scope.addBienLocation = function() {
		console.log($scope.bienLocationForm);
		bienLocationProvider.addBienLocation($scope.bienLocationForm, function(callBack) {
			if (callBack!=undefined && callBack!="") {
				$location.path("listeBiensLocation");
			}
		});
	}
});

monApp.controller("modifBienLocationCtrl", function($scope, $rootScope, $location, bienLocationProvider) {
	$scope.listeTypesBien = listeTypesBien;
	$scope.listeTypesBail = listeTypesBail;
	if ($rootScope.bienLocationForm == undefined) {
		$scope.bienLocationForm = {
			id:undefined,
			dateSoumission:undefined,
			dateDispo:undefined,
			disponible:false,
			typeBien:0,
			loyer:0,
			caution:0,
			charges:0,
			meuble:false,
			typeBail:0
		}
	} else {
		$scope.bienLocationForm = {
			id:$rootScope.bienLocationForm.id,
			dateSoumission:new Date($rootScope.bienLocationForm.dateSoumission),
			dateDispo:new Date($rootScope.bienLocationForm.dateDispo),
			disponible:$rootScope.bienLocationForm.disponible,
			typeBien:$rootScope.bienLocationForm.typeBien,
			loyer:$rootScope.bienLocationForm.loyer,
			caution:$rootScope.bienLocationForm.caution,
			charges:$rootScope.bienLocationForm.charges,
			meuble:$rootScope.bienLocationForm.meuble,
			typeBail:$rootScope.bienLocationForm.typeBail
		}
	}
	$scope.updateBienLocation = function() {
		bienLocationProvider.updateBienLocation($scope.bienLocationForm, function(callBack) {
			if (callBack!=undefined && callBack!="") {
				$location.path("listeBiensLocation");
			}
		});
	}
});


monApp.controller("listeBiensLocationCtrl", function($scope, $rootScope, $location, bienLocationProvider) {
	bienLocationProvider.getAllBiensLocation(function(callBack) {
		$scope.listeBiensLocation = callBack;
	});
	$rootScope.bienLocationForm = {
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
	$scope.modifBienLocationViaLien = function(bienLocation) {
		$rootScope.bienLocationForm.id = bienLocation.id;
		$rootScope.bienLocationForm.dateSoumission = bienLocation.dateSoumission;
		$rootScope.bienLocationForm.dateDispo = bienLocation.dateDispo;
		$rootScope.bienLocationForm.disponible = bienLocation.disponible;
		$rootScope.bienLocationForm.typeBien = bienLocation.typeBien;
		$rootScope.bienLocationForm.loyer = bienLocation.loyer;
		$rootScope.bienLocationForm.caution = bienLocation.caution;
		$rootScope.bienLocationForm.charges = bienLocation.charges;
		$rootScope.bienLocationForm.meuble = bienLocation.meuble;
		$rootScope.bienLocationForm.typeBail = bienLocation.typeBail;
		$location.path("modifBienLocation");
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
			id:$rootScope.bienLocationForm.id,
			dateSoumission:$rootScope.bienLocationForm.dateSoumission,
			dateDispo:$rootScope.bienLocationForm.dateDispo,
			disponible:$rootScope.bienLocationForm.disponible,
			typeBien:$rootScope.bienLocationForm.typeBien,
			loyer:$rootScope.bienLocationForm.loyer,
			caution:$rootScope.bienLocationForm.caution,
			charges:$rootScope.bienLocationForm.charges,
			meuble:$rootScope.bienLocationForm.meuble,
			typeBail:$rootScope.bienLocationForm.typeBail
		}
	} else {
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
	}
	$scope.updateBienLocation = function() {
		bienLocationProvider.updateBienLocation($scope.bienLocationForm, function(callBack) {
			if (callBack!=undefined && callBack!="") {
				$location.path("listeBiensLocation");
			}
		});
	}
});

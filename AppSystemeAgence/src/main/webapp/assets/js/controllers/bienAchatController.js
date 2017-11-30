
monApp.controller("listeBiensAchatCtrl", function($scope, bienAchatProvider) {
	bienAchatProvider.getAllBiensAchat(function(callBack) {
		$scope.listeBiensAchat = callBack;
	});
});

monApp.controller("rechercheBienAchatCtrl", function($scope, bienAchatProvider) {
	$scope.displayResult = false;
	$scope.getBienAchatById = function() {
		bienAchatProvider.getBienAchatById($scope.idRecherche, function(callBack) {
			$scope.bienAchatTrouve = callBack;
			$scope.displayResult = true;
		});
	}
});

monApp.controller("ajoutBienAchatCtrl", function($scope, $location, bienAchatProvider) {
	$scope.bienAchatForm = {
		id:undefined,
//		dateSoumission:undefined,
//		dateDispo:undefined,
		disponible:false,
		typeBien:1,
		etatBien:1,
		prixVente:0
	}
	$scope.addBienAchat = function() {
		bienAchatProvider.addBienAchat($scope.bienAchatForm, function(callBack) {
			if (callBack!=undefined && callBack!="") {
				$location.path("listeBiensAchat");
			}
		});
	}
});

monApp.controller("modifBienAchatCtrl", function($scope, $location, bienAchatProvider) {
	$scope.bienAchatForm = {
		id:undefined,
		dateSoumission:undefined,
		dateDispo:undefined,
		disponible:false,
		typeBien:1,
		etatBien:1,
		prixVente:0
	}
	$scope.updateBienAchat = function() {
		bienAchatProvider.updateBienAchat($scope.bienAchatForm, function(callBack) {
			if (callBack!=undefined && callBack!="") {
				$location.path("listeBiensAchat");
			}
		});
	}
});

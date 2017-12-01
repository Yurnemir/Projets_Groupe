
monApp.controller("listeBiensAchatCtrl", function($scope, $rootScope, $location, bienAchatProvider) {
	bienAchatProvider.getAllBiensAchat(function(callBack) {
		$scope.listeBiensAchat = callBack;
	});
	$scope.modifBienAchatViaLien = function(bienAchat) {
		$rootScope.bienAchatForm = {
			id:bienAchat.id,
			dateSoumission:bienAchat.dateSoumission,
			dateDispo:bienAchat.dateDispo,
			disponible:bienAchat.disponible,
			typeBien:bienAchat.typeBien,
			etatBien:bienAchat.etatBien,
			prixVente:bienAchat.prixVente
		};
		$location.path("modifBienAchat");
	}
	$scope.supprBienAchatViaLien = function(idSuppr) {
		bienAchatProvider.deleteBienAchat(idSuppr, function(callBack) {
			bienAchatProvider.getAllBiensAchat(function(callBack) {
				$scope.listeBiensAchat = callBack;
			});
		});
	}
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
	$scope.listeTypesBien = listeTypesBien;
	$scope.listeEtatsBien = listeEtatsBien;
	$scope.bienAchatForm = {
		id:undefined,
		dateSoumission:undefined,
		dateDispo:undefined,
		disponible:false,
		typeBien:0,
		etatBien:0,
		prixVente:0
	}
	$scope.addBienAchat = function() {
		bienAchatProvider.addBienAchat($scope.bienAchatForm, $scope.idProp, function(callBack) {
			if (callBack!=undefined && callBack!="") {
				$location.path("listeBiensAchat");
			}
		});
	}
});

monApp.controller("modifBienAchatCtrl", function($scope, $rootScope, $location, bienAchatProvider) {
	$scope.listeTypesBien = listeTypesBien;
	$scope.listeEtatsBien = listeEtatsBien;
	if ($rootScope.bienAchatForm == undefined) {
		$scope.bienAchatForm = {
			id:undefined,
			dateSoumission:undefined,
			dateDispo:undefined,
			disponible:false,
			typeBien:0,
			etatBien:0,
			prixVente:0
		}
	} else {
		$scope.bienAchatForm = {
			id:$rootScope.bienAchatForm.id,
			dateSoumission:new Date($rootScope.bienAchatForm.dateSoumission),
			dateDispo:new Date($rootScope.bienAchatForm.dateDispo),
			disponible:$rootScope.bienAchatForm.disponible,
			typeBien:$rootScope.bienAchatForm.typeBien,
			etatBien:$rootScope.bienAchatForm.etatBien,
			prixVente:$rootScope.bienAchatForm.prixVente
		}
	}
	$scope.updateBienAchat = function() {
		bienAchatProvider.updateBienAchat($scope.bienAchatForm, $scope.idProp, function(callBack) {
			if (callBack!=undefined && callBack!="") {
				$location.path("listeBiensAchat");
			}
		});
	}
});

monApp.controller("listeVisitesCtrl", function($scope, visiteProvider) {
	$scope.message = "listeVisitesCtrl";

	// Appel de la fonction visiteProvider
	visiteProvider.getAllVisites(function(callBack) {
		// Passer la liste des visites dans le scope
		$scope.visiteListe = callBack;
	})
});

monApp.controller("rechercheVisiteCtrl", function($scope, visiteProvider) {
	$scope.message = "rechercheVisiteCtrl";

	$scope.displayResult = false;
	$scope.idRecherche = undefined;
	$scope.getVisiteById = function() {
		visiteProvider.getVisiteById($scope.idRecherche, function(callBack) {
			if(callBack != undefined && callBack != ""){
				$scope.displayResult = true;
				$scope.visiteGet = callBack;
			}else{
				console.log("Cette visite n'existe pas.")
			}
		})
	}
});

monApp.controller("ajoutVisiteCtrl", function($scope, $location, visiteProvider) {
	$scope.visiteForm = {
		date : undefined,
		heure : undefined,
		bien : null,
		client : null
	}
	$scope.idBien = undefined;
	$scope.idClient = undefined;
	$scope.addVisite = function() {
		console.log($scope.visiteForm);
		visiteProvider.addVisite($scope.visiteForm, $scope.idClient, $scope.idBien, function(callBack) {
			if(callBack != undefined && callBack != "") {
				$location.path("listeVisites");
			}
		});
	}
	
});

monApp.controller("modifVisiteCtrl", function($scope, $location, visiteProvider) {
	$scope.visiteForm = {
		id : undefined,
		date : undefined,
		heure : undefined,
		bien : null,
		client : null
	}
	$scope.idBien = undefined;
	$scope.idClient = undefined;
	$scope.updateVisite = function() {
		console.log($scope.visiteForm);
		visiteProvider.updateVisite($scope.visiteForm, $scope.idClient, $scope.idBien, function(callBack) {
			if(callBack != undefined && callBack != "") {
				$location.path("listeVisites");
			}
		});
	}
	
});

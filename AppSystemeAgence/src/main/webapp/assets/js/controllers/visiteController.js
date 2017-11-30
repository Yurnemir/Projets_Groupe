
monApp.controller("listeVisitesCtrl", function($scope, visiteProvider) {
	$scope.message = "listeVisitesCtrl";
	
	// Appel de la fonction visiteProvider
	visiteProvider.getAllVisites(function(callBack){
		// Passer la liste des visites dans le scope
		$scope.visiteListe = callBack;
	})
});

monApp.controller("rechercheVisiteCtrl", function($scope, visiteProvider) {
	$scope.message = "rechercheVisiteCtrl";
});

monApp.controller("ajoutVisiteCtrl", function($scope, visiteProvider) {
	$scope.message = "ajoutVisiteCtrl";
});

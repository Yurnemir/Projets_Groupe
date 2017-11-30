monApp.controller("listeContratsCtrl", function($scope, contratProvider,$location) {


	// appel de la fonction de contratProvider
	contratProvider.getAllContrats(function(callBack) {

		// passer la liste des pays dans le scope
		$scope.contratsListe = callBack;

	});
});

monApp.controller("rechercheContratCtrl", function($scope, contratProvider) {


	$scope.idRecherche = undefined;
	$scope.contratRech = {
		id : undefined,
		dateSignature : undefined, 
		client : undefined,
		bien : undefined

	}

	$scope.rechercher = function() {

		// appel de la fonction de paysProvider pour modifier le pays dans la
		// base de données
		contratProvider.getContratById($scope.idRecherche, function(callBack) {

			if (callBack != undefined && callBack != "") {
				// si tout se passe bien aller dans la vue listeContrats.html et
				// actualiser la liste
				$scope.indice = true; // pour montrer la table ou pas
				$scope.contratRech = callBack;
				$scope.message= "";

			} else {
				$scope.indice = false;
				$scope.message = "Ce contrat n'existe pas";
			}

		});
	}

});

monApp.controller("ajoutContratCtrl", function($scope, contratProvider, $location) {

	// déclaration d'une variable dans le scope pour initialiser le formulaire
	$scope.contratForm={
			id : undefined,
			dateSignature : undefined, 
			client : undefined,
			bien : undefined
	}
	
	// développement de la méthode ajouter
	$scope.ajouter= function(){
		
		// appel de la fonction de contratProvider pour ajouter le contrat dans la
		// base de données
		contratProvider.addContrat($scope.contratForm, function(callBack){
			
			if (callBack !=undefined && callBack !="") {
				// si tout se passe bien aller dans la vue listeContrats.html et
				// actualiser la liste
				$location.path("listeContrats");
			}
			
		});
	}
	
});

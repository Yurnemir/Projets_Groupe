
monApp.controller("listeProprietairesCtrl", function($scope, proprietaireProvider) {
	proprietaireProvider.getAllProprietaires(function(callBack) {
		$scope.listeProprio = callBack;
	})
});

monApp.controller("rechercheProprietaireCtrl", function($scope, proprietaireProvider) {
	idRecherche="";
	$scope.rechercherProprio = function(){
		console.log("Recherche")
		proprietaireProvider.getProprietaireById($scope.idRecherche,function(callBack){
			$scope.proprioChercher=callBack;
		})
	}
	
});

monApp.controller("ajoutProprietaireCtrl", function($scope, proprietaireProvider,$location) {
	proprioAjout={
			nom:"",
			telPrive:"",
			telTravail:"",
			adresse : {
					numero:"",
					rue:"",
					cp:"",
					ville:""
			}
	}
	
	$scope.ajouterProprio = function (){
		proprietaireProvider.addProprietaire($scope.proprioAjout,function(callBack){
			if(callBack!=undefined && callBack!="") {
				console.log("Ajout effectué")
				$location.path("/listeProprietaires");
			} else {
				console.log("Ajout impossible");
			}
		})
	}
	

	
	
});

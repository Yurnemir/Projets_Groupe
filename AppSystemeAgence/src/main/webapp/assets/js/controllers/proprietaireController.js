
monApp.controller("listeProprietairesCtrl", function($scope, proprietaireProvider) {
	$scope.message = "listeProprietairesCtrl";
	proprietaireProvider.getAllProprietaires(function(callBack) {
		$scope.listeProprio = callBack;
	})
});

monApp.controller("rechercheProprietaireCtrl", function($scope, proprietaireProvider) {
	$scope.message = "rechercheProprietaireCtrl";
	
	idRecherche="";
	
	$scope.rechercherProprio = function(){
		console.log("Recherche")
		proprietaireProvider.getProprietaireById($scope.idRecherche,function(callBack){
			$scope.proprioChercher=callBack;
		})
	}
	
});

monApp.controller("ajoutProprietaireCtrl", function($scope, proprietaireProvider,$location) {
	$scope.message = "ajoutProprietaireCtrl";
	
	proprioAjout={
			nom:"",
			telPrive:"",
			telTravail:""
	}
	
	$scope.ajouterProprio = function (){
		console.log("Lancement")
		proprietaireProvider.addProprietaire($scope.proprioAjout,function(callBack){
				if(callBack!=undefined && callBack!=""){
				//Si tous ce passe bien aller dans la vue findAll.hmtl (listePays) et actualiser la liste .
				console.log("Ajout effectué")
				$location.path("/listeProprietaires");
			}else{
				console.log("Ajout impossible")
			}

		})
	}
	

	
	
});

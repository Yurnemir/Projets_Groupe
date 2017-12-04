
monApp.factory("proprietaireProvider", function($http) {
	var urlRacine = "http://localhost:8080/AppSystemeAgence";
	
	function getAllProprietairesFunction(callBack) {
		console.log("----- Liste des propriétaires ------");

		
		$http({
			method: "GET",
			url:urlRacine+"/listeProp",
		}).then(function success(response){
			console.log(response.data);

			callBack(response.data);

		},function error(response){
			console.log("----- Erreur ------");
			console.log(response.statusText);

		});
		
	}
	
	function getProprietaireByIdFunction(id,callBack) {

		$http({
			method: "GET",
			url:urlRacine+"/prop?pId="+id,
		}).then(function success(response){
			console.log(response.data);

			callBack(response.data);

		},function error(response){
			console.log("----- Erreur ------");
			console.log(response.statusText);

		});

	}
	
	function addProprietaireFunction(proprietaire,callBack) {
		console.log("----- Propriétaire à ajouter ------");
		$http({
			method: "POST",
			url:urlRacine+"/prop",
			data:angular.toJson(proprietaire),
			headers:{
				'content-type' : 'application/json',
					'charset':'utf-8'
			}
		}).then(function success(responseWS) {
			console.log(responseWS.data);
			callBack(responseWS.data);
		}),function echec(responseWS){
			console.log("----Erreur dans l'ajout")
			console.log(response.statusText);
		}
	}
	
	function supprimerProprietaire(id,callBack){
		$http({
			method: "DELETE",
			url : urlRacine+"/prop?pId="+id
		}).then(function success(response){
			console.log("Suppression effectuée")
			callBack(response.data);
		}),function error(response){
			console.log("----Erreur dans la suppression")
			console.log(response.statusText);

		}
		
	}
	
	return {
		getAllProprietaires:getAllProprietairesFunction,
		getProprietaireById:getProprietaireByIdFunction,
		addProprietaire:addProprietaireFunction,
		supprimer : supprimerProprietaire
	}
});

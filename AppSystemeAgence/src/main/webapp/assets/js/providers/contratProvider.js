
monApp.factory("contratProvider", function($http) {
	var urlRacine = "http://localhost:8080/AppSystemeAgence";
	
	
	// récuperer la liste des contrats
	function getAllContratsFunction(callBack) {
		// envoyer la requete au web service
		$http({
			method:'GET',
			url : urlRacine+'/listeContrats'
		}).then(function success(reponse){
			
			// la fonction dans le cas success
			console.log(reponse.data)
		
			// faire passer la réponse du web service au controller
			callBack(reponse.data);
			
			
		}, function error(response){
			
			// la promise en cas d'échec (ce qu'il doit faire en cas d'échec)
			console.log("--------Erreur : " + reponse.statusText)
			
			
		});
		
		
	}
	
	// récuperer un contrat par son id
	function getContratByIdFunction(idRech, callBack) {
		
		// appel du WS via $http
		$http({
			method:"GET",
			url :  urlRacine +'/getContrat/'+idRech
			
			
		}).then(function success(responseWS) {
			console.log(responseWS.data);
			callBack(responseWS.data); 
		}, function echec(responseWS) {
			console.log("--------Erreur : " + responseWS.statusText)

		});
		
	}
	
	function addContratFunction(contratAjout, idCl, idB, callBack) {
		// appel du web service via le $http
		$http({
			method : 'POST',
			url : urlRacine+'/addContrat/'+idCl+'/'+idB,
			data : angular.toJson(contratAjout),
			headers : {
				'content-type':'application/json'
			}
			
		}).then(function success(responseWS) {
			console.log(responseWS.data);
			callBack(responseWS.data); 
		}, function echec(responseWS) {
			console.log("--------Erreur : " + responseWS.statusText)

		});
	}
	
	return {
		getAllContrats:getAllContratsFunction,
		getContratById:getContratByIdFunction,
		addContrat:addContratFunction
	}
});

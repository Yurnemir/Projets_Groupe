
monApp.factory("visiteProvider", function($http) {
	var urlRacine = "http://localhost:8080/AppSystemeAgence";
	
	function getAllVisitesFunction(callBack) {
		// Envoyer la requete au webService
		$http({
			method: 'GET',
			url: urlRacine + '/listeVisites'
		}).then(function success(reponse){
			// La fonction en cas de success
			console.log(reponse.data);
			
			// Passer la reponse du web service au controller
			callBack(reponse.data);
		}, function error(reponse){
			// La promise en cas d'echec
			console.log("---- Error : "+reponse.statusText)
		});
	}
	
	function getVisiteByIdFunction(callBack) {
	}
	
	function addVisiteFunction(callBack) {
	}
	
	return {
		getAllVisites:getAllVisitesFunction,
		getVisiteById:getVisiteByIdFunction,
		addVisite:addVisiteFunction
	}
});

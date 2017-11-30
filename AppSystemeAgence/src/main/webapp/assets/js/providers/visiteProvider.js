
monApp.factory("visiteProvider", function($http) {
	var urlRacine = "http://localhost:8080/AppSystemeAgence";
	
	function getAllVisitesFunction(callBack) {
		$http({
			method: 'GET',
			url: urlRacine + '/listeVisites'
		}).then(function success(reponse){
			console.log(reponse.data);
			callBack(reponse.data);
		}, function error(reponse){
			console.log("---- Error : " + reponse.statusText)
		});
	}
	
	function getVisiteByIdFunction(idRech, callBack) {
		$http({
			method:'GET',
			url: urlRacine + '/visite?pId=' + idRech
		}).then(function success(reponse){
			console.log(reponse.data);
			callBack(reponse.data);
		}, function error(reponse){
			console.log("---- Error : " + reponse.statusText)
		});
	}
	
	function addVisiteFunction(visiteAjout, callBack) {
		$http({
			method : 'POST',
			url : urlRacine + '/visite',
			data : angular.toJson(visiteAjout),
			headers: {
				'content-type': 'application/json'
			}
		}).then(function success(reponse){
			console.log(reponse.data);
			callBack(reponse.data);
		}, function error(reponse){
			console.log("---- Error : "+reponse.statusText)
		});
	}
	
	return {
		getAllVisites:getAllVisitesFunction,
		getVisiteById:getVisiteByIdFunction,
		addVisite:addVisiteFunction
	}
});

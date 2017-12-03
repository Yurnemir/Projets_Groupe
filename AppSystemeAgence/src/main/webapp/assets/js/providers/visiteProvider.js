
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
	
	function getAllVisitesByClientFunction(idClient,callBack) {
		$http({
			method: 'GET',
			url: urlRacine + '/listeVisitesByClient?idClient='+idClient
		}).then(function success(reponse){
			console.log(reponse.data);
			callBack(reponse.data);
		}, function error(reponse){
			console.log("---- Error : " + reponse.statusText)
		});
	}

	function getAllVisitesByAgentFunction(idAgent,callBack) {
		//A MODIFIER
		$http({
			method: 'GET',
			url: urlRacine + '/listeVisites?idAgent'+idAgent
		}).then(function success(reponse){
			console.log(reponse.data);
			callBack(reponse.data);
		}, function error(reponse){
			console.log("---- Error : " + reponse.statusText)
		});
	}
	
	function getAllVisitesByBienAchatFunction(idBien,callBack) {
		// A MODIFIER
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
	
	function getAllVisitesByBienLocationFunction(idBien,callBack) {
		// A MODIFIER
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
	
	function getAllVisitesByDateFunction(date,callBack) {
		// A MODIFIER
		$http({
			method: 'GET',
			url: urlRacine + '/listeVisitesByDate',
			data:angular.toJson(date),
			headers:{
				"Content-Type":"application/json"
			}
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
	
	function addVisiteFunction(visiteAjout, idcl, idb, callBack) {
		$http({
			method : 'POST',
			url : urlRacine + '/visite?pIdcl=' + idcl + '&pIdb=' + idb,
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
	
	function updateVisiteFunction(visiteUpdate, idcl, idb, callBack) {
		$http({
			method : 'PUT',
			url : urlRacine + '/visite?pIdcl=' + idcl + '&pIdb=' + idb,
			data : angular.toJson(visiteUpdate),
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
	
	function deleteVisiteFunction(idDel, callBack) {
		$http({
			method : 'DELETE',
			url : urlRacine + '/visite?pId=' + idDel
		}).then(function success(reponse){
			console.log(reponse.data);
			callBack(reponse.data);
		}, function error(reponse){
			console.log("---- Error : "+reponse.statusText)
		});
	}
	
	function getListNextVisitesFunction(date, callBack) {
		$http({
			method: 'GET',
			url: urlRacine + '/listNextVisites'
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
		addVisite:addVisiteFunction,
		updateVisite:updateVisiteFunction,
		deleteVisite:deleteVisiteFunction,
		getListNextVisites:getListNextVisitesFunction
	}
});

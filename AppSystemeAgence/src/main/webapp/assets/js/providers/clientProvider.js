
monApp.factory("clientProvider", function($http) {
	var urlRacine = "http://localhost:8080/AppSystemeAgence";
	
	function getAllClientsFunction(callBack) {
		//envoi de la requete
		$http({
			method:'GET',
			url:urlRacine+"/client/all"
		}).then(function success(response){
			console.log(response.data);
			
			callBack(response.data);
		},function error(response){
			console.log("----- Erreur:"+response.statusText)
		});
	}
	
	function getClientByIdFunction(id,callBack) {
		$http({
			method:'GET',
			url:urlRacine+"/client/getById?clientID="+id
		}).then(function success(response){
			console.log(response.data);
			callBack(response.data);
		},function error(response){
			console.log("----- Erreur:"+response.statusText);
		});
	}
	
	function addClientFunction(client,idAgent,callBack) {
		$http({
			method:'POST',
			url:urlRacine+"/client/add?agentID="+idAgent,
			headers:{
				"Content-Type":"application/json"
			},
			data:angular.toJson(client)
		}).then(function success(response){
			callBack(response.data);
		},function error(response){
			console.log("----- Erreur:"+response.statusText);
		});
	}
	
	function modifClientFunction(client,idAgent,callBack){
		$http({
			method:'PUT',
			url:urlRacine+"/client/update?agentID="+idAgent,
			headers:{
				"Content-Type":"application/json"
			},
			data:angular.toJson(client)
		}).then(function succes(response){
			callBack(response.data);
		},function error(response){
			console.log("----- Erreur:"+response.statusText);
		});
	}
	
	return {
		getAllClients:getAllClientsFunction,
		getClientById:getClientByIdFunction,
		addClient:addClientFunction,
		modifClient:modifClientFunction
	}
});

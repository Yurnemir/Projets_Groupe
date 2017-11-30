
monApp.factory("clientProvider", function($http) {
	var urlRacine = "http://localhost:8080/AppSystemeAgence";
	
	function getAllClientsFunction(callBack) {
	}
	
	function getClientByIdFunction(callBack) {
	}
	
	function addClientFunction(callBack) {
	}
	
	return {
		getAllClients:getAllClientsFunction,
		getClientById:getClientByIdFunction,
		addClient:addClientFunction
	}
});

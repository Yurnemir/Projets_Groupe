
monApp.factory("contratProvider", function($http) {
	var urlRacine = "http://localhost:8080/AppSystemeAgence";
	
	function getAllContratsFunction(callBack) {
	}
	
	function getContratByIdFunction(callBack) {
	}
	
	function addContratFunction(callBack) {
	}
	
	return {
		getAllContrats:getAllContratsFunction,
		getContratById:getContratByIdFunction,
		addContrat:addContratFunction
	}
});

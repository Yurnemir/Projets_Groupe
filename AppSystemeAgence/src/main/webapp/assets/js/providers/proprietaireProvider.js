
monApp.factory("proprietaireProvider", function($http) {
	var urlRacine = "http://localhost:8080/AppSystemeAgence";
	
	function getAllProprietairesFunction(callBack) {
	}
	
	function getProprietaireByIdFunction(callBack) {
	}
	
	function addProprietaireFunction(callBack) {
	}
	
	return {
		getAllProprietaires:getAllProprietairesFunction,
		getProprietaireById:getProprietaireByIdFunction,
		addProprietaire:addProprietaireFunction
	}
});

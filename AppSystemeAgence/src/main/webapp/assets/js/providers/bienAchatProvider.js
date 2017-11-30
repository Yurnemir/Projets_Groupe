
monApp.factory("bienAchatProvider", function($http) {
	var urlRacine = "http://localhost:8080/AppSystemeAgence";
	
	function getAllBiensAchatFunction(callBack) {
		$http({
			method: "GET",
			url: urlRacine + "/bien/achat/liste"
		}).then(function success(response) {
			callBack(response.data);
		}, function error(response) {
			console.log("error : " + response.statusText);
		});
	}
	
	function getBienAchatByIdFunction(idRecherche, callBack) {
		$http({
			method: "GET",
			url: urlRacine + "/bien/achat?pId=" + idRecherche
		}).then(function success(response) {
			callBack(response.data);
		}, function error(response) {
			console.log("error : " + response.statusText);
		});
	}
	
	function addBienAchat(bienAchatForm, callBack) {
		$http({
			method: "POST",
			url: paysRestURL + "/bien/achat",
			data:angular.toJson(bienAchatForm),
			headers:{
				"content-type":"application/json"
			}
		}).then(function success(response) {
			callBack(response.data);
		}, function error(response) {
			console.log("error : " + response.statusText);
		});
	}
	
	return {
		getAllBiensAchat:getAllBiensAchatFunction,
		getBienAchatById:getBienAchatByIdFunction,
		addBienAchat:addBienAchatFunction
	}
});

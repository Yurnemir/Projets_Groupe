
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
	
	function addBienAchatFunction(bienAchatForm, idProp, callBack) {
		$http({
			method: "POST",
			url: urlRacine + "/bien/achat?pIdProp=" + idProp,
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
	
	function updateBienAchatFunction(bienAchatForm, idProp, callBack) {
		$http({
			method: "PUT",
			url: urlRacine + "/bien/achat?pIdProp=" + idProp,
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
	
	function deleteBienAchatFunction(idSuppr, callBack) {
		$http({
			method: "DELETE",
			url: urlRacine + "/bien/achat?pId=" + idSuppr,
		}).then(function success(response) {
			callBack(response.data);
		}, function error(response) {
			console.log("error : " + response.statusText);
		});
	}
	
	return {
		getAllBiensAchat:getAllBiensAchatFunction,
		getBienAchatById:getBienAchatByIdFunction,
		addBienAchat:addBienAchatFunction,
		updateBienAchat:updateBienAchatFunction,
		deleteBienAchat:deleteBienAchatFunction
	}
});

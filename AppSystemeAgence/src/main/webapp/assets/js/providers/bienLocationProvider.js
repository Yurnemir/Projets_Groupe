
monApp.factory("bienLocationProvider", function($http) {
	var urlRacine = "http://localhost:8080/AppSystemeAgence";
	
	function getAllBiensLocationFunction(callBack) {
		$http({
			method: "GET",
			url: urlRacine + "/bien/location/liste"
		}).then(function success(response) {
			callBack(response.data);
		}, function error(response) {
			console.log("error : " + response.statusText);
		});
	}

	function getBienLocationByIdFunction(idRecherche, callBack) {
		$http({
			method: "GET",
			url: urlRacine + "/bien/location?pId=" + idRecherche
		}).then(function success(response) {
			callBack(response.data);
		}, function error(response) {
			console.log("error : " + response.statusText);
		});
	}

	function addBienLocationFunction(bienLocationForm, callBack) {
		$http({
			method: "POST",
			url: urlRacine + "/bien/location",
			data:angular.toJson(bienLocationForm),
			headers:{
				"content-type":"application/json"
			}
		}).then(function success(response) {
			callBack(response.data);
		}, function error(response) {
			console.log("error : " + response.statusText);
		});
	}
	
	function updateBienLocationFunction(bienLocationForm, callBack) {
		$http({
			method: "PUT",
			url: urlRacine + "/bien/location",
			data:angular.toJson(bienLocationForm),
			headers:{
				"content-type":"application/json"
			}
		}).then(function success(response) {
			callBack(response.data);
		}, function error(response) {
			console.log("error : " + response.statusText);
		});
	}
	
	function deleteBienLocationFunction(idSuppr, callBack) {
		$http({
			method: "DELETE",
			url: urlRacine + "/bien/location?pId=" + idSuppr,
		}).then(function success(response) {
			callBack(response.data);
		}, function error(response) {
			console.log("error : " + response.statusText);
		});
	}
	
	return {
		getAllBiensLocation:getAllBiensLocationFunction,
		getBienLocationById:getBienLocationByIdFunction,
		addBienLocation:addBienLocationFunction,
		updateBienLocation:updateBienLocationFunction,
		deleteBienLocation:deleteBienLocationFunction
	}
});

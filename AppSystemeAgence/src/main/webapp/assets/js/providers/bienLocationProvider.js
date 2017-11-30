
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

	function addBienLocation(bienLocationForm, callBack) {
		$http({
			method: "POST",
			url: paysRestURL + "/bien/location",
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
	
	return {
		getAllBiensLocation:getAllBiensLocationFunction,
		getBienLocationById:getBienLocationByIdFunction,
		addBienLocation:addBienLocationFunction
	}
});

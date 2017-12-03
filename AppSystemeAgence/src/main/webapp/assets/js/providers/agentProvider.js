
monApp.factory("agentProvider", function($http) {
	var urlRacine = "http://localhost:8080/AppSystemeAgence";
	
	function getBienAchatFunction(username, password, callBack) {
		$http({
			method: "GET",
			url: urlRacine + "/agent?pUsername=" + username + "&pPassword=" + password
		}).then(function success(response) {
			callBack(response.data);
		}, function error(response) {
			console.log("error : " + response.statusText);
		});
	}
	
	return {
		getBienAchat:getBienAchatFunction
	}
});

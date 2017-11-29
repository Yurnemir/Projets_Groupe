var monApp = angular.module("monApp", ["ngRoute"]);

monApp.config(function($routeProvider) {
	$routeProvider.when("/listeBiensAchat", {
		templateUrl: "views/listeBiensAchat.html",
		controller: "listeBiensAchatCtrl"
	}).otherwise({
		redirectTo: "/listeBiensAchat"
	});
});

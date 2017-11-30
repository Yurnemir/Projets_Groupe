
monApp.controller("listeBiensAchatCtrl", function($scope, bienAchatProvider) {
	bienAchatProvider.getAllBiensAchat(function(callBack) {
		$scope.listeBiensAchat = callBack;
	});
});

monApp.controller("rechercheBienAchatCtrl", function($scope, bienAchatProvider) {
	$scope.displayResult = false;
	$scope.getBienAchatById = function() {
		bienAchatProvider.getBienAchatById($scope.idRecherche, function(callBack) {
			$scope.bienAchatTrouve = callBack;
			$scope.displayResult = true;
		});
	}
});

monApp.controller("ajoutBienAchatCtrl", function($scope, bienAchatProvider) {
	$scope.bienAchatForm = {
		nom:"",
		capitale:"",
		population:0
	}
	$scope.addBienAchat = function() {
		bienAchatProvider.addBienAchat($scope.bienAchatForm, function(callBack) {
			if (callBack!=undefined && callBack!="") {
				$location.path("listeBiensAchat");
			}
		});
	}
});

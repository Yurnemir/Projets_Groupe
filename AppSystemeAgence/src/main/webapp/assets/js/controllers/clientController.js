
monApp.controller("listeClientsCtrl", function($scope, clientProvider) {
	
	clientProvider.getAllClients(function(callBack){
		$scope.listeClients = callBack;
	});
});

monApp.controller("rechercheClientCtrl", function($scope, clientProvider) {
	
	$scope.clientFound = false;
	$scope.clientID = 0;
	
	$scope.recherche = function(){
		clientProvider.getClientById($scope.clientID,function(callBack){
			if (callBack!=undefined && callBack != ""){
				$scope.client=callBack;
				$scope.clientFound = true;		
			} else {
				$scope.clientFound = false;
			}
		});
	};
});

monApp.controller("ajoutClientCtrl", function($scope, clientProvider) {
	$scope.message = "";
	
	$scope.client={
			nom : "",
			telephone : ""
	};
	$scope.clientCreated = false;
	
	$scope.agentID = 0;
	
	$scope.ajout = function(){
		clientProvider.addClient($scope.client,$scope.agentID,function(callBack){
			if(callBack!=undefined && callBack != ""){
				$scope.client = callBack;
				$scope.clientCreated = true;
				$scope.message = "";
			} else {
				$scope.clientCreated = false;
				$scope.message="Pas de Client créé";
			}
		});
	};
});

monApp.controller("modifClientCtrl", function($scope,clientProvider){
	$scope.message="";
	
	$scope.agentID=0;
	
	$scope.client={
			id:0,
			nom:"",
			telephone:""
	}
	
	$scope.modClient={
			id:0,
			nom:"",
			telephone:""
	}
	
	$scope.clientModified = false;
	
	$scope.modif = function(){
		clientProvider.modifClient($scope.client,$scope.agentID,function(callBack){
			if(callBack!=undefined && callBack != ""){
				$scope.modClient = callBack;
				$scope.clientModified = true;
				$scope.message = "";
			} else {
				$scope.clientModified = false;
				$scope.message="Pas de Client créé";
			}
		});
	};
});	

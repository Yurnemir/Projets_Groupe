
monApp.controller("listeClientsCtrl", function($cookies, $scope, $rootScope, $location, clientProvider,visiteProvider) {
	
	$scope.showList = true;
	clientProvider.getAllClients(function(callBack){
		$scope.listeClients = callBack;
	});
	
	$scope.agentID = 0;
	
	
	
	$scope.agentSelect = function(){
		clientProvider.getClientsByAgent($scope.agentID,function(callBack){
			$scope.listeClients = callBack;
			if(callBack == "" || callBack == undefined){
				$scope.showList = false;
				$scope.message = "Cet agent ne gere aucun client";
			} else {
				$scope.showList = true;
				$scope.message = "";
			}
		});
	};
		
	$scope.agentDeSelect = function(){
		clientProvider.getAllClients(function(callBack){
			$scope.listeClients = callBack;
			if(callBack == "" || callBack == undefined){
				$scope.showList = false;
				$scope.message = "Aucun client enregistré";
			} else {
				$scope.showList = true;
				$scope.message = "";
			}
		});
	};
	
	$scope.modifLien = function(client){
		$rootScope.client = client;
		$location.path("/modifClient");
	};
	
	$scope.listeTypesBien = listeTypesBien;
	
	$scope.clientSelected = false;
	$scope.rechLoc = false;
	$scope.rechAch = false;
	$scope.selectedClient={
			id:0,
			nom:"",
			telephone:"",
			adresse:{
				numero:0,
				rue:"",
				cp:"",
				ville:""
			},
			criteres:{
				prixMax:undefined,
				loyerMax:undefined,
				surfaceMin:undefined,
				surfaceMax:undefined,
				bien:"",
				ville:"",
				recherche:undefined
			}
	};
	
	$scope.selectClient = function(client){
		clientProvider.getClientById(client.id,function(callBack){
			console.log("Le callBack"+callBack.criteres.bien);
			$scope.selectedClient.criteres.bien=callBack.criteres.bien;
			$scope.selectedClient = callBack;
			$scope.clientSelected = true;
			if(callBack.criteres.recherche == "LOCATION"){
				$scope.rechLoc = true;
				$scope.rechAch = false;
			} else if(callBack.criteres.recherche == "ACHAT"){
				$scope.rechLoc = false;
				$scope.rechAch = true;
			} else {
				$scope.rechLoc = false;
				$scope.rechAch = false;
			}
		});
	};
	
	$scope.showVisites = function(client){
		visiteProvider.getAllVisitesByClient(client.id,function(callBack){
			$scope.selectedVisites=callBack;
		});
	};
	
	
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
	
	$scope.inClient={
			nom : "",
			telephone : "",
			adresse:{
				numero:0,
				rue:"",
				cp:"",
				ville:""
			}
	};
	
	$scope.outClient={
			nom : "",
			telephone : "",
			adresse:{
				numero:0,
				rue:"",
				cp:"",
				ville:""
			}
	};
	
	$scope.clientCreated = false;
	
	$scope.agentID = 0;
	
	$scope.ajout = function(){
		clientProvider.addClient($scope.inClient,$scope.agentID,function(callBack){
			if(callBack!=undefined && callBack != ""){
				$scope.outClient = callBack;
				$scope.clientCreated = true;
				$scope.message = "";
			} else {
				$scope.clientCreated = false;
				$scope.message="Pas de Client créé";
			}
		});
	};
});

monApp.controller("modifClientCtrl", function($scope, $rootScope, clientProvider){
	$scope.message="";
	
	$scope.listeTypesBien = listeTypesBien;
	
	$scope.agentID=0;
	
	if($rootScope.client!=null){
		$scope.client=$rootScope.client;
	} else {
		$scope.client={
				id:0,
				nom:"",
				telephone:"",
				adresse:{
					numero:0,
					rue:"",
					cp:"",
					ville:""
				},
				criteres:{
					prixMax:undefined,
					loyerMax:undefined,
					surfaceMin:undefined,
					surfaceMax:undefined,
					bien:undefined,
					ville:"",
					recherche:null
				}
		}
	};
	
	
	$scope.modClient={
			id:0,
			nom:"",
			telephone:"",
			adresse:{
				numero:0,
				rue:"",
				cp:"",
				ville:""
			},
			criteres:{
				prixMax:undefined,
				loyerMax:undefined,
				surfaceMin:undefined,
				surfaceMax:undefined,
				bien:undefined,
				ville:"",
				recherche:null
			}
	};
	
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

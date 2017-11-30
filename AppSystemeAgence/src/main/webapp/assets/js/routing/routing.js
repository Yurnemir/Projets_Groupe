
monApp.config(function($routeProvider) {
	// ====================== Biens Achat ======================
	$routeProvider.when("/listeBiensAchat", {
		templateUrl: "views/biens/listeBiensAchat.html",
		controller: "listeBiensAchatCtrl"
	}).when("/rechercheBienAchat", {
		templateUrl: "views/biens/rechercheBienAchat.html",
		controller: "rechercheBienAchatCtrl"
	}).when("/ajoutBienAchat", {
		templateUrl: "views/biens/ajoutBienAchat.html",
		controller: "ajoutBienAchatCtrl"
	}).when("/modifBienAchat", {
		templateUrl: "views/biens/modifBienAchat.html",
		controller: "modifBienAchatCtrl"
	});
	
	// ====================== Biens Location ======================
	$routeProvider.when("/listeBiensLocation", {
		templateUrl: "views/biens/listeBiensLocation.html",
		controller: "listeBiensLocationCtrl"
	}).when("/rechercheBienLocation", {
		templateUrl: "views/biens/rechercheBienLocation.html",
		controller: "rechercheBienLocationCtrl"
	}).when("/ajoutBienLocation", {
		templateUrl: "views/biens/ajoutBienLocation.html",
		controller: "ajoutBienLocationCtrl"
	}).when("/modifBienLocation", {
		templateUrl: "views/biens/modifBienLocation.html",
		controller: "modifBienLocationCtrl"
	});
	
	// ====================== Clients ======================
	$routeProvider.when("/listeClients", {
		templateUrl: "views/clients/listeClients.html",
		controller: "listeClientsCtrl"
	}).when("/rechercheClient", {
		templateUrl: "views/clients/rechercheClient.html",
		controller: "rechercheClientCtrl"
	}).when("/ajoutClient", {
		templateUrl: "views/clients/ajoutClient.html",
		controller: "ajoutClientCtrl"
	});
	
	// ====================== Contrats ======================
	$routeProvider.when("/listeContrats", {
		templateUrl: "views/contrats/listeContrats.html",
		controller: "listeContratsCtrl"
	}).when("/rechercheContrat", {
		templateUrl: "views/contrats/rechercheContrat.html",
		controller: "rechercheContratCtrl"
	}).when("/ajoutContrat", {
		templateUrl: "views/contrats/ajoutContrat.html",
		controller: "ajoutContratCtrl"
	});
	
	// ====================== Proprietaires ======================
	$routeProvider.when("/listeProprietaires", {
		templateUrl: "views/proprietaires/listeProprietaires.html",
		controller: "listeProprietairesCtrl"
	}).when("/rechercheProprietaire", {
		templateUrl: "views/proprietaires/rechercheProprietaire.html",
		controller: "rechercheProprietaireCtrl"
	}).when("/ajoutProprietaire", {
		templateUrl: "views/proprietaires/ajoutProprietaire.html",
		controller: "ajoutProprietaireCtrl"
	});
	
	// ====================== Visites ======================
	$routeProvider.when("/listeVisites", {
		templateUrl: "views/visites/listeVisites.html",
		controller: "listeVisitesCtrl"
	}).when("/rechercheVisite", {
		templateUrl: "views/visites/rechercheVisite.html",
		controller: "rechercheVisiteCtrl"
	}).when("/ajoutVisite", {
		templateUrl: "views/visites/ajoutVisite.html",
		controller: "ajoutVisiteCtrl"
	});

	// ====================== Accueil (Defaut) ======================
	$routeProvider.when("/accueil", {
		templateUrl: "views/accueil.html",
	})
	$routeProvider.otherwise({
		redirectTo: "/accueil"
	});
});

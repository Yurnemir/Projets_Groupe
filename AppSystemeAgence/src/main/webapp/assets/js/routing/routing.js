
monApp.config(function($routeProvider) {
	// ====================== Biens Achat ======================
	$routeProvider.when("/listeBiensAchat", {
        resolve: { "check": function($cookies, $location) {
            if ($rootScope.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/biens/listeBiensAchat.html",
		controller: "listeBiensAchatCtrl"
	}).when("/rechercheBienAchat", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/biens/rechercheBienAchat.html",
		controller: "rechercheBienAchatCtrl"
	}).when("/ajoutBienAchat", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/biens/ajoutBienAchat.html",
		controller: "ajoutBienAchatCtrl"
	}).when("/modifBienAchat", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/biens/modifBienAchat.html",
		controller: "modifBienAchatCtrl"
	}).when("/insererImage", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/biens/insererImage.html",
		controller: "imageCtrl"
	});
	
	// ====================== Biens Location ======================
	$routeProvider.when("/listeBiensLocation", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/biens/listeBiensLocation.html",
		controller: "listeBiensLocationCtrl"
	}).when("/rechercheBienLocation", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/biens/rechercheBienLocation.html",
		controller: "rechercheBienLocationCtrl"
	}).when("/ajoutBienLocation", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/biens/ajoutBienLocation.html",
		controller: "ajoutBienLocationCtrl"
	}).when("/modifBienLocation", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/biens/modifBienLocation.html",
		controller: "modifBienLocationCtrl"
	});
	
	// ====================== Clients ======================
	$routeProvider.when("/listeClients", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/clients/listeClients.html",
		controller: "listeClientsCtrl"
	}).when("/rechercheClient", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/clients/rechercheClient.html",
		controller: "rechercheClientCtrl"
	}).when("/ajoutClient", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/clients/ajoutClient.html",
		controller: "ajoutClientCtrl"
	}).when("/modifClient", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/clients/modifClient.html",
		controller: "modifClientCtrl"
	});
	
	// ====================== Contrats ======================
	$routeProvider.when("/listeContrats", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/contrats/listeContrats.html",
		controller: "listeContratsCtrl"
	}).when("/rechercheContrat", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/contrats/rechercheContrat.html",
		controller: "rechercheContratCtrl"
	}).when("/ajoutContrat", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/contrats/ajoutContrat.html",
		controller: "ajoutContratCtrl"
	});
	
	// ====================== Proprietaires ======================
	$routeProvider.when("/listeProprietaires", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/proprietaires/listeProprietaires.html",
		controller: "listeProprietairesCtrl"
	}).when("/rechercheProprietaire", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/proprietaires/rechercheProprietaire.html",
		controller: "rechercheProprietaireCtrl"
	}).when("/ajoutProprietaire", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/proprietaires/ajoutProprietaire.html",
		controller: "ajoutProprietaireCtrl"
	});
	
	// ====================== Visites ======================
	$routeProvider.when("/listeVisites", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/visites/listeVisites.html",
		controller: "listeVisitesCtrl"
	}).when("/rechercheVisite", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/visites/rechercheVisite.html",
		controller: "rechercheVisiteCtrl"
	}).when("/ajoutVisite", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/visites/ajoutVisite.html",
		controller: "ajoutVisiteCtrl"
	}).when("/modifVisite", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/visites/modifVisite.html",
		controller: "modifVisiteCtrl"
	}).when("/supprVisite", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/visites/supprVisite.html",
		controller: "supprVisiteCtrl"
	});

	// ====================== Accueil + Login ======================
	$routeProvider.when("/accueil", {
        resolve: { "check": function($cookies, $location) {
            if ($cookies.get("username") == undefined) { $location.path("/login"); } }
        },
		templateUrl: "views/accueil.html",
		controller: "accueilCtrl"
	}).when("/login", {
		templateUrl: "views/login.html",
		controller: "loginCtrl",
	})

	$routeProvider.otherwise({
		redirectTo: "/login"
	});
});

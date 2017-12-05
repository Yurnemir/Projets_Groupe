
monApp.controller("listeBiensLocationCtrl", function($scope, $rootScope, $location, bienLocationProvider) {
	bienLocationProvider.getAllBiensLocation(function(callBack) {
		$scope.listeBiensLocation = callBack;
	});
	$scope.modifBienLocationViaLien = function(bienLocation) {
		$rootScope.bienLocationForm = {
			id:bienLocation.id,
			dateSoumission:bienLocation.dateSoumission,
			dateDispo:bienLocation.dateDispo,
			disponible:bienLocation.disponible,
			typeBien:bienLocation.typeBien,
			loyer:bienLocation.loyer,
			caution:bienLocation.caution,
			charges:bienLocation.charges,
			meuble:bienLocation.meuble,
			typeBail:bienLocation.typeBail
		};
		$location.path("modifBienLocation");
	}
	$scope.supprBienLocationViaLien = function(idSuppr) {
		bienLocationProvider.deleteBienLocation(idSuppr, function(callBack) {
			bienLocationProvider.getAllBiensLocation(function(callBack) {
				$scope.listeBiensLocation = callBack;
			});
		});
	}
});

monApp.controller("rechercheBienLocationCtrl", function($scope, bienLocationProvider) {
	$scope.displayResult = false;
	$scope.getBienLocationById = function() {
		bienLocationProvider.getBienLocationById($scope.idRecherche, function(callBack) {
			$scope.bienLocationTrouve = callBack;
			$scope.displayResult = true;
		});
	}
});

monApp.controller("ajoutBienLocationCtrl", function($scope, $location, proprietaireProvider, bienLocationProvider) {
	proprietaireProvider.getAllProprietaires(function(callBack) {
		var listeProprietaires = [];
		for (i=0; i<callBack.length; i++) {
			listeProprietaires.push({"key":callBack[i].id, "value":callBack[i].nom});
		}
		$scope.listeProprietaires = listeProprietaires;
		$scope.idProp = listeProprietaires[0].key;
	});
	
	$scope.listeTypesBien = listeTypesBien;
	$scope.listeTypesBail = listeTypesBail;
	$scope.bienLocationForm = {
		id:undefined,
		dateSoumission:undefined,
		dateDispo:undefined,
		disponible:false,
		typeBien:0,
		loyer:0,
		caution:0,
		charges:0,
		meuble:false,
		typeBail:0
	}
	$scope.addBienLocation = function() {
		console.log($scope.bienLocationForm);
		bienLocationProvider.addBienLocation($scope.bienLocationForm, $scope.idProp, function(callBack) {
			if (callBack!=undefined && callBack!="") {
				$location.path("listeBiensLocation");
			}
		});
	}
});

monApp.controller("modifBienLocationCtrl", function($scope, $rootScope, $location, proprietaireProvider, bienLocationProvider) {
	proprietaireProvider.getAllProprietaires(function(callBack) {
		var listeProprietaires = [];
		for (i=0; i<callBack.length; i++) {
			listeProprietaires.push({"key":callBack[i].id, "value":callBack[i].nom});
		}
		$scope.listeProprietaires = listeProprietaires;
		$scope.idProp = listeProprietaires[0].key;
	});
	
	$scope.listeTypesBien = listeTypesBien;
	$scope.listeTypesBail = listeTypesBail;
	if ($rootScope.bienLocationForm == undefined) {
		$scope.bienLocationForm = {
			id:undefined,
			dateSoumission:undefined,
			dateDispo:undefined,
			disponible:false,
			typeBien:0,
			loyer:0,
			caution:0,
			charges:0,
			meuble:false,
			typeBail:0
		}
	} else {
		$scope.bienLocationForm = {
			id:$rootScope.bienLocationForm.id,
			dateSoumission:new Date($rootScope.bienLocationForm.dateSoumission),
			dateDispo:new Date($rootScope.bienLocationForm.dateDispo),
			disponible:$rootScope.bienLocationForm.disponible,
			typeBien:$rootScope.bienLocationForm.typeBien,
			loyer:$rootScope.bienLocationForm.loyer,
			caution:$rootScope.bienLocationForm.caution,
			charges:$rootScope.bienLocationForm.charges,
			meuble:$rootScope.bienLocationForm.meuble,
			typeBail:$rootScope.bienLocationForm.typeBail
		}
	}
	$scope.updateBienLocation = function() {
		bienLocationProvider.updateBienLocation($scope.bienLocationForm, $scope.idProp, function(callBack) {
			if (callBack!=undefined && callBack!="") {
				$location.path("listeBiensLocation");
			}
		});
	}
});

monApp.controller("mappingBienLocationCtrl", function($scope, bienLocationProvider) {
	$scope.init = function() {
		bienLocationProvider.getAllBiensLocation(function(callBack) {
			var style = new ol.style.Style({
				image: new ol.style.Icon(({
					color: [80, 80, 255],
					crossOrigin: 'anonymous',
					src: 'https://openlayers.org/en/v4.5.0/examples/data/dot.png'
				}))
			})
			var markers = [];
			var marker;
			for (i=0; i<callBack.length; i++) {
				marker = new ol.Feature({
					geometry: new ol.geom.Point(ol.proj.fromLonLat([callBack[i].longitude, callBack[i].latitude]))
				});
				marker.setStyle(style);
				markers.push(marker);
			}
			
			var vectorSource = new ol.source.Vector({
				features: markers
			});
			var vectorLayer = new ol.layer.Vector({
				source: vectorSource
			});
			var rasterLayer = new ol.layer.Tile({
				source: new ol.source.OSM()
			});
			var map = new ol.Map({
				layers: [rasterLayer, vectorLayer],
				target: document.getElementById("mapLocation"),
				view: new ol.View({
					center: ol.proj.fromLonLat([2.601598, 46.5326709]),
					zoom: 5
				})
			});
		});
	}
});

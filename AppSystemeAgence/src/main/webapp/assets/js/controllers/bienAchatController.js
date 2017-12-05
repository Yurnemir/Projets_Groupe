monApp.controller("listeBiensAchatCtrl", function($scope, $rootScope,
		$location, bienAchatProvider) {
	bienAchatProvider.getAllBiensAchat(function(callBack) {
		$scope.listeBiensAchat = callBack;
	});
	$scope.modifBienAchatViaLien = function(bienAchat) {
		$rootScope.bienAchatForm = {
			id : bienAchat.id,
			dateSoumission : bienAchat.dateSoumission,
			dateDispo : bienAchat.dateDispo,
			disponible : bienAchat.disponible,
			typeBien : bienAchat.typeBien,
			etatBien : bienAchat.etatBien,
			prixVente : bienAchat.prixVente
		};
		$location.path("modifBienAchat");
	}
	$scope.supprBienAchatViaLien = function(idSuppr) {
		bienAchatProvider.deleteBienAchat(idSuppr, function(callBack) {
			bienAchatProvider.getAllBiensAchat(function(callBack) {
				$scope.listeBiensAchat = callBack;
			});
		});
	}
});

monApp.controller("rechercheBienAchatCtrl",
		function($scope, bienAchatProvider) {
			$scope.displayResult = false;
			$scope.getBienAchatById = function() {
				bienAchatProvider.getBienAchatById($scope.idRecherche,
						function(callBack) {
							$scope.bienAchatTrouve = callBack;
							$scope.displayResult = true;
						});
			}
		});

monApp.controller("ajoutBienAchatCtrl", function($scope, $location,
		proprietaireProvider, bienAchatProvider) {
	proprietaireProvider.getAllProprietaires(function(callBack) {
		var listeProprietaires = [];
		for (i = 0; i < callBack.length; i++) {
			listeProprietaires.push({
				"key" : callBack[i].id,
				"value" : callBack[i].nom
			});
		}
		$scope.listeProprietaires = listeProprietaires;
		$scope.idProp = listeProprietaires[0].key;
	});

	$scope.listeTypesBien = listeTypesBien;
	$scope.listeEtatsBien = listeEtatsBien;
	$scope.bienAchatForm = {
		id : undefined,
		dateSoumission : undefined,
		dateDispo : undefined,
		disponible : false,
		typeBien : 0,
		etatBien : 0,
		prixVente : 0
	}
	$scope.addBienAchat = function() {
		bienAchatProvider.addBienAchat($scope.bienAchatForm, $scope.idProp,
				function(callBack) {
					if (callBack != undefined && callBack != "") {
						$location.path("listeBiensAchat");
					}
				});
	}
});

monApp.controller("modifBienAchatCtrl", function($scope, $rootScope, $location,
		proprietaireProvider, bienAchatProvider) {
	proprietaireProvider.getAllProprietaires(function(callBack) {
		var listeProprietaires = [];
		for (i = 0; i < callBack.length; i++) {
			listeProprietaires.push({
				"key" : callBack[i].id,
				"value" : callBack[i].nom
			});
		}
		$scope.listeProprietaires = listeProprietaires;
		$scope.idProp = listeProprietaires[0].key;
	});

	$scope.listeTypesBien = listeTypesBien;
	$scope.listeEtatsBien = listeEtatsBien;
	if ($rootScope.bienAchatForm == undefined) {
		$scope.bienAchatForm = {
			id : undefined,
			dateSoumission : undefined,
			dateDispo : undefined,
			disponible : false,
			typeBien : 0,
			etatBien : 0,
			prixVente : 0
		}
	} else {
		$scope.bienAchatForm = {
			id : $rootScope.bienAchatForm.id,
			dateSoumission : new Date($rootScope.bienAchatForm.dateSoumission),
			dateDispo : new Date($rootScope.bienAchatForm.dateDispo),
			disponible : $rootScope.bienAchatForm.disponible,
			typeBien : $rootScope.bienAchatForm.typeBien,
			etatBien : $rootScope.bienAchatForm.etatBien,
			prixVente : $rootScope.bienAchatForm.prixVente
		}
	}
	$scope.updateBienAchat = function() {
		bienAchatProvider.updateBienAchat($scope.bienAchatForm, $scope.idProp,
				function(callBack) {
					if (callBack != undefined && callBack != "") {
						$location.path("listeBiensAchat");
					}
				});
	}
});

// monApp.controller("imageCtrl", function($scope, $location, bienAchatProvider)
// {
//
// $scope.idRech = undefined;
// $scope.addImage = function() {
// var image = document.getElementById('file').files[0];
// var lecture = new FileReader();
// lecture.onloadend = function(evenement) {
// var donnees = evenement.target.result;
// bienAchatProvider.addImage(donnees, $scope.idRech, function(
// callBack) {
// if (callBack != undefined && callBack != "") {
// $location.path("listeBiensAchat");
// }
// });
// }
// }
// });

monApp.controller('imageCtrl', function($scope, bienAchatProvider) {
	$scope.idRech = undefined;
	$scope.uploadFile = function() {
		var file = $scope.file;

		var fileFormData = new FormData();
		fileFormData.append('file', file);

		bienAchatProvider.addImage(fileFormData, $scope.idRech, function(
				callBack) {
			if (callBack != undefined && callBack != "") {
				$location.path("listeBiensAchat");
			}
		});
	}

});


monApp.controller("mappingBienAchatCtrl", function($scope, bienAchatProvider) {
	$scope.init = function() {
		bienAchatProvider.getAllBiensAchat(function(callBack) {
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
				target: document.getElementById("mapAchat"),
				view: new ol.View({
					center: ol.proj.fromLonLat([2.601598, 46.5326709]),
					zoom: 5
				})
			});
		});
	}
});


/**
 * Ismet
 * 
 */
var app=angular.module("myApp4",[])



app.controller("ajouterMedecin", function($scope,$http) {
	console.log("Let's start the show")
	
	$scope.ajouterMedecin=function(){
		var x=document.getElementById("imgTest").innerHTML
		console.log(x)
		
		$scope.medecin={"email":$scope.email,"statut" : "medecin","nom" : $scope.nom ,"prenom" : $scope.prenom,"photos":x, "sexe" :$scope.sexe,"ville":$scope.ville,"adresse":$scope.adresse,"codePostale":$scope.codePostale,"prix":parseInt($scope.prix),"presentation":$scope.presentation,
			"phoneNumber":$scope.phoneNumber,"spc":$scope.spc,"modepayement":$scope.modePayement, "password" : $scope.password,"type" : "Medecin"}
		  
		console.log("voila son mail "+$scope.email)
		if ($scope.email != null) {
			if($scope.password != null){
				
		$http.post("/medecin/",$scope.medecin)
		.success(function() {
			console.log($scope.photos);
			console.log($scope.medecin);
			
			if (confirm("voulez vous vous authentifier?")) { 
				   //alert("vous etes d'accord")
				   document.location.href="Login.html"
				}
				else{
				   alert("vous n'êtes pas d'accord")
				}
			
		});
			}else{
				alert("saisissez tout les champs svp")
			}
		}else{
			alert("saisissez tout les champs svp")
		}
	}
	console.log($scope.medecin)
	
	});
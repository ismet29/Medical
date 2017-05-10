/**
 * Ismet
 * 
 */
var app=angular.module("myApp10",[])



app.controller("editerMedecin", function($scope,$http) {
	console.log("Let's start the show")
	
	$scope.chercherId=function(){
		
		$scope.medecin={}
		$http.get("/medecin/"+$scope.id)
		.success(function(data) {
			$scope.medecin=data
			console.log($scope.medecin); 
		});
	}
	$scope.supprimerMedecin=function(id){
		$scope.medecin={}
		
		console.log("Suppression en cours de "+id)
		$scope.medecin={ "id" : id }
		console.log("regarde ici voici son nom : "+$scope.medecin.id)

		$http.delete("/medecin/"+id)
		.success(function(data){
			
			$scope.medecin=data[0];
			console.log("regarde ici : "+$scope.medecin.id)
			//$scope.medecin1=data
			console.log("suppresion reussi")
			alert("success")
			location.reload(); 
			window.location.reload();
		
		})
	}
	$scope.editerMedecin=function(id){
		console.log($scope.nom)
		alert($scope.nom)
		console.log("Test 1 : "+$scope.nom)
		var x=document.getElementById("imgTest").innerHTML
		console.log(x)
		var price=parseInt($scope.prix);
		$scope.medecin={"nom" : $scope.nom ,"prenom" : $scope.prenom,"photos":x, "sexe" :$scope.sexe,"type":"Medecin,","ville":$scope.ville,"adresse":$scope.adresse,"codePostale":$scope.codePostale,"prix":price,"presentation":$scope.presentation,
					"phoneNumber":$scope.phoneNumber,"email":$scope.email,"spc":$scope.spc,"modepayement":$scope.modePayement,"password":$scope.password}
		
		console.log("edition "+id)
			console.log("Test 2 : "+$scope.medecin.nom)
		
		$http.put("/medecin/"+id,$scope.medecin)
		.success(function(data) {
			$scope.medecin=data;
			console.log($scope.medecin);
			
		})
	}
	});
/**
 * Ismet
 */
var app=angular.module("myApp11",[])



app.controller("editerPatient", function($scope,$http) {
	console.log("Let's start the show")
	
	$scope.chercherId=function(){
		
		$scope.patient={}
		$http.get("/patient/"+$scope.id)
		.success(function(data) {
			$scope.patient=data
			
			console.log($scope.patient.numeroSecu); 
		});
	}
	$scope.supprimerpatient=function(id){
		$scope.patient={}
		
		console.log("Suppression en cours de "+id)
		$scope.patient={ "id" : id }
		console.log("regarde ici voici son nom : "+$scope.patient.id)

		$http.delete("/patient/"+id)
		.success(function(data){
			
			$scope.patient=data[0];
			console.log("regarde ici : "+$scope.patient.id)
			//$scope.patient1=data
			console.log("suppresion reussi")
			alert("success")
			location.reload(); 
			window.location.reload();
		
		})
	}
	$scope.editerPatient=function(id){
		
		$scope.patient={}
		console.log($scope.nom)
	
		var x=document.getElementById("imgTest").innerHTML
		console.log(x)
		alert(x)
		console.log("Test 1 : "+$scope.nom)
			$scope.patient={"nom": $scope.nom , "prenom": $scope.prenom, "photos" : x , "numeroSecu": parseInt($scope.numeroSecu),"cmu":$scope.cmu,
			"photos":x, "sexe" :$scope.sexe,"type":"Patient","ville":$scope.ville,"adresse":$scope.adresse,"codePostale":$scope.codePostale,
					"phoneNumber":$scope.phoneNumber,"email":$scope.email,"password":$scope.password}
		
		$http.put("/patient/"+id,$scope.patient)
		.success(function(data) {
			$scope.patient=data;
			console.log($scope.patient);
			
		})
	}
	});
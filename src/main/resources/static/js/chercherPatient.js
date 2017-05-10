/**
 * Ismet
 */
var app=angular.module("myApp3",[])



app.controller("chercherPatient", function($scope,$http) {
	console.log("Let's start the show")
	$scope.nom=""
		
	$scope.chercherPatient=function(){
		$http.get("/patientNom/"+$scope.nom)
		.success(function(data) {
			$scope.patient=data;
			$scope.patient.numeroSecu=toString($scope.patient.numeroSecu)
			console.log($scope.patient);
		});
	}
	
	$scope.supprimerPatient=function(id){
		$scope.patient1={}
		
		console.log("Suppression en cours de "+id)
		$scope.m1={ "id" : id }
		console.log("regarde ici voici son nom : "+$scope.patient1.id)

		$http.delete("/patient/"+id)
		.success(function(data){
			$scope.patient1=data[0];
			console.log("regarde ici : "+$scope.patient1.id)
			//$scope.patient1=data
			console.log("suppresion reussi")
			alert("success")
			location.reload(); 
			window.location.reload();
		
		})
	}
	});
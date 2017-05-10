/**
 * Ismet
 */
var app=angular.module("myApp14",[])

app.controller("listePatient",function($scope,$http){
	$scope.afficher1=function(nom){
		$scope.rdv1={}
		
		$http.get("/rdvpatient/"+$scope.nom)
		.success(function(data) {
			$scope.rdv1=data;
			console.log($scope.rdv1);
			
		});
	}
	
	
	$scope.supprimerRdv=function(key){
		$scope.rdv1={}
		
		console.log("Suppression en cours de "+key)
		$scope.rdv1={ "key" : key }
		console.log("regarde ici voici son nom : "+$scope.rdv1.key)

		$http.delete("/rdv/"+key)
		.success(function(data){
			
			$scope.rdv1=data[0];
			
			//$scope.medecin1=data
			console.log("suppresion reussi")
			alert("success")
			location.reload(); 
			window.location.reload();
		
		})
	}
})


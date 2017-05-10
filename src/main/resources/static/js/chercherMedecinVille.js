/**
 * Ismet
 */
var app=angular.module("myApp2",[])



app.controller("chercher", function($scope,$http) {
	console.log("hello")
	$scope.medecins={}
	$scope.result=null;
	$scope.ville=""
	$scope.chercherVille=function(){
		$http.get("/medecinVille/"+$scope.ville)
		.success(function(data) {
			$scope.medecins=data;
			console.log($scope.medecins);
			
		});
	}
	
	$scope.supprimerMedecin=function(id){
		$scope.medecin1={}
		
		console.log("Suppression en cours de "+id)
		$scope.medecin1={ "id" : id }
		console.log("regarde ici voici son nom : "+$scope.medecin1.id)

		$http.delete("/medecin/"+id)
		.success(function(data){
			
			$scope.medecin1=data[0];
			console.log("regarde ici : "+$scope.medecin1.id)
			//$scope.medecin1=data
			console.log("suppresion reussi")
			alert("success")
			location.reload(); 
			window.location.reload();
		
		})
	}
	
	
	$scope.editerMedecin=function(id){
		console.log("Test 1 : "+$scope.nom)
		$scope.medecinn={"nom": $scope.nom,"prenom": $scope.prenom,"sexe": $scope.sexe }
		console.log("edition "+id)
		console.log("Test 2 : "+$scope.medecinn.nom)
	$http.put("/medecin/"+id,$scope.medecinn)
	.success(function(data) {
		$scope.medecinn=data;
		alert("Success")
		console.log($scope.medecinn);
		
	})
	
	}

	$scope.editer=function(nom){
		
		$scope.medecin2={}
		console.log("edition "+nom)
		$http.get("/medecinNom/"+nom)
		.success(function(data) {
			$scope.medecin2=data;
			console.log($scope.medecin2);
			
		})	
	}
	$scope.DeleteData=function(){
		console.log($scope.firstName)
	}
	
	});
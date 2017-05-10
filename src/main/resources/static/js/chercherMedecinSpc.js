/**
 * Ismet
 */
var app=angular.module("myApp6",[])



app.controller("chercherSpc", function($scope,$http) {
	console.log("hello")
	$scope.medecin={}
	$scope.result=null;
	$scope.spc=""
	$scope.chercherSpc=function(){
		$http.get("/medecinSpc/"+$scope.spc)
		.success(function(data) {
			$scope.medecin=data;
			console.log($scope.medecin);
			
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
	});
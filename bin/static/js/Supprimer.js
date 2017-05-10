/**
 * Ismet
 */

 var myApp = angular.module("myApp20", []);
 app.controller("Control", function($scope,$http) {
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
 })
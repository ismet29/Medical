/**
 * Ismet
 * 
 */
var app=angular.module("myApp14",[])



app.controller("authentification", function($scope,$http) {
	console.log("Let's start the show")
	
	$scope.authentification=function(){
		$scope.medecin={}
		$http.get("AuthentificationPatient/"+$scope.email+"/"+$scope.password)
		.success(function(data) {
			$scope.medecin=data
			alert($scope.medecin.email)
			
			if($scope.medecin.email == $scope.email){
				 alert("Salut "+$scope.medecin.statut+" "+$scope.medecin.nom)
				document.location.href="AcceuilPatient.html"
			}else{
				 alert("erreur id ou mot de passe incorrect");
				 document.location.href="ChoixLogin.html"
			}
		
		});
	}
	
	});
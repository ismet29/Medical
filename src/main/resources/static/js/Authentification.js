/**
 * Ismet
 * 
 */
var app=angular.module("myApp14",[])



app.controller("authentification", function($scope,$http) {
	console.log("Let's start the show")
	
	$scope.authentification=function(){
		$scope.medecin={}
		console.log("je suis rentrer")
		 alert("je rentre")
		
		$http.get("Authentification/"+$scope.email+"/"+$scope.password)
		.success(function(data) {
			$scope.medecin=data
			 alert($scope.medecin.statut)
			if($scope.medecin.email == $scope.email){
				
				 alert("Salut "+$scope.medecin.statut+" "+$scope.medecin.nom)
				document.location.href="AcceuilMedecin.html"
			}else{
				 alert("erreur id ou mot de passe incorrect");
				 document.location.href="ChoixLogin.html"
			}
		
		});
		
	}
	
	});
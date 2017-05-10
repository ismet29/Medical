/**
 * Ismet
 */
var app=angular.module("myApp12",[])



app.controller("ajouterRdv", function($scope,$http) {
	console.log("Let's start the show")    
	$scope.ajouterRdv=function(){
	
		$scope.rdv={"date":$scope.date,"heure": $scope.heure , "date": $scope.date, "medecin": parseInt($scope.medecin),"patient":parseInt($scope.patient),"nomMedecin":$scope.nomMedecin,"nomPatient":$scope.nomPatient}
		$http.post("/rdv/",$scope.rdv)
		.success(function() {
			  alert("Votre rdv a ete ajouter")
			  if(confirm("voulez vous quitter maintenant?")){
			  document.location.href="ChoixLogin.html"
			  }else{
				  document.location.href="AjouterRdv.html"
			  }
		console.log($scope.rdv); 
		});
	}
	console.log($scope.rdv)
	
	});




app.controller("afficherListeRdv",function($scope,$http){
	$scope.afficher=function(data){
		$http.get("/rdv")
		.success(function(data){
			$scope.rdv=data
			console.log("reussi liste rdv afficher")
		})
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
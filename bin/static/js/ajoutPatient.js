/**
 * Ismet
 * 
 */
var app=angular.module("myApp5",[])



app.controller("ajouterPatient", function($scope,$http) {
	console.log("Let's start the show")
	
	$scope.ajouterPatient=function(){
		var x=document.getElementById("imgTest").innerHTML
		console.log(x)
		$scope.val=parseInt($scope.numeroSecu)+10
		console.log("cmu "+$scope.cmu)
		$scope.patient={"nom": $scope.nom , "prenom": $scope.prenom, "photos" : x, "numeroSecu": parseInt($scope.numeroSecu),"cmu":$scope.cmu
			,"photos":x, "sexe" :$scope.sexe,"type" : "Patient", "statut":"patient","ville":$scope.ville,"adresse":$scope.adresse,"codePostale":$scope.codePostale,
			"phoneNumber":$scope.phoneNumber,"email":$scope.email,"password":$scope.password}
		if ($scope.email != null) {
			if($scope.password != null){
				
		
		$http.post("/patient/",$scope.patient)
		.success(function() {
			
			console.log($scope.patient);
			
			if (confirm("voulez vous vous authentifier?")) { 
				   alert("vous êtes d'accord")
				   document.location.href="LoginPatient.html"
				}
				else{
				   alert("vous n'êtes pas d'accord")
				}
		});
			}else{
				alert("saisissez tout les champs svp")
			}
		}else{
			alert("saisissez tout les champs svp")
		}
		
	}
	console.log($scope.patient)
	
	});
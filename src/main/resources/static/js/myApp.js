/**
 * Ismet
 */
var app=angular.module("myBanqueApp",[])
app.controller("myBanqueController", function($scope,$http) {
	$scope.medecin={}
	$scope.result=null;
	$scope.nom=""
	$scope.chargerCompte=function(){
		$http.get("/medecinNom/"+$scope.nom)
		.success(function(data) {
			$scope.medecin=data;
			console.log($scope.medecin);
			
		});
		
	};
	
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
	
	$scope.supprimer=function(id){
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
});




app.controller("chercher", function($scope,$http) {
	console.log("hello")
	$scope.medecin={}
	$scope.result=null;
	$scope.ville=""
	$scope.chercherVille=function(){
		$http.get("/medecinVille/"+$scope.ville)
		.success(function(data) {
			$scope.medecin=data;
			console.log($scope.medecin);
			
		});
	}
	});


app.controller("test",function($scope,$http){
	$scope.supprimerMedecin=function(nom){
		console.log(nom)
		$scope.medecin={"nom" : nom}
		console.log("medecin "+$scope.nom)
		
		$http({
			method : 'DELETE',
			url    : ('/medecin',{data : $scope.medecin}),
			
			headers: {'Content-Type':'application/json'} 
		})
		.success(function(data){
			console.log("reussi")
		})
	}
})

/*
app.controller("test",function($scope,$http){
	

	$scope.supprimerMedecin=function(nom){
		$scope.medecin={"nom":nom}
		$scope.rep=nom
		console.log($scope.medecin)
		$scope.supprimerMedecin=function(){
			$http.delete("/medecin",$scope.medecin)
			.success(function(medecin){
				console.log($scope.medecin)
				
			})
		}

	}
	
})*/


app.controller("afficherToutLesMedecins",function($scope,$http){
	$scope.medecin={}
	$scope.afficherListeMedecin=function(){
		$http.get("/medecins")
		.success(function(data){
			$scope.medecin=data;
			console.log($scope.medecin)
		})
	}
	
});

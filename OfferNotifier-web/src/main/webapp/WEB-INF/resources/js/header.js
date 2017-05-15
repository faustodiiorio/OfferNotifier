angular.module('home')
	.controller('HeaderController', ['$http', '$rootScope', '$state', function($http, $rootScope, $state){
		'use strict';
		var header = this;
		header.superCategories = [];
		
		
		header.getSuperCategories = function(){
			var getSuperCategories = $http.get('http://localhost:8080/OfferNotifier/header/getSuperCategories');
			getSuperCategories.then(function(result){
				header.superCategories = result.data;
			})
		};
		header.getSuperCategories();
	}]);
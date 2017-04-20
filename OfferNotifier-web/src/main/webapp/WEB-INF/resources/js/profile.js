angular.module('home')
	.controller('ProfileController', ['$http', '$rootScope', '$animate', function($http, $rootScope, $animate){
		'use strict';
		var profile = this;
		
		profile.info = false;
		profile.contribution = false;
		profile.saved = false;
		profile.message = false;
		
		profile.getContribution = function(){
			profile.walkthroughs = [];
			profile.reviews = [];
			profile.domande = [];
			profile.risposte = [];
			
			var getPartialReviesByUser = $http.get('http://localhost:8080/recensigames/profile/getPartialReviewsByUser?username=' + $rootScope.user.username);
			getPartialReviesByUser.then(function(result) {
				angular.forEach(result.data, function(value, key){
					if(value.tipologia === ("Walkthrough")){
				    	profile.walkthroughs.push(value);
				    	} else if(value.tipologia === ("Recensione")){
				    		profile.reviews.push(value);
				    	}
				});
			});
			var getQuestionsByUser = $http.get('http://localhost:8080/recensigames/profile/getQuestionsByUser?username=' + $rootScope.user.username);
			getQuestionsByUser.then(function(result) {
			    profile.domande = result.data;
			});
			var getAnswersByUser = $http.get('http://localhost:8080/recensigames/profile/getAnswersByUser?username=' + $rootScope.user.username);
			getAnswersByUser.then(function(result) {
				profile.risposte = result.data;
			});
		};
		profile.getContribution();
		
		profile.locateInfo = function(){
			profile.info = !profile.info;
			profile.contribution = false;
			profile.saved = false;
			profile.message = false;
		};
		profile.locateContribution = function(){
			profile.info = false;
			profile.contribution = !profile.contribution;
			profile.saved = false;
			profile.message = false;
		};
		profile.locateSaved = function(){
			profile.info = false;
			profile.contribution = false;
			profile.saved = !profile.saved;
			profile.message = false;
		};
		profile.locateMessage = function(){
			profile.info = false;
			profile.contribution = false;
			profile.saved = false;
			profile.message = !profile.message;
		};
	}]);
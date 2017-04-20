var app = angular.module('home', ['ui.router']);
	app.config(['$stateProvider', '$urlRouterProvider', '$locationProvider', function($stateProvider, $urlRouterProvider, $locationProvider){
		$locationProvider.html5Mode(true);
		$stateProvider
			.state({
				name: 'home',
				url: 'OfferNotifier/',
			})
			.state({
				name: 'login',
				url: 'OfferNotifier/login',
				templateUrl: 'OfferNotifier/views/login.html',
				controller: 'LoginController'
			})
			.state({
				name: 'register',
				url: 'OfferNotifier/register',
				templateUrl: 'OfferNotifier/views/register.html',
				controller: 'RegisterController'
			})
			.state({
				name: 'searchByTitle',
				url: 'OfferNotifier/search/:titoloGioco',
				templateUrl: 'OfferNotifier/views/search.html',
				controller: 'SearchController'
			})
			.state({
				name: 'searchByConsole',
				url: 'OfferNotifier/search/:nomeConsole',
				templateUrl: 'OfferNotifier/views/search.html',
				controller: 'SearchController'
			})
			.state({
				name: 'profile',
				url: 'OfferNotifier/profile',
				templateUrl: 'OfferNotifier/views/profile.html',
				controller: 'ProfileController'
			})
	}])
	app.controller('HomeController', ['$http', '$rootScope', '$state', '$scope', function ($http, $rootScope, $state, $scope){
		var home = this;
		$rootScope.logged = false;
		home.header = "OfferNotifier/views/header.html";
		home.footer = "OfferNotifier/views/footer.html";
	}]);
	app.run(['$rootScope', '$state', function ($rootScope, $state) {
    $rootScope.$on('$stateChangeStart', function (event) {
    	var state = $state.current.url;
        if ($state.current.url.includes('profile') && !$rootScope.logged) {
            event.preventDefault();
            $state.go('/login');
        }
        else if($state.current.url.includes('profile') && rootScope.logged){
            $state.go('home');
        }
    });
}]);
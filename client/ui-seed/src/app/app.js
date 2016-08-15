(function() {
  'use strict';

  angular
    .module('movieflix', ['ngRoute'])
    .config(moduleConfig);

  function moduleConfig($routeProvider) {

    $routeProvider
      .when('/movies/findById/:id', {
        templateUrl: 'app/views/movies.tmpl.html',
        controller: 'MoviesDetailController',
        controllerAs: 'moviesDetailVm'
      })
      .when('/movies', {
        templateUrl: 'app/views/movies.tmpl.html',
        controller: 'MoviesController',
        controllerAs: 'moviesVm'
      })
      .when('/movies/findByYear/:year', {
        templateUrl: 'app/views/movies.tmpl.html',
        controller: 'MoviesDetailController',
        controllerAs: 'moviesDetailVm'
      })
      .otherwise({
        redirectTo: '/movies'
      });
  }

})();
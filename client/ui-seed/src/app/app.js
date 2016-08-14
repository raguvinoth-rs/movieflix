(function() {
  'use strict';

  angular
    .module('plunker', ['ngRoute'])
    .config(moduleConfig);

  function moduleConfig($routeProvider) {

    $routeProvider
      .when('/users', {
        templateUrl: 'app/views/users.tmpl.html',
        controller: 'UsersController',
        controllerAs: 'usersVm'
      })
      .when('/users/:id', {
        templateUrl: 'app/views/user-detail.tmpl.html',
        controller: 'UserDetailController',
        controllerAs: 'userDetailVm'
      })
      .when('/resources', {
        templateUrl: 'app/views/resources.tmpl.html',
        controller: 'ResourcesController',
        controllerAs: 'resourcesVm'
      })
      .otherwise({
        redirectTo: '/users'
      });
  }

})();
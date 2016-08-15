/**
 * Created by Raguvinoth on 8/14/2016.
 */

(function() {
    'use strict';

    angular.module('movieflix')
        .service('moviesService', moviesService);

    moviesService.$inject = ['$http', '$q', 'CONFIG'];

    function moviesService($http, $q, CONFIG) {

        var ms = this;

        ms.getMovies = getMovies;
        ms.findById = findById;
        ms.findByYear = findByYear;

        function getMovies() {
            return $http.get(CONFIG.API_HOST + "/movies/")
                .then(successFn, errorFn);
        }

        function findById(id) {
            return $http.get(CONFIG.API_HOST + '/movies/findById/' + id)
                .then(successFn, errorFn);
        }

        function findByYear(year) {
            return $http.get(CONFIG.API_HOST + '/movies/findByYear/' + year)
                .then(successFn, errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }

})();
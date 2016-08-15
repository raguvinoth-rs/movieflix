/**
 * Created by Raguvinoth on 8/14/2016.
 */

(function() {
    'use strict';

    angular.module('movieflix')
        .controller('MoviesDetailController', MoviesDetailController);

    MoviesDetailController.$inject = ['moviesService','$routeParams'];

    function MoviesDetailController(moviesService, $routeParams) {
        var moviesParamVm = this;

        init();

        function init() {
            console.log('In MoviesDetailController');


            moviesService
                .findById($routeParams.id)
                .then(function (movie){
                    moviesParamVm.movie = movie;
                    console.dir(moviesParamVm.movie)
                }, function (error) {
                    console.log(error);
                });

            moviesService
                .findByYear($routeParams.year)
                .then(function (movie){
                    moviesParamVm.movie = movie;
                    console.dir(moviesParamVm.movie)
                }, function (error) {
                    console.log(error);
                });

        }
    }

})();
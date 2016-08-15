/**
 * Created by Raguvinoth on 8/14/2016.
 */

(function() {
    'use strict';

    angular.module('movieflix')
        .controller('MovieController', MovieController);

    MovieController.$inject = ['moviesService'];

    function MovieController(moviesService) {
        var moviesVm = this;
        init();

        function init() {
            console.log('MovieController');


            moviesService
                .getMovies()
                .then(function(movies) {
                    moviesVm.movies = movies;
                }, function(error) {
                    console.log(error);
                });
        }
    }

})();
'use strict';

angular.module('registrarApp')
    .controller('NavbarController', function ($scope, $location, $state) {
        $scope.$state = $state;

        $scope.logout = function () {
            $state.go('home');
        };
    });

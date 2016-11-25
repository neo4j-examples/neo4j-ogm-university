'use strict';

angular.module('registrarApp')
    .controller('NavbarController', function ($scope, $location, $state) {
        $scope.isAuthenticated = true;
        $scope.isInRole = true;
        $scope.$state = $state;

        $scope.logout = function () {
            $state.go('home');
        };
    });

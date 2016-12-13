'use strict';

angular.module('registrarApp', ['ngResource', 'ui.router'])

    .run(function ($rootScope, $location, $http, $state) {
        $rootScope.$on('$stateChangeStart', function (event, toState, toStateParams) {
            $rootScope.toState = toState;
            $rootScope.toStateParams = toStateParams;

        });

        $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {
            $rootScope.previousStateName = fromState.name;
            $rootScope.previousStateParams = fromParams;
        });

        $rootScope.back = function () {
            // If previous state is 'activate' or do not exist go to 'home'
            if ($rootScope.previousStateName === 'activate' || $state.get($rootScope.previousStateName) === null) {
                $state.go('home');
            } else {
                $state.go($rootScope.previousStateName, $rootScope.previousStateParams);
            }
        };

        // move this somewhere else
        $rootScope.list = function (iterable) {
            iterable = typeof iterable !== 'undefined' ? iterable : [];
            var values = [];
            for (var i = 0; i < iterable.length; i++) {
                values.push(iterable[i].name);
            }
            return values.join(" ");
        };
    })

    .config(function ($stateProvider, $urlRouterProvider, $httpProvider) {
        //enable CSRF
        $httpProvider.defaults.xsrfCookieName = 'CSRF-TOKEN';
        $httpProvider.defaults.xsrfHeaderName = 'X-CSRF-TOKEN';

        $urlRouterProvider.otherwise('/');
        $stateProvider.state('site', {
            'abstract': true,
            views: {
                'navbar@': {
                    templateUrl: 'navbar.html'
                }
            }
        });
    });

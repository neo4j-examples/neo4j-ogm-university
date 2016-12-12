'use strict';

angular.module('registrarApp', ['ngResource', 'ui.router', 'ngCookies'])

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

        $rootScope.truncate = function (obj, depth) {
//            for (var property in obj) {
//                //console.log("depth: " + depth);
//                //console.log(obj);
//                //console.log("property: " + property);
//                if (property == 'id' || property == 'name' || property == '$promise' || property == '$resolved' || property == '__proto__') {
//                    continue;
//                }
//                if (depth == 0 || property == '$$hashKey') {
//                    console.log("deleting " + property + " from " + obj);
//                    delete obj[property];
//                    //var p = obj[property];
//                    //if (p && p.constructor === Array) {
//                    //    obj[property] = [];
//                    //} else {
//                    //    obj[property] = null;
//                    //}
//                } else {
//                    $rootScope.truncate(obj[property], depth -1);
//                }
//            }
        };

    })

    .config(function ($stateProvider, $urlRouterProvider, $httpProvider) {
        //enable CSRF
        $httpProvider.defaults.xsrfCookieName = 'CSRF-TOKEN';
        $httpProvider.defaults.xsrfHeaderName = 'X-CSRF-TOKEN';

        //Cache everything except api requests

        $urlRouterProvider.otherwise('/');
        $stateProvider.state('site', {
            'abstract': true,
            views: {
                'navbar@': {
                    templateUrl: 'navbar.html',
                    controller: 'NavbarController'
                }
            }
        });
    });

'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('error', {
                parent: 'site',
                url: '/error',
                data: {
                    roles: []
                },
                views: {
                    'content@': {
                        templateUrl: 'error.html'
                    }
                }
            })
            .state('accessdenied', {
                parent: 'site',
                url: '/accessdenied',
                data: {
                    roles: []
                },
                views: {
                    'content@': {
                        templateUrl: 'accessdenied.html'
                    }
                }
            });
    });

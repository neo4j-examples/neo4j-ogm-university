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
            });
    });

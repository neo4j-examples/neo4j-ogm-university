'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('class', {
                parent: 'entity',
                url: '/classes',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'classes.html',
                        controller: 'ClassController'
                    }
                }
            })
            .state('classDetail', {
                parent: 'entity',
                url: '/classes/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'class-detail.html',
                        controller: 'ClassDetailController'
                    }
                }
            });
    });

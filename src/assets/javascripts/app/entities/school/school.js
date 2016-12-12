'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('school', {
                parent: 'entity',
                url: '/school',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'schools.html',
                        controller: 'SchoolController'
                    }
                }
            })
            .state('schoolDetail', {
                parent: 'entity',
                url: '/school/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'school-detail.html',
                        controller: 'SchoolDetailController'
                    }
                }
            });
    });

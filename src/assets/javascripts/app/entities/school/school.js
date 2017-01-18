'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('school', {
                parent: 'entity',
                url: '/school',
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
                views: {
                    'content@': {
                        templateUrl: 'school-detail.html',
                        controller: 'SchoolDetailController'
                    }
                }
            });
    });

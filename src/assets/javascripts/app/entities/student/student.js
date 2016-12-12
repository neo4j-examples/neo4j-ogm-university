'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('student', {
                parent: 'entity',
                url: '/students',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'students.html',
                        controller: 'StudentController'
                    }
                }
            })
            .state('studentDetail', {
                parent: 'entity',
                url: '/students/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'student-detail.html',
                        controller: 'StudentDetailController'
                    }
                }
            });
    });

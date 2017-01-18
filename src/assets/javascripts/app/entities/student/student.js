'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('student', {
                parent: 'entity',
                url: '/students',
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
                views: {
                    'content@': {
                        templateUrl: 'student-detail.html',
                        controller: 'StudentDetailController'
                    }
                }
            });
    });

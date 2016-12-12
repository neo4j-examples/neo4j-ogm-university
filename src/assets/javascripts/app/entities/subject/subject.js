'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('subject', {
                parent: 'entity',
                url: '/subjects',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'subjects.html',
                        controller: 'SubjectController'
                    }
                }
            })
            .state('subjectDetail', {
                parent: 'entity',
                url: '/subjects/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'subject-detail.html',
                        controller: 'SubjectDetailController'
                    }
                }
            });
    });

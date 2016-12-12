'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('studyBuddy', {
                parent: 'entity',
                url: '/studyBuddies',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'studyBuddies.html',
                        controller: 'StudyBuddyController'
                    }
                }
            })
            .state('studyBuddyDetail', {
                parent: 'entity',
                url: '/studyBuddies/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'studyBuddy-detail.html',
                        controller: 'StudyBuddyDetailController'
                    }
                }
            });
    });

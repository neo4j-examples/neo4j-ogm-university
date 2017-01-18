'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('studyBuddy', {
                parent: 'entity',
                url: '/studyBuddies',
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
                views: {
                    'content@': {
                        templateUrl: 'studyBuddy-detail.html',
                        controller: 'StudyBuddyDetailController'
                    }
                }
            });
    });

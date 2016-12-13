'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('statistics', {
                parent: 'entity',
                url: '/popular',
                views: {
                    'content@': {
                        templateUrl: 'statistics.html',
                        controller: 'StatisticsController'
                    }
                }
            })
    });

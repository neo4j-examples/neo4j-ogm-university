'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('department', {
                parent: 'entity',
                url: '/departments',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'departments.html',
                        controller: 'DepartmentController'
                    }
                }
            })
            .state('departmentDetail', {
                parent: 'entity',
                url: '/departments/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'department-detail.html',
                        controller: 'DepartmentDetailController'
                    }
                }
            });
    });

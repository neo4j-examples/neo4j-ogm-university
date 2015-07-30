'use strict';

angular.module('registrarApp')
    .factory('Student', function ($resource, $cacheFactory) {

        var url = 'api/students/:id';
        var cache = $cacheFactory.get('$http');

        var interceptor = {
            response: function (response) {
                cache.remove(response.config.url);
                console.log('cache removed', response.config.url);
                return response;
            }
        };

        return $resource(url, {}, {
            'query'  : { method: 'GET', isArray: true, cache: cache,
                transformResponse: function (data) {
                    var obj = JSOG.parse(data);
                    console.log(obj);
                    return obj;
                }},
            'remove' : { method: 'DELETE', cache: interceptor },
            'delete' : { method: 'DELETE', cache: interceptor },
            'post'   : { method: 'POST', cache: interceptor },
            'get'    : { method: 'GET', cache: cache,
                transformResponse: function (data) {
                    var obj = JSOG.parse(data);
                    console.log(obj);
                    return obj;
                }
            }
        });
    });

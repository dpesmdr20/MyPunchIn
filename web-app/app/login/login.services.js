/**
 * Created by dimanandhar on 8/7/17.
 */
angular.module('login.services',[])
    .factory("loginService", function ($resource) {
        return {
            checkLogin: $resource("http://localhost:9000/MyPunchIn/api/" + 'login/?username=:uname&password=:pass',{},{
                'get': {
                    method: 'GET',
                    timeout: 720000
                }
            })
        }
    });
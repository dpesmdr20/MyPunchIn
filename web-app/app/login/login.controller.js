/**
 * Created by dpesmdr on 8/6/17.
 */
angular.
module('controller',[]).
controller('LoginController',['$scope','$http',function($scope,$http) {
    $scope.login = function (uname, pass) {
        /*loginService.checkLogin.get({
         uname: uname,
         pass: pass,
         }).$promise.then(function (data) {
         $scope.msg = data.message;
         })}*/
        $http({
            url:'/login/username=' + uname + '&password=' + pass,
            method: "GET",
            responseType: 'arraybuffer'
        })
    }
}])

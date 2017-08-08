/**
 * Created by dpesmdr on 8/6/17.
 */
angular.
module('loginController',[]).
controller('LoginController',['$scope','$http',function($scope,$http) {
    $scope.login = function (uname, upass) {
        var rootUrl = "/MyPunchIn"
        /*loginService.checkLogin.get({
         uname: uname,
         pass: pass,
         }).$promise.then(function (data) {
         $scope.msg = data.message;
         })}*/
        $http({
            url:'/login/?username='+uname+'&password='+upass,
            method: "GET"
        });
    }
}]);

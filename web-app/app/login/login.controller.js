/**
 * Created by dpesmdr on 8/6/17.
 */
angular.
module('login',[]).
controller('LoginController',['$scope','$location',function($scope,$location) {
    $scope.myUrl = $location.absUrl();
    var port = 8080;
    $scope.login = function (uname,pass){
        var rootUrl = "http://localhost:"+port+"MyPunchIn/login";
    }
}]);
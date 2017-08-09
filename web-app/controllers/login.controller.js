/**
 * Created by dpesmdr on 8/6/17.
 */
angular.
module('loginController',['punchInController']).
controller('LoginController',['$scope','$http',function($scope,$http) {
    $scope.login = function (uname, upass) {
        $scope.date = new Date();
        $http({
            url:'/login/?username='+uname+'&password='+upass,
            method: "GET"
        })
        .then(function(response) {
            $scope.checkLogin = response.data["login"];
            $scope.showPunchIn = false;
            if($scope.checkLogin=="success")
                $scope.showPunchIn = true;
        });}
}]);

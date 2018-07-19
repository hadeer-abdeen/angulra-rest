var app = angular.module("userManagement", []);
         
            //Controller Part
            app.controller("UserController", function($scope, $http) {
         
               
                $scope.users = [];
                $scope.loginForm = {
                   
                    
                    id :null ,
                	password:""
                };
         
          

                $scope.getUser = function(user) {
                   // alert($scope.loginForm.id);
                    $http({
                        method : 'GET',
                        url : 'rest/users/' + $scope.loginForm.id
                    }).then(function successCallback(response) {
                        $scope.user = response.data;
                       // alert($scope.user.name);
                        if($scope.loginForm.id == $scope.user.id && $scope.loginForm.password == $scope.user.password)
                            { alert("welcome "+ $scope.user.name);}
                        else{
                        	alert("Wrong password"); }
                    }, function errorCallback(response) {
                    	alert("Wrong id ");
                      //  console.log(response.statusText);
                    }).then(_success, _error);
                };
 
         
               
         
                //HTTP GET- get all users collection
                function _refreshUserData() {
                    $http({
                        method : 'GET',
                        url : 'http://localhost:8080/AngularjsJAXRSCRUDExample/rest/users'
                    }).then(function successCallback(response) {
                        $scope.users = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }
         
                function _success(response) {
                	_refreshUserData();
                    
                }
         
                function _error(response) {
                	alert("Wrong id ");
                    console.log(response.statusText);
                }
         
                
            });
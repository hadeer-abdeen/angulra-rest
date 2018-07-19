   var app = angular.module("userManagement", []);
         
            //Controller Part
            app.controller("UserController", function($scope, $http) {
         
               
                $scope.users = [];
                $scope.registerForm = {
                    id : -1,
                    name : "",
                    email : "",
                    password:""
                     
                };
         
                
                $scope.submitUser = function() {
                	 
                    var method = "";
                    var url = "";
                    if ($scope.registerForm.id == -1) {
                        method = "POST";
                        url = 'rest/users';
                    } 
         
                    $http({
                        method : method,
                        url : url,
                        data : angular.toJson($scope.registerForm),
                        headers : {
                            'Content-Type' : 'application/json'
                        }
                    }).then(function successCallback(response) {
                        $scope.user = response.data;
                        // alert($scope.user.id);
                        $scope.successName="registration accepted "+ $scope.registerForm.name+", use this ID ("+$scope.user.id+") to login with it ";
                     }).then( _success, _error );

                  
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
                    _clearFormData()
                }
         
                function _error(response) {
                    console.log(response.statusText);
                }
         
                //Clear the form
                function _clearFormData() {
                    $scope.registerForm.id = -1;
                    $scope.registerForm.name = "";
                    $scope.registerForm.email = "";
                    $scope.registerForm.password = "";
                };
            });
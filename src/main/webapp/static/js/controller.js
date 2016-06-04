App.controller('EmployeeCtrl', ['$scope','$http','EmployeeService',  function($scope,$http, EmployeeService) {

    $scope.employee = {id: null, name: '', surname: '', position: '', salary: '', salaryPerHour: '', numberOfHoursPerMonth: '',  overtime: ''};
    $scope.employees= [];


    $http.get('http://localhost:8080/list/').success(function(data){
        $scope.employees=data;
    });
    
    $scope.addEmployee = function (employee) {
        EmployeeService.addEmployee(employee);
    };

    $scope.submitForm= function(){
        $scope.addEmployee($scope.employee);
        $scope.employees.push($scope.employee);
        $scope.employee = {id: null, name: '', surname: '', position: '', salary: '', salaryPerHour: '', numberOfHoursPerMonth: '',  overtime: ''};
        $scope.myForm.$setPristine();
    };

}]);
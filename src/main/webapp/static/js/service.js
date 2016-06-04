App.factory('EmployeeService', ['$http', '$q', function($http, $q) {

    return {

        addEmployee: function (employee) {
            return $http.post('http://localhost:8080/add/', employee)
                .then(
                    function (data) {
                        return data;
                    },
                    function (errResponse) {
                        console.error('Error while creating user');
                        return $q.reject(errResponse);
                    }
                );
        }

    }
}

]);
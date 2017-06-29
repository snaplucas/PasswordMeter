var host_app = "http://localhost:8888";
var app = angular.module('password_app', []);

app.controller("passwordController", function($scope, $http, PasswordService) {
	$scope.form = {};
	$scope.passwordMetter = {}
	$scope.passwordAction = function() {
		var password = $scope.form.password;
        PasswordService.postPassword(password).then(function(dados) {
            $scope.passwordMetter = dados;
            $scope.labelPontuacao = labelPontuacao($scope.passwordMetter.pontuacao)
            $scope.labelComplexidade = labelComplexidade($scope.passwordMetter.complexidade)
        });
	}
	$scope.passwordAction();
});

function labelPontuacao(pontuacao){
    if (pontuacao < 12) {
        return "label-default";
    } else if (pontuacao < 24) {
        return "label-danger";
    } else if (pontuacao < 36) {
        return "label-warning";
    } else if (pontuacao < 74) {
        return "label-info";
    } else if (pontuacao < 86) {
        return "label-success";
    } else {
        return "label-primary";
    }
}

function labelComplexidade(complexidade) {
    if (complexidade == "MUITO_FRACA") {
        return "label-danger";
    } else if (complexidade == "FRACA") {
        return "label-warning";
    } else if (complexidade == "BOA") {
        return "label-info";
    } else if (complexidade == "FORTE") {
        return "label-success";
    } else {
        return "label-primary";
    }
}

app.service('PasswordService', function($http) {
	var service = {};
	service.postPassword = function(password) {
		return $http.post(host_app + '/password', password).then(
				function sucesso(response) {
					var dados = {}
					if (response.status == 200) {
						dados = response.data;
					}
					return dados;
				}, function erro(response) {
					alert("Erro ao se comunicar com a api");
				});
	}
	return service;
});
var host_app = "http://localhost:8888";
var app = angular.module('password_app', []);

app.controller("passwordController", function($scope, $http, service) {
	$scope.form = {};
	$scope.passwordDto = {}
	$scope.eventoTexto = function() {
		var password = $scope.form.password;
        service.postPassword(password).then(function(dados) {
            $scope.passwordDto = dados;
            $scope.labelPontuacao = labelPontuacao($scope.passwordDto.pontuacao)
            $scope.labelComplexidade = labelComplexidade($scope.passwordDto.complexidade)
        });
	}
	$scope.eventoTexto();
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

app.service('service', function($http) {
	var service = {};
	service.postPassword = function(password) {
		return $http.post(host_app + '/password', password).then(
				function sucesso(resposta) {
					var dados = {}
					if (resposta.status == 200) {
						dados = resposta.data;
					}
					return dados;
				}, function erro(resposta) {
					alert("Erro ao se comunicar com a api");
				});
	}
	return service;
});
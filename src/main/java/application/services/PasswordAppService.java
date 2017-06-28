package application.services;

import application.dto.PasswordDto;
import application.enumeradores.Complexidade;
import application.interfaces.IPasswordAppService;
import domain.model.entities.Password;
import domain.model.entities.ValidacaoPassword;
import domain.model.interfaces.IPasswordService;

public class PasswordAppService implements IPasswordAppService {

    private final IPasswordService passwordService;

    public PasswordAppService(IPasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @Override
    public PasswordDto avaliarPassword(String texto) {
        Password password = new Password(texto);
        ValidacaoPassword validacaoPassword = passwordService.avaliarPassword(password);
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setRegras(validacaoPassword.getRegras());
        passwordDto.setPontuacao(limitesPontuacao(validacaoPassword.calcularPontuacaoTotal()));
        passwordDto.setComplexidade(calcularComplexidade(passwordDto.getPontuacao()));

        return passwordDto;
    }

    private double limitesPontuacao(double pontuacao) {
        if (pontuacao > 100) {
            return 100;
        } else if (pontuacao < 0) {
            return 0;
        }
        return pontuacao;
    }

    private Complexidade calcularComplexidade(double pontuacao) {
        Complexidade complexidade;
        if (pontuacao < 20) {
            complexidade = Complexidade.MUITO_FRACA;
        } else if (pontuacao < 40) {
            complexidade = Complexidade.FRACA;
        } else if (pontuacao < 60) {
            complexidade = Complexidade.BOA;
        } else if (pontuacao < 80) {
            complexidade = Complexidade.FORTE;
        } else {
            complexidade = Complexidade.MUITO_FORTE;
        }
        return complexidade;
    }
}

package application.services;

import application.dto.PasswordDto;
import application.enumeradores.Complexidade;
import application.interfaces.IPasswordAppService;
import domain.model.interfaces.IPasswordService;

public class PasswordAppService implements IPasswordAppService {

    private final IPasswordService passwordService;

    public PasswordAppService(IPasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @Override
    public PasswordDto avaliarPassword(String password) {

        return new PasswordDto();
    }

    private Complexidade calcularComplexidade(int pontuacao) {
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

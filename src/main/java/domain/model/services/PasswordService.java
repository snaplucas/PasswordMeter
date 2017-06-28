package domain.model.services;

import domain.model.entities.Password;
import domain.model.entities.ValidacaoPassword;
import domain.model.interfaces.IPasswordService;

public class PasswordService implements IPasswordService {

    @Override
    public ValidacaoPassword avaliarPassword(String texto) {
        Password password = new Password(texto);
        return new ValidacaoPassword(password);
    }
}

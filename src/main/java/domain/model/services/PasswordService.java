package domain.model.services;

import domain.model.entities.Password;
import domain.model.interfaces.IPasswordService;

public class PasswordService implements IPasswordService {

    @Override
    public Password avaliarPassword(String password) {
        return new Password("");
    }
}

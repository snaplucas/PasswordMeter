package application.services;

import application.dto.PasswordDto;
import application.interfaces.IPasswordAppService;

public class PasswordAppService implements IPasswordAppService {

    @Override
    public PasswordDto avaliarPassword(String password) {
        return new PasswordDto();
    }
}

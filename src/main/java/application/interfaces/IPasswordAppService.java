package application.interfaces;

import application.dto.PasswordDto;

public interface IPasswordAppService {

    PasswordDto avaliarPassword(String password);
}

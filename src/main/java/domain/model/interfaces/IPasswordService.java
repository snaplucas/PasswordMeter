package domain.model.interfaces;

import domain.model.entities.Password;
import domain.model.entities.ValidacaoPassword;

public interface IPasswordService {

    ValidacaoPassword avaliarPassword(Password password);
}

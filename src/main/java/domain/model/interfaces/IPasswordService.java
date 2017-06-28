package domain.model.interfaces;

import domain.model.entities.ValidacaoPassword;

public interface IPasswordService {

    ValidacaoPassword avaliarPassword(String password);
}

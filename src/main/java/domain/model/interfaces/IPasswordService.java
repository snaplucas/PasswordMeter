package domain.model.interfaces;

import domain.model.entities.Password;
import domain.model.specifications.Regra;

import java.util.List;

public interface IPasswordService {

    double calcularPontuacaoTotal(Password password);

    List<Regra> getRegras();
}

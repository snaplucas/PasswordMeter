package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class CaracteresRepetidos extends Regra {

    public CaracteresRepetidos(String descricao, TipoRegra tipoRegra, Password password) {
        super(descricao, tipoRegra, password);
    }

    @Override
    public long obterQuantidade() {
        return 0;
    }

    @Override
    public double calcularPontuacao() {
        return 0;
    }
}

package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class SomenteNumeros extends Regra {

    public SomenteNumeros(String descricao, TipoRegra tipoRegra, Password password) {
        super(descricao, tipoRegra, password);
    }

    @Override
    public long obterQuantidade() {
        if (password.totalNumeros() == password.totalCaracteres()) {
            return password.totalNumeros();
        }
        return 0;
    }

    @Override
    public double calcularPontuacao() {
        if (password.totalNumeros() == password.totalCaracteres()) {
            return password.totalNumeros();
        }
        return 0;
    }
}

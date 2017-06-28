package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class SomenteLetras extends Regra {

    public SomenteLetras(String descricao, TipoRegra tipoRegra, Password password) {
        super(descricao, tipoRegra, password);
    }

    @Override
    public long obterQuantidade() {
        if (password.totalLetras() == password.totalCaracteres()) {
            return password.totalNumeros();
        }
        return 0;
    }

    @Override
    public double calcularPontuacao() {
        if (password.totalLetras() == password.totalCaracteres()) {
            return password.totalLetras();
        }
        return 0;
    }
}
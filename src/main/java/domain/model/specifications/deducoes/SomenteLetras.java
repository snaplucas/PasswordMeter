package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class SomenteLetras extends Regra {

    public SomenteLetras(String descricao, TipoRegra tipoRegra) {
        super(descricao, tipoRegra);
    }

    @Override
    public long obterQuantidade(Password password) {
        if (password.totalLetras() == password.totalCaracteres()) {
            return password.totalLetras();
        }
        return 0;
    }

    @Override
    public double calcularPontuacao(Password password) {
        if (password.totalLetras() == password.totalCaracteres()) {
            return password.totalLetras();
        }
        return 0;
    }
}
package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class NumeroCaracteres extends Regra {

    public NumeroCaracteres(String descricao, TipoRegra tipoRegra) {
        super(descricao, tipoRegra);
    }

    @Override
    public long obterQuantidade(Password password) {
        return password.totalCaracteres();
    }

    @Override
    public double calcularPontuacao(Password password) {
        return password.totalCaracteres() * 4;
    }
}

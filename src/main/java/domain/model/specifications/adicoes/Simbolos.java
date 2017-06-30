package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class Simbolos extends Regra {

    public Simbolos(String descricao, TipoRegra tipoRegra) {
        super(descricao, tipoRegra);
    }

    @Override
    public long obterQuantidade(Password password) {
        return password.totalSimbolos();
    }

    @Override
    public double calcularPontuacao(Password password) {
        return password.totalSimbolos() * 6;
    }
}

package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class Simbolos extends Regra {

    public Simbolos(String descricao, TipoRegra tipoRegra, Password password) {
        super(descricao, tipoRegra, password);
    }

    @Override
    public long obterQuantidade() {
        return password.totalSimbolos();
    }

    @Override
    public double calcularPontuacao() {
        return password.totalSimbolos() * 6;
    }
}

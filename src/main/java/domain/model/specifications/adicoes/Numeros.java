package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class Numeros extends Regra {

    public Numeros(String descricao, TipoRegra tipoRegra) {
        super(descricao, tipoRegra);
    }

    @Override
    public long obterQuantidade(Password password) {
        return password.totalNumeros();
    }

    @Override
    public double calcularPontuacao(Password password) {
        if (password.totalCaracteres() != password.totalNumeros()) return password.totalNumeros() * 4;
        return 0;
    }
}

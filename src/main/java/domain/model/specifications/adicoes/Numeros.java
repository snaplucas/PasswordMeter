package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class Numeros extends Regra {

    public Numeros(String descricao, TipoRegra tipoRegra, Password password) {
        super(descricao, tipoRegra, password);
    }

    @Override
    public long obterQuantidade() {
        return password.totalNumeros();
    }

    @Override
    public double calcularPontuacao() {
        if (password.totalCaracteres() != password.totalNumeros()) return password.totalNumeros() * 4;
        return 0;
    }
}

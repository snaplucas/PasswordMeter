package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class NumerosConsecutivos extends Regra {
    public NumerosConsecutivos(String descricao, TipoRegra tipoRegra, Password password) {
        super(descricao, tipoRegra, password);
    }

    @Override
    public long obterQuantidade() {
        int ocorrencias = 0;
        int numeros = -1;

        for (Character c : password.getCaracteres()) {
            if (Character.isDigit(c)) {
                numeros++;
            } else {
                numeros = -1;
            }
            if (numeros > 0) {
                ocorrencias++;
            }
        }
        return ocorrencias;
    }

    @Override
    public double calcularPontuacao() {
        return obterQuantidade() * 2;
    }
}

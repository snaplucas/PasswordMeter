package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class LetrasConsecutivasMinusculas extends Regra {

    public LetrasConsecutivasMinusculas(String descricao, TipoRegra tipoRegra) {
        super(descricao, tipoRegra);
    }

    @Override
    public long obterQuantidade(Password password) {
        int ocorrencias = 0;
        int minusculas = -1;

        for (Character c : password.getCaracteres()) {
            if (Character.isLowerCase(c)) {
                minusculas++;
            } else {
                minusculas = -1;
            }
            if (minusculas > 0) {
                ocorrencias++;
            }
        }
        return ocorrencias;
    }

    @Override
    public double calcularPontuacao(Password password) {
        return obterQuantidade(password) * 2;
    }
}

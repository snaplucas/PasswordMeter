package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class LetrasConsecutivasMaiusculas extends Regra {

    public LetrasConsecutivasMaiusculas(String descricao, TipoRegra tipoRegra, Password password) {
        super(descricao, tipoRegra, password);
    }

    @Override
    public long obterQuantidade() {
        int ocorrencias = 0;
        int maiusculas = -1;

        for (Character c : password.getCaracteres()) {
            if (Character.isUpperCase(c)) {
                maiusculas++;
            } else {
                maiusculas = -1;
            }
            if (maiusculas > 0) {
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

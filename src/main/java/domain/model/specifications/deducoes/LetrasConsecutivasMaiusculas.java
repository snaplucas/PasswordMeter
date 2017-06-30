package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class LetrasConsecutivasMaiusculas extends Regra {

    public LetrasConsecutivasMaiusculas(String descricao, TipoRegra tipoRegra) {
        super(descricao, tipoRegra);
    }

    @Override
    public long obterQuantidade(Password password) {
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
    public double calcularPontuacao(Password password) {
        return obterQuantidade(password) * 2;
    }
}

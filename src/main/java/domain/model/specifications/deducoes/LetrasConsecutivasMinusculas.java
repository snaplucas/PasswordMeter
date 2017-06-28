package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

import java.util.List;

public class LetrasConsecutivasMinusculas extends Regra {

    public LetrasConsecutivasMinusculas(String descricao, TipoRegra tipoRegra, Password password) {
        super(descricao, tipoRegra, password);
    }

    private double ocorrencias(List<Character> caracteres) {
        int ocorrencias = 0;
        int minusculas = -1;

        for (Character c : caracteres) {
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
    public long obterQuantidade() {
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
    public double calcularPontuacao() {
        return obterQuantidade() * 2;
    }
}

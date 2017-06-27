package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import port.adapter.specification.pattern.interfaces.ISpecification;

import java.util.List;

public class LetrasConsecutivasMaiusculas implements ISpecification<Password> {
    @Override
    public boolean isSatisfiedBy(Password entity) {
        return true;
    }

    @Override
    public double calcularPontuacao(Password entity) {
        return -(ocorrencias(entity.getCaracteres()) * 2);
    }

    private double ocorrencias(List<Character> caracters) {
        int ocorrencias = 0;
        int maiusculas = -1;

        for (Character c :caracters) {
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
}

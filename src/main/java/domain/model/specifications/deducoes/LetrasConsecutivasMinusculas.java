package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import port.adapter.specification.pattern.interfaces.ISpecification;

import java.util.List;

public class LetrasConsecutivasMinusculas implements ISpecification<Password> {

    @Override
    public boolean isSatisfiedBy(Password entity) {
        return true;
    }

    @Override
    public double calcularPontuacao(Password entity) {
        return -(ocorrencias(entity.getCaracteres()) * 2);
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
}

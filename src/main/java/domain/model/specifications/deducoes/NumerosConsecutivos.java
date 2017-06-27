package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import port.adapter.specification.pattern.interfaces.ISpecification;

import java.util.List;

public class NumerosConsecutivos implements ISpecification<Password> {
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
        int numeros = -1;

        for (Character c : caracteres) {
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
}

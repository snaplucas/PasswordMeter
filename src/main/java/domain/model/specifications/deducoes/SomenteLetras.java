package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import port.adapter.specification.pattern.interfaces.ISpecification;

public class SomenteLetras implements ISpecification<Password> {
    @Override
    public boolean isSatisfiedBy(Password entity) {
        return entity.numeros() == 0 && entity.simbolos() == 0;
    }

    @Override
    public double calcularPontuacao(Password entity) {
        return -(entity.totalCaracteres());
    }
}

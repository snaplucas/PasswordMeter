package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import port.adapter.specification.pattern.interfaces.ISpecification;

public class NumeroCaracteres implements ISpecification<Password> {

    @Override
    public boolean isSatisfiedBy(Password entity) {
        return entity.totalCaracteres() >= 8;
    }

    @Override
    public double calcularPontuacao(Password entity) {
        return entity.totalCaracteres() * 4;
    }
}

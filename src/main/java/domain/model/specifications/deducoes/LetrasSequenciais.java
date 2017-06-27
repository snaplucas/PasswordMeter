package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import port.adapter.specification.pattern.interfaces.ISpecification;

public class LetrasSequenciais implements ISpecification<Password> {


    @Override
    public boolean isSatisfiedBy(Password entity) {
        return false;
    }

    @Override
    public double calcularPontuacao(Password entity) {
        return 0;
    }
}

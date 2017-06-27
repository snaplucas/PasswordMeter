package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import port.adapter.specification.pattern.interfaces.ISpecification;

public class SomenteNumeros implements ISpecification<Password> {
    @Override
    public boolean isSatisfiedBy(Password entity) {
        return entity.numeros() == entity.totalCaracteres();
    }

    @Override
    public double calcularPontuacao(Password entity) {
        return -(entity.numeros());
    }
}

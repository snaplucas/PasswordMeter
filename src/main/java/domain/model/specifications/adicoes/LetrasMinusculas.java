package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import port.adapter.specification.pattern.interfaces.ISpecification;

public class LetrasMinusculas implements ISpecification<Password> {
    @Override
    public boolean isSatisfiedBy(Password entity) {
        return entity.letrasMinusculas() > 0;
    }

    @Override
    public double calcularPontuacao(Password entity) {
        return (entity.tamanhoTexto() - entity.letrasMinusculas()) * 2;
    }
}

package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import port.adapter.specification.pattern.interfaces.ISpecification;

public class Requisitos implements ISpecification<Password> {

    @Override
    public boolean isSatisfiedBy(Password entity) {
        int itensRequeridos = 0;
        itensRequeridos += entity.totalLetrasMaiusculas() > 0 ? 1 : 0;
        itensRequeridos += entity.totalLetrasMinusculas() > 0 ? 1 : 0;
        itensRequeridos += entity.totalNumeros() > 0 ? 1 : 0;
        itensRequeridos += entity.totalSimbolos() > 0 ? 1 : 0;

        return entity.totalCaracteres() >= 8 && itensRequeridos >= 3;
    }

    @Override
    public double calcularPontuacao(Password entity) {
        return 0;
    }
}

package port.adapter.specification.pattern;

import port.adapter.specification.pattern.interfaces.IRule;
import port.adapter.specification.pattern.interfaces.ISpecification;

public class Rule<T> implements IRule<T> {

    private final ISpecification<T> spec;

    private final String mensagemErro;

    public Rule(ISpecification<T> spec, String mensagemErro) {
        this.spec = spec;
        this.mensagemErro = mensagemErro;
    }

    public String mensagemErro() {
        return mensagemErro;
    }

    public boolean validar(T entity) {
        return spec.isSatisfiedBy(entity);
    }
}

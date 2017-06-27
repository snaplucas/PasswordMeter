package port.adapter.specification.pattern.interfaces;

public interface ISpecification<T> {

    boolean isSatisfiedBy(T entity);

    double calcularPontuacao(T entity);
}

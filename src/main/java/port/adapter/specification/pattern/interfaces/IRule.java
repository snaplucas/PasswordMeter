package port.adapter.specification.pattern.interfaces;

public interface IRule<T> {

    boolean validar(T entity);

    String mensagemErro();
}

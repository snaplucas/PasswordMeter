package port.adapter.specification.pattern.interfaces;

import port.adapter.specification.pattern.ValidationResult;

public interface IValidation<T> {

    ValidationResult Validar(T entity);
}

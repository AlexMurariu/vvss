package Lab3VVSS.Validator;

import Lab3VVSS.Exceptions.ValidatorException;

public interface IValidator<E> {
    void validate(E entity) throws ValidatorException;
}
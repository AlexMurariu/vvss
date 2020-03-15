package Lab3VVSS.Repository.MemoryRepository;

import Lab3VVSS.Domain.Nota;
import Lab3VVSS.Validator.IValidator;

public class NotaRepo extends AbstractCrudRepo<Integer, Nota> {
    public NotaRepo(IValidator<Nota> v){ super(v);
    }
}
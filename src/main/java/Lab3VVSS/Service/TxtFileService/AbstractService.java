package Lab3VVSS.Service.TxtFileService;

import Lab3VVSS.Domain.HasId;
import Lab3VVSS.Exceptions.ValidatorException;
import Lab3VVSS.Repository.TxtFileRepository.AbstractFileRepository;
import Lab3VVSS.Validator.IValidator;

public abstract  class AbstractService <ID,E extends HasId<ID>> {
    private IValidator<E> v;
    private AbstractFileRepository<ID,E> repo;
    public AbstractService(AbstractFileRepository repo){
        this.repo=repo;
    }
    //@Override
    public void add(String[] params) throws ValidatorException {
        E entity = repo.extractEntity(params);
        repo.save(entity);
    }
    public void del(ID id) throws ValidatorException {
        //E entity = repo.extractEntity(params);
        repo.delete(id);
    }
    public void upd(String[] params) throws ValidatorException {
        E entity = repo.extractEntity(params);
        repo.update(entity);
    }
    public Iterable<E> getAll(){
        return repo.findAll();
    }
    public E getById(ID id){
        return repo.findOne(id);
    }
    public int size(){
        return (int) repo.size();
    }

}


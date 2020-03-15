package Lab3VVSS.Repository.MemoryRepository;

import Lab3VVSS.Domain.HasId;
import Lab3VVSS.Exceptions.ValidatorException;
import Lab3VVSS.Repository.Repo;
import Lab3VVSS.Validator.IValidator;

import java.util.*;
public abstract class AbstractCrudRepo<ID,E extends HasId<ID>> implements Repo<ID,E> {
    Map<ID,E> entityes;
    IValidator<E> validator;
    public AbstractCrudRepo(IValidator v){
        entityes=new HashMap<ID,E>();
        validator=v;
    }
    @Override
    public E findOne(ID id){
        if (entityes.get(id)==null){
            return null;
        }else{
            if(id==null){
                throw new IllegalArgumentException();
            }else{
                return entityes.get(id);
            }
        }

    }

    @Override
    public Iterable<E> findAll(){
        return entityes.values();
    }
    @Override
    public E save(E entity) throws ValidatorException {
        if(entity==null){
            throw new IllegalArgumentException("Entity can not be null!\n");
        }
        validator.validate(entity);
        return entityes.putIfAbsent(entity.getId(),entity);
    }
    @Override
    public E delete(ID id){
        return entityes.remove(id);
    }
    @Override
    public E update(E entity) throws ValidatorException {
        if (entity == null) {
            throw new IllegalArgumentException("Entity can not be null!\n");
        } else {
            validator.validate(entity);
            return entityes.replace(entity.getId(), entity);
        }
    }
    //@Override
    public long size(){
        return entityes.size();
    }

}
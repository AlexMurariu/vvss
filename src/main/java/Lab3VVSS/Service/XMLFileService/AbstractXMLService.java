package Lab3VVSS.Service.XMLFileService;

import Lab3VVSS.Domain.HasId;
import Lab3VVSS.Domain.Student;
import Lab3VVSS.Exceptions.ValidatorException;
import Lab3VVSS.Repository.XMLFileRepository.NotaXMLRepo;
import Lab3VVSS.Repository.XMLFileRepository.StudentXMLRepo;


public abstract class AbstractXMLService<ID,E extends HasId<ID>> {
    private StudentXMLRepo xmlrepo;

    public AbstractXMLService()  {
        this.xmlrepo = this.xmlrepo;
    }

    public AbstractXMLService(NotaXMLRepo xmlrepo) {

    }

    protected abstract E extractEntity(String[] params);
        //return new Student(params[0],params[1],Integer.parseInt(params[2]),params[3],params[4]);
    //}

    public void add(String params[]) throws ValidatorException {
        E e=extractEntity(params);
        xmlrepo.save((Student) e);
    }
    public void remove(ID id){
        xmlrepo.delete((String) id);
    }
    public void update(String params[]) throws ValidatorException {
        E s=extractEntity(params);
        xmlrepo.update((Student) s);
    }
    public E findOne(ID id){
        return (E) xmlrepo.findOne((String) id);
    }
    public Iterable<E>findAll(){
        return (Iterable<E>) xmlrepo.findAll();
    }
    public int getSize(){
        return xmlrepo.getSize();
    }
}
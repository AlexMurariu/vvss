package Lab3VVSS.Service.XMLFileService;

import Lab3VVSS.Domain.TemaLab;
import Lab3VVSS.Exceptions.ValidatorException;
import Lab3VVSS.Repository.XMLFileRepository.TemaLabXMLRepo;

public class TemaLabXMLService{
    private TemaLabXMLRepo xmlrepo;

    public TemaLabXMLService(TemaLabXMLRepo _xmlrepo)  {
        this.xmlrepo = _xmlrepo;
    }

    public void prelungireTemaLab(int nr,String descr,int sl,int sp,int sc) throws ValidatorException {
            xmlrepo.update(new TemaLab(nr, descr, sl, sp));
    }
    protected TemaLab extractEntity(String[] params){
        return new TemaLab(Integer.parseInt(params[0]),params[1],Integer.parseInt(params[2]),Integer.parseInt(params[3]));
    }

    public void add(TemaLab temaLab) throws ValidatorException {
        xmlrepo.save(temaLab);
    }

    public void remove(Integer id) throws ValidatorException {
        xmlrepo.delete(id);
    }

    public TemaLab findOne(int id){
        return xmlrepo.findOne(id);
    }

}
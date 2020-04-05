package Lab3VVSS.Service.TxtFileService;

import Lab3VVSS.Domain.TemaLab;
import Lab3VVSS.Exceptions.ValidatorException;
import Lab3VVSS.Repository.MemoryRepository.TemaLabRepo;

public class TemaLabService {
    TemaLabRepo temaRepo;
    public TemaLabService(TemaLabRepo tmLbRepo){
        this.temaRepo = tmLbRepo;
    }

//    public void prelungireTemaLab(String nr,String descr,String sl,String sp,int sc) throws ValidatorException {
//        if(sc<=Integer.parseInt(sp)){
//            String sln=Integer.toString(Integer.parseInt(sl)+1) ;
//            String[] params={nr,descr,sln,sp};
//            temaRepo.update(params);
//        }
//    }

    public TemaLab add(TemaLab s) throws ValidatorException {
        return temaRepo.save(s);
    }

    /***
     * sterge tema
     * @param id
     * @return tema stearsa
     */
    public TemaLab del(Integer id){
        return temaRepo.delete(id);
    }

    /***
     * Modifica tema
     * @param s
     * @return tema modificata
     */
    public TemaLab mod(TemaLab s){
        return temaRepo.update(s);
    }

    /***
     * Cauta tema dupa id
     * @param id
     * @return tema gasita
     */
    public TemaLab find(Integer id){
        return temaRepo.findOne(id);
    }

    /***
     * @return temele
     */
    public Iterable<TemaLab> all(){
        return temaRepo.findAll();
    }
}

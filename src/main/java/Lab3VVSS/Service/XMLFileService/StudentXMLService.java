package Lab3VVSS.Service.XMLFileService;

import Lab3VVSS.Domain.Student;
import Lab3VVSS.Domain.TemaLab;
import Lab3VVSS.Exceptions.ValidatorException;
import Lab3VVSS.Repository.XMLFileRepository.StudentXMLRepo;

public class StudentXMLService{
    private StudentXMLRepo xmlrepo;

    public StudentXMLService(StudentXMLRepo _xmlrepo)  {
        this.xmlrepo = _xmlrepo;
    }

//    protected Student extractEntity(String[] params){
//        int grupa=0;
//        try{
//            grupa=Integer.parseInt(params[2]);
//        }catch(NumberFormatException ex){
//            System.out.println(ex.getMessage());
//        }
//        return new Student(params[0],params[1],grupa,params[3],params[4]);
//    }

    public void add(Student temaLab) throws ValidatorException {
        this.xmlrepo.save(temaLab);
    }

    public void remove(Integer id){
        xmlrepo.delete(id);
    }

    public void update(Student stud) {xmlrepo.update(stud);}

}
package Lab3VVSS.Service.TxtFileService;

import Lab3VVSS.Domain.Student;
import Lab3VVSS.Repository.TxtFileRepository.StudentFileRepo;
import Lab3VVSS.Service.TxtFileService.AbstractService;

public class StudentService extends AbstractService<String, Student> {
    //StudentFileRepo stdRepo;
    public StudentService(StudentFileRepo stdRepo){
        super(stdRepo);
    }
    /*
    @Override
    public Student extractEntity(String[] info){
        return new Student("","",2,"","");
    }
    */
}



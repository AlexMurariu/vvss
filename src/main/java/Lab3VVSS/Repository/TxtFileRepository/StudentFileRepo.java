package Lab3VVSS.Repository.TxtFileRepository;

import Lab3VVSS.Domain.HasId;
import Lab3VVSS.Domain.Student;
import Lab3VVSS.Validator.StudentValidator;

import java.io.*;

public class StudentFileRepo extends AbstractFileRepository {
    public StudentFileRepo(String filename, StudentValidator val) throws IOException {
        super(val, filename);
    }


    @Override
    public HasId extractEntity(String[] info) {
        String id = info[0];
        String nume = info[1];
        int grup = Integer.parseInt(info[2]);
        String email = info[3];
        String indrumator = info[4];
        Student s = new Student(Integer.parseInt(id), nume, grup, email, indrumator);
        return s;

    }
}
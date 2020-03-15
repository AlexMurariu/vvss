package Lab3VVSS.Repository.MemoryRepository;

import Lab3VVSS.Domain.Student;
import Lab3VVSS.Validator.IValidator;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}
package Lab3VVSS.Validator;

import Lab3VVSS.Domain.Student;
import Lab3VVSS.Exceptions.ValidatorException;

public class StudentValidator implements IValidator<Student> {

    public void validate(Student s) throws ValidatorException {
        String errors="";
        if(s.getId() == null || s.getId() < 0){
            //throw new ValidatorException("Id invalid\n");
            errors+="Id invalid\n";
        }
        if( s.getNume()==null || s.getNume().equals("") || s.getNume().matches(".*\\d.*")){
            //throw new ValidatorException("Nume invalid\n");
            errors+="Nume invalid\n";
        }
        if(s.getGrupa() == null || s.getGrupa()<=100 || s.getGrupa() > 999){
            //throw new ValidatorException("Grupa invalida\n");
            errors+="Grupa invalid\n";
        }
        if(s.getEmail()==null || s.getEmail().equals("")){
            //throw new ValidatorException("Email invalid\n");
            errors+="Email invalid\n";
        }
        if (s.getIndrumator() == null || s.getIndrumator().matches(".*\\d.*")) {
            errors+="Indrumator invalid\n";
        }
        if (errors.length()!=0){
            throw  new ValidatorException(errors);
        }
    }
}
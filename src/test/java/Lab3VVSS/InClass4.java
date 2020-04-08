package Lab3VVSS;

import Lab3VVSS.Domain.Nota;
import Lab3VVSS.Domain.Student;
import Lab3VVSS.Domain.TemaLab;
import Lab3VVSS.Exceptions.ValidatorException;
import Lab3VVSS.Repository.TxtFileRepository.StudentFileRepo;
import Lab3VVSS.Repository.XMLFileRepository.NotaXMLRepo;
import Lab3VVSS.Repository.XMLFileRepository.StudentXMLRepo;
import Lab3VVSS.Repository.XMLFileRepository.TemaLabXMLRepo;
import Lab3VVSS.Service.XMLFileService.NotaXMLService;
import Lab3VVSS.Service.XMLFileService.StudentXMLService;
import Lab3VVSS.Service.XMLFileService.TemaLabXMLService;
import Lab3VVSS.Validator.NotaValidator;
import Lab3VVSS.Validator.StudentValidator;
import Lab3VVSS.Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;
import static junit.framework.TestCase.assertEquals;

public class InClass4 {

    private StudentXMLRepo studentRepo;
    private TemaLabXMLRepo temaRepo;
    private NotaXMLRepo notaRepo;
    private StudentXMLService studentXml;
    private TemaLabXMLService temaXml;
    private NotaXMLService notaXml;


    @Before
    public void setup() throws Exception {
        StudentValidator studentValidator = new StudentValidator();
        TemaLabValidator temaValidator = new TemaLabValidator();
        NotaValidator notaValidator = new NotaValidator();

        studentRepo = new StudentXMLRepo(studentValidator, "testStudenti.xml");
        temaRepo = new TemaLabXMLRepo(temaValidator, "testTeme.xml");
        notaRepo = new NotaXMLRepo(notaValidator, "testNote.xml");
        Student stud = new Student("1", "Birhan", 935, "mbie2368@scs.ubbcluj.ro", "Radu Dragos");
        TemaLab tema = new TemaLab(1, "Ceva descriere", 10, 12);
        studentXml = new StudentXMLService(studentRepo);
        temaXml = new TemaLabXMLService(temaRepo);
        notaXml = new NotaXMLService(notaRepo);
        studentXml.add(stud);
        temaXml.add(tema);
    }

    @Test
    public void addStudentTest() throws ValidatorException {
        Student stud = new Student("2", "Alex", 935, "mail@mail.mail", "Radu Dragos");
        studentXml.add(stud);
        assertEquals(studentRepo.size(), 2);
    }

    @Test
    public void addTemaTest() throws ValidatorException {
        TemaLab tema = new TemaLab(2, "Alta descriere", 10, 12);
        temaXml.add(tema);
        assertEquals(temaRepo.size(), 2);
    }

    @Test
    public void addNotaTest() throws ValidatorException {
        Nota nota = new Nota(1, "1", 1, 10, LocalDateTime.of(2017, 1, 14, 10, 34));
        notaXml.add(nota);
        assertEquals(notaRepo.size(), 1);
    }

    @Test
    public void addAllTest() throws ValidatorException {
        Student stud = new Student("2", "Birhan", 935, "mbie2368@scs.ubbcluj.ro", "Radu Dragos");
        studentXml.add(stud);
        assertEquals(studentRepo.size(), 2);

        TemaLab tema = new TemaLab(2, "Ceva descriere", 10, 12);
        temaXml.add(tema);
        assertEquals(temaRepo.size(), 2);

        Nota nota = new Nota(1, "1", 1, 10, LocalDateTime.of(2017, 1, 14, 10, 34));
        notaXml.add(nota);
        assertEquals(notaRepo.size(), 1);
    }
}

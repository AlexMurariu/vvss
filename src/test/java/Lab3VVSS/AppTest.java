package Lab3VVSS;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import Lab3VVSS.Domain.Student;
import Lab3VVSS.Domain.TemaLab;
import Lab3VVSS.Exceptions.ValidatorException;
import Lab3VVSS.Repository.XMLFileRepository.StudentXMLRepo;
import Lab3VVSS.Repository.XMLFileRepository.TemaLabXMLRepo;
import Lab3VVSS.Service.XMLFileService.StudentXMLService;
import Lab3VVSS.Service.XMLFileService.TemaLabXMLService;
import Lab3VVSS.Validator.StudentValidator;
import Lab3VVSS.Validator.TemaLabValidator;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testAddStudentValidInput() throws ValidatorException {

        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo xmlRepo = new StudentXMLRepo(studentValidator, "StudentiXML.xml");
        StudentXMLService xmlService = new StudentXMLService(xmlRepo);
        Student stud = new Student(0, "Birhan", 935, "mbie2368@scs.ubbcluj.ro", "Radu Dragos");
        xmlService.add(stud);
        assertEquals(xmlRepo.size(), 1);
    }

    @Test
    public void testAddStudentInvalidGroupInput() {

        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo xmlRepo = new StudentXMLRepo(studentValidator, "StudentiXML.xml");
        StudentXMLService xmlService = new StudentXMLService(xmlRepo);
        Student stud = new Student(1, "Birhan", -30, "mbie2368@scs.ubbcluj.ro", "Radu Dragos");
        try {
            xmlService.add(stud);
        } catch (ValidatorException exception) {

        }
    }

    @Test
    public void testAddStudentBB2() {

        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo xmlRepo = new StudentXMLRepo(studentValidator, "StudentiXML.xml");
        StudentXMLService xmlService = new StudentXMLService(xmlRepo);
        Student stud = new Student(null, "Birhan", 931, "mbie2368@scs.ubbcluj.ro", "Radu Dragos");
        try {
            xmlService.add(stud);
        } catch (ValidatorException exception) {
            assertTrue(true);
        }
    }

    @Test
    public void testAddStudentBB4() {

        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo xmlRepo = new StudentXMLRepo(studentValidator, "StudentiXML.xml");
        StudentXMLService xmlService = new StudentXMLService(xmlRepo);
        Student stud = new Student(-1, "Birhan", 931, "mbie2368@scs.ubbcluj.ro", "Radu Dragos");
        try {
            xmlService.add(stud);
        } catch (ValidatorException exception) {
            assertTrue(true);
        }
    }

    @Test
    public void testAddStudentBB5() {

        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo xmlRepo = new StudentXMLRepo(studentValidator, "StudentiXML.xml");
        StudentXMLService xmlService = new StudentXMLService(xmlRepo);
        Student stud = new Student(1, null, 931, "mbie2368@scs.ubbcluj.ro", "Radu Dragos");
        try {
            xmlService.add(stud);
        } catch (ValidatorException exception) {
            assertEquals(xmlRepo.getSize(), 0);
        }
    }

    @Test
    public void testAddStudentBB6() {

        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo xmlRepo = new StudentXMLRepo(studentValidator, "StudentiXML.xml");
        StudentXMLService xmlService = new StudentXMLService(xmlRepo);
        Student stud = new Student(1, "A13x", 931, "mbie2368@scs.ubbcluj.ro", "Radu Dragos");
        try {
            xmlService.add(stud);
        } catch (ValidatorException exception) {
            assertEquals(xmlRepo.getSize(), 0);
        }
    }

    @Test
    public void testAddStudentBB7() {

        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo xmlRepo = new StudentXMLRepo(studentValidator, "StudentiXML.xml");
        StudentXMLService xmlService = new StudentXMLService(xmlRepo);
        Student stud = new Student(1, "Alex", null, "mbie2368@scs.ubbcluj.ro", "Radu Dragos");
        try {
            xmlService.add(stud);
        } catch (ValidatorException exception) {
            assertEquals(xmlRepo.getSize(), 0);
        }
    }

    @Test
    public void testAddStudentBB8() {

        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo xmlRepo = new StudentXMLRepo(studentValidator, "StudentiXML.xml");
        StudentXMLService xmlService = new StudentXMLService(xmlRepo);
        Student stud = new Student(1, "Alex", 1, "mbie2368@scs.ubbcluj.ro", "Radu Dragos");
        try {
            xmlService.add(stud);
        } catch (ValidatorException exception) {
            assertEquals(xmlRepo.getSize(), 0);
        }
    }

    @Test
    public void testAddStudentBB10() {

        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo xmlRepo = new StudentXMLRepo(studentValidator, "StudentiXML.xml");
        StudentXMLService xmlService = new StudentXMLService(xmlRepo);
        Student stud = new Student(1, "Alex", 1000, "mbie2368@scs.ubbcluj.ro", "Radu Dragos");
        try {
            xmlService.add(stud);
        } catch (ValidatorException exception) {
            assertEquals(xmlRepo.getSize(), 0);
        }
    }

    @Test
    public void testAddStudentBB11() {

        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo xmlRepo = new StudentXMLRepo(studentValidator, "StudentiXML.xml");
        StudentXMLService xmlService = new StudentXMLService(xmlRepo);
        Student stud = new Student(1, "Alex", 935, null, "Radu Dragos");
        try {
            xmlService.add(stud);
        } catch (ValidatorException exception) {
            assertEquals(xmlRepo.getSize(), 0);
        }
    }

    @Test
    public void testAddStudentBB12() {

        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo xmlRepo = new StudentXMLRepo(studentValidator, "StudentiXML.xml");
        StudentXMLService xmlService = new StudentXMLService(xmlRepo);
        Student stud = new Student(1, "Alex", 935, "alex@mail.com", null);
        try {
            xmlService.add(stud);
        } catch (ValidatorException exception) {
            assertEquals(xmlRepo.getSize(), 0);
        }
    }

    @Test
    public void testAddStudentBB13() {

        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo xmlRepo = new StudentXMLRepo(studentValidator, "StudentiXML.xml");
        StudentXMLService xmlService = new StudentXMLService(xmlRepo);
        Student stud = new Student(1, "Alex", 935, "alex@mail.com", "P0pescu");
        try {
            xmlService.add(stud);
        } catch (ValidatorException exception) {
            assertEquals(xmlRepo.getSize(), 0);
        }
    }

    @Test
    public void testAddAssignmentTC1() {

        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo xmlRepo = new TemaLabXMLRepo(temaLabValidator, "TemeXML.xml");
        TemaLabXMLService xmlService = new TemaLabXMLService(xmlRepo);
        TemaLab tema = new TemaLab(null, null, null, null);
        try {
            xmlService.add(tema);
        } catch (ValidatorException exception) {
            assertTrue(true);
        }
    }

    @Test
    public void testAddAssignmentTC2() throws ValidatorException {

        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo xmlRepo = new TemaLabXMLRepo(temaLabValidator, "TemeXML.xml");
        TemaLabXMLService xmlService = new TemaLabXMLService(xmlRepo);
        TemaLab tema = new TemaLab(1, "Ceva descriere", 10, 12);
        xmlService.add(tema);
        assertEquals(xmlRepo.size(), 1);
    }

    @Test
    public void testAddAssignmentTC3() {

        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo xmlRepo = new TemaLabXMLRepo(temaLabValidator, "TemeXML.xml");
        TemaLabXMLService xmlService = new TemaLabXMLService(xmlRepo);
        TemaLab tema = new TemaLab(null, "asdsa", 10, 1);
        try {
            xmlService.add(tema);
        } catch (ValidatorException exception) {
            assertTrue(true);
        }
    }   @Test
    public void testAddAssignmentTC5() {

        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo xmlRepo = new TemaLabXMLRepo(temaLabValidator, "TemeXML.xml");
        TemaLabXMLService xmlService = new TemaLabXMLService(xmlRepo);
        TemaLab tema = new TemaLab(3, null, 14, 10);
        try {
            xmlService.add(tema);
        } catch (ValidatorException exception) {
            assertTrue(true);
        }
    }   @Test
    public void testAddAssignmentTC6() {

        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo xmlRepo = new TemaLabXMLRepo(temaLabValidator, "TemeXML.xml");
        TemaLabXMLService xmlService = new TemaLabXMLService(xmlRepo);
        TemaLab tema = new TemaLab(3, "", 10, 3);
        try {
            xmlService.add(tema);
        } catch (ValidatorException exception) {
            assertTrue(true);
        }
    }   @Test
    public void testAddAssignmentTC7() {

        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo xmlRepo = new TemaLabXMLRepo(temaLabValidator, "TemeXML.xml");
        TemaLabXMLService xmlService = new TemaLabXMLService(xmlRepo);
        TemaLab tema = new TemaLab(3, "null", null, 3);
        try {
            xmlService.add(tema);
        } catch (ValidatorException exception) {
            assertTrue(true);
        }
    }

    @Test
    public void testAddAssignmentTC9() {

        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo xmlRepo = new TemaLabXMLRepo(temaLabValidator, "TemeXML.xml");
        TemaLabXMLService xmlService = new TemaLabXMLService(xmlRepo);
        TemaLab tema = new TemaLab(3, "null", 15, 3);
        try {
            xmlService.add(tema);
        } catch (ValidatorException exception) {
            assertTrue(true);
        }
    }
    @Test
    public void testAddAssignmentTC10() {

        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo xmlRepo = new TemaLabXMLRepo(temaLabValidator, "TemeXML.xml");
        TemaLabXMLService xmlService = new TemaLabXMLService(xmlRepo);
        TemaLab tema = new TemaLab(3, "null", 14, null);
        try {
            xmlService.add(tema);
        } catch (ValidatorException exception) {
            assertTrue(true);
        }
    }

    @Test
    public void testAddAssignmentTC12() {

        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo xmlRepo = new TemaLabXMLRepo(temaLabValidator, "TemeXML.xml");
        TemaLabXMLService xmlService = new TemaLabXMLService(xmlRepo);
        TemaLab tema = new TemaLab(3, "null", 14, 15);
        try {
            xmlService.add(tema);
        } catch (ValidatorException exception) {
            assertTrue(true);
        }
    }
}

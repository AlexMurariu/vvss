package Lab3VVSS;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
        String[] params = {"0", "Birhan", "935", "mbie2368@scs.ubbcluj.ro", "Radu Dragos"};
        xmlService.add(params);
        assertEquals(xmlRepo.size(), 1);
    }

    @Test
    public void testAddStudentInvalidGroupInput() {

        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo xmlRepo = new StudentXMLRepo(studentValidator, "StudentiXML.xml");
        StudentXMLService xmlService = new StudentXMLService(xmlRepo);
        String[] params = {"0", "Birhan", "No bueno", "mbie2368@scs.ubbcluj.ro", "Radu Dragos"};
        try {
            xmlService.add(params);
            fail("Rip");
        } catch (ValidatorException exception) {

        }
    }

    @Test
    public void testAddAssignmentValidInput() throws ValidatorException {

        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo xmlRepo = new TemaLabXMLRepo(temaLabValidator, "TemeXML.xml");
        TemaLabXMLService xmlService = new TemaLabXMLService(xmlRepo);
        String[] params = {"0", "Ceva descriere", "10", "12"};
        xmlService.add(params);
        assertEquals(xmlRepo.size(), 1);
    }

    @Test
    public void testAddAssignmentInvalidGroupInput() {

        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo xmlRepo = new TemaLabXMLRepo(temaLabValidator, "TemeXML.xml");
        TemaLabXMLService xmlService = new TemaLabXMLService(xmlRepo);
        String[] params = {"0", "", "10", "12"};
        try {
            xmlService.add(params);
            fail("Rip");
        } catch (ValidatorException exception) {

        }
    }
}

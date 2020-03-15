package Lab3VVSS;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import Lab3VVSS.Exceptions.ValidatorException;
import Lab3VVSS.Repository.XMLFileRepository.StudentXMLRepo;
import Lab3VVSS.Service.XMLFileService.StudentXMLService;
import Lab3VVSS.Validator.StudentValidator;
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
}

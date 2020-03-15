package Lab3VVSS;

import Lab3VVSS.Exceptions.ValidatorException;
import Lab3VVSS.Repository.XMLFileRepository.NotaXMLRepo;
import Lab3VVSS.Repository.XMLFileRepository.StudentXMLRepo;
import Lab3VVSS.Repository.XMLFileRepository.TemaLabXMLRepo;
import Lab3VVSS.Service.XMLFileService.NotaXMLService;
import Lab3VVSS.Service.XMLFileService.StudentXMLService;
import Lab3VVSS.Service.XMLFileService.TemaLabXMLService;
import Lab3VVSS.UI.ui;
import Lab3VVSS.Validator.NotaValidator;
import Lab3VVSS.Validator.StudentValidator;
import Lab3VVSS.Validator.TemaLabValidator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ValidatorException {
        //System.out.println("Hello World!");
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);
        ui ui=new ui(stsrv,tmsrv,ntsrv);
        ui.run();
    }
}
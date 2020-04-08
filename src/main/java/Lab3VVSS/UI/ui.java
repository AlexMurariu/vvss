package Lab3VVSS.UI;

import Lab3VVSS.Domain.Nota;
import Lab3VVSS.Domain.Student;
import Lab3VVSS.Domain.TemaLab;
import Lab3VVSS.Exceptions.ServiceException;
import Lab3VVSS.Exceptions.ValidatorException;
import Lab3VVSS.Service.XMLFileService.AbstractXMLService;
import Lab3VVSS.Service.XMLFileService.NotaXMLService;
import Lab3VVSS.Service.XMLFileService.StudentXMLService;
import Lab3VVSS.Service.XMLFileService.TemaLabXMLService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;


public class ui {
    StudentXMLService stdSrv;
    TemaLabXMLService tmLbSrv;
    NotaXMLService notaSrv;
    public ui(StudentXMLService srv1,TemaLabXMLService srv2,NotaXMLService srv3){
        this.stdSrv=srv1;
        this.tmLbSrv=srv2;
        this.notaSrv=srv3;

    }

    /*
    public void printAllEntities(AbstractService srv){
        srv.getAll().forEach(x-> System.out.println(x));
    }
    */

//    public void printAllEntities(AbstractXMLService srv){
//        srv.findAll().forEach(x-> System.out.println(x));
//    }


    public void addStudent() throws ValidatorException {
        try{
            Scanner scanner = new Scanner(System.in);
            String id,nume,grupa,email,prof;
            System.out.println("Id student:");
            id=scanner.nextLine();
            int student = Integer.parseInt(id);
            System.out.println("Nume student:");
            nume=scanner.nextLine();
            System.out.println("Grupa:");
            grupa=scanner.nextLine();
            int _grupa = Integer.parseInt(grupa);
//            int _grupa = Integer.parseInt(grupa);
            System.out.println("Email:");
            email=scanner.nextLine();
            System.out.println("Profesor indrumator:");
            prof=scanner.nextLine();
            stdSrv.add(new Student(student, nume, _grupa, email, prof));
        }catch (ValidatorException ex){
            System.out.println(ex.getMessage());
        } catch (NumberFormatException exception){
            System.out.println(exception.getMessage());
        }
    }


    public void addHomework() throws ValidatorException {
        try{
            Scanner scanner = new Scanner(System.in);
            String id,descr,saptLim,saptPred;
            System.out.println("Nr tema:");
            id=scanner.nextLine();
            int temaId = Integer.parseInt(id);
            //scanner.nextLine();
            System.out.println("Descriere tema:");
            descr=scanner.nextLine();
            //scanner.nextLine();
            System.out.println("Saptamana limita:");
            saptLim=scanner.nextLine();
            int saptL = Integer.parseInt(saptLim);
            //scanner.nextLine();
            System.out.println("Saptamana predarii:");
            saptPred=scanner.nextLine();
            int saptP = Integer.parseInt(saptPred);
            //scanner.nextLine();
            tmLbSrv.add(new TemaLab(temaId, descr, saptL, saptP));
        }catch (ValidatorException ex){
            System.out.println(ex.getMessage());
        } catch (RuntimeException exception){
            System.out.println("Please enter a number");
        }
    }

    public void addNota() throws ValidatorException {
        try{
            Scanner scanner = new Scanner(System.in);
            String id,ids,idt,val,data;
            System.out.println("Id nota:");
            id=scanner.nextLine();
            int _id = Integer.parseInt(id);
            System.out.println("Id student:");
            ids=scanner.nextLine();
            int _ids = Integer.parseInt(ids);
            System.out.println("Id tema:");
            idt=scanner.nextLine();
            int _idt = Integer.parseInt(idt);
            System.out.println("Valoare:");
            val=scanner.nextLine();
            double _val = Double.parseDouble(val);
            System.out.println("Data:");
            data=scanner.nextLine();
            LocalDateTime _data = LocalDateTime.parse(data);
            String val1=notaSrv.depunctare(tmLbSrv,idt,val);
            notaSrv.add(new Nota(_id, ids, _idt, _val, _data));
//            notaSrv.printAllNotes(tmLbSrv);
        }catch (ValidatorException ex){
            System.out.println(ex.getMessage());
        } catch (NumberFormatException exception){
            System.out.println(exception.getMessage());
        }

    }

    public void delStudent() throws ValidatorException {
        Scanner scanner = new Scanner(System.in);
        String id;
        System.out.println("Id student:");
        id=scanner.nextLine();
        try{
            stdSrv.remove(Integer.parseInt(id));
        }catch(ServiceException ex){
            System.out.println(ex.getMessage());
        }
    }


    public void delHomework() throws ValidatorException {
        Scanner scanner = new Scanner(System.in);
        int id;
        System.out.println("Id student:");
        id=scanner.nextInt();
        try{
            tmLbSrv.remove(id);
        }catch(ServiceException ex){
            System.out.println(ex.getMessage());
        }
    }


    public void updStudent() throws ValidatorException {
        Scanner scanner = new Scanner(System.in);
        String nume,grupa,email,prof;
        int id;
        System.out.println("Id student:");
        id=scanner.nextInt();
        System.out.println("Nume student:");
        nume=scanner.nextLine();
        System.out.println("Grupa:");
        grupa=scanner.nextLine();
        int _grupa = Integer.parseInt(grupa);
        System.out.println("Email:");
        email=scanner.nextLine();
        System.out.println("Profesor indrumator:");
        prof=scanner.nextLine();
        stdSrv.update(new Student(id, nume, _grupa, email, prof));
    }

    public void prelungireDeadLine() throws ValidatorException {
        Scanner scanner = new Scanner(System.in);
        String id,descr,saptLim,saptPred,saptCurenta;
        System.out.println("Nr tema:");
        id=scanner.nextLine();
        int _id = Integer.parseInt(id);
        scanner.nextLine();
        System.out.println("Descriere tema:");
        descr=scanner.nextLine();
        scanner.nextLine();
        System.out.println("Saptamana limita:");
        saptLim=scanner.nextLine();
        scanner.nextLine();
        int _saptLim = Integer.parseInt(saptLim);
        System.out.println("Saptamana predarii:");
        saptPred=scanner.nextLine();
        scanner.nextLine();
        int _saptPred = Integer.parseInt(saptPred);
        System.out.println("Saptamana curenta:");
        saptCurenta=scanner.nextLine();
        scanner.nextLine();
        int _saptCurenta = Integer.parseInt(saptCurenta);
        try{
            tmLbSrv.prelungireTemaLab(_id,descr,_saptLim,_saptPred,_saptCurenta);
        }catch (ValidatorException ex){
            System.out.println(ex.getMessage());
        } catch (NumberFormatException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void run() throws ValidatorException, IOException {
        Scanner scanner = new Scanner(System.in);

       // try {
            while (true) {
                System.out.println("=======================================================");
                System.out.println("1a--Adaugare student         1b--Adaugare tema");
                System.out.println("2a--Stergere student         2b--Stergere tema");
                System.out.println("3a--Actualizare student      3b--Prelungire termen tema");
                System.out.println("4a--Afisare studenti         4b--Afisare studenti");
                System.out.println("5--Adaugare nota");
                System.out.println("6--Afisare note");
                System.out.println("7--Stop");
                System.out.println("=======================================================");
                System.out.println("Alegeti optiunea:");
                String opt = scanner.nextLine();
                if (opt.equals("1a")) {
                    this.addStudent();
                }else if (opt.equals("2a")) {
                    this.delStudent();
                }else if(opt.equals("3a")){
                    this.updStudent();
                }else if(opt.equals("4a")) {
//                    this.printAllEntities(stdSrv);
                }else if (opt.equals("1b")) {
                    this.addHomework();
                }else if (opt.equals("2b")) {
                    this.delHomework();
                }else if(opt.equals("3b")){
                    this.prelungireDeadLine();
                }else if(opt.equals("4b")){
//                    this.printAllEntities(tmLbSrv);
                }else if(opt.equals("5")){
                    this.addNota();
                }else if(opt.equals("6")){
                    //this.printAllNotes();
                }else if(opt.equals("7")){
                    break;
                }else{
                    System.out.println("Optiune invalida!");
                }
            }
    }
}

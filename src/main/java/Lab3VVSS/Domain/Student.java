package Lab3VVSS.Domain;

public class Student implements HasId<Integer> {
    private  Integer id;
    private  String nume;
    private Integer grupa;
    private String email;
    private String indrumator;
    public Student(Integer id,String nume,Integer grupa, String email, String indrumator){
        this.setId(id);
        this.setNume(nume);
        this.setGrupa(grupa);
        this.setEmail(email);
        this.setIndrumator(indrumator);
    }
    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public Integer getGrupa() {
        return grupa;
    }
    public void setGrupa(Integer grupa) {
        this.grupa = grupa;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getIndrumator() {
        return indrumator;
    }
    public void setIndrumator(String indrumator) {
        this.indrumator = indrumator;
    }
    @Override
    public String toString(){
        return this.id+"#"+this.nume+"#"+this.grupa+"#"+this.email+"#"+this.indrumator;
    }
}

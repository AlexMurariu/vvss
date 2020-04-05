package Lab3VVSS.Domain;

public class TemaLab implements HasId<Integer> {
    private Integer nr;
    private String descriere;
    private Integer termenLimita;
    private Integer saptammanaPredarii;
    public TemaLab(Integer nr, String descriere, Integer termenLimita, Integer saptammanaPredarii){
        this.setId(nr);
        this.setDescriere(descriere);
        this.setTermenLimita(termenLimita);
        this.setSaptammanaPredarii(saptammanaPredarii);
    }
    @Override
    public Integer getId() {
        return nr;
    }
    @Override
    public void setId(Integer nr) {
        this.nr = nr;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Integer getTermenLimita() {
        return termenLimita;
    }

    public void setTermenLimita(Integer termenLimita) {
        this.termenLimita = termenLimita;
    }

    public Integer getSaptammanaPredarii() {
        return saptammanaPredarii;
    }

    public void setSaptammanaPredarii(Integer saptammanaPredarii) {
        this.saptammanaPredarii = saptammanaPredarii;
    }
    @Override
    public String toString(){
        return this.nr+"#"+this.descriere+"#"+this.termenLimita+"#"+this.saptammanaPredarii;
    }
}

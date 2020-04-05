package Lab3VVSS.Validator;

import Lab3VVSS.Domain.TemaLab;
import Lab3VVSS.Exceptions.ValidatorException;

public class TemaLabValidator implements IValidator<TemaLab> {

    public void validate(TemaLab t) throws ValidatorException {
        if(t.getId()== null || t.getId().equals("")){
            throw new ValidatorException("Nr tema invalid\n");
        }else if(t.getDescriere()== null || t.getDescriere().equals("")) {
            throw new ValidatorException("Descriere tema invalida\n");
        }else if(t.getSaptammanaPredarii() == null || t.getSaptammanaPredarii()<=0 || t.getSaptammanaPredarii()>14) {
            throw new ValidatorException("Sapatamana predarii invalida\n");
        }else if(t.getTermenLimita() == null || t.getTermenLimita()<=0 || t.getTermenLimita()>14) {
            throw new ValidatorException("Termen limita invalid\n");
        }
    }
}

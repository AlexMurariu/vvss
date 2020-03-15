package Lab3VVSS.Service.TxtFileService;

import Lab3VVSS.Domain.Nota;
import Lab3VVSS.Repository.TxtFileRepository.NotaFileRepo;

public class NotaService extends AbstractService<Integer, Nota> {
    public NotaService(NotaFileRepo notaRepo){
        super(notaRepo);
    }
}

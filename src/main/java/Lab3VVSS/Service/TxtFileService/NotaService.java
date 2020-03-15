package Lab3VVSS.Service.TxtFileService;

import Lab3VVSS.Domain.Nota;
import Lab3VVSS.Repository.TxtFileRepository.NotaFileRepo;
import Lab3VVSS.Service.TxtFileService.AbstractService;

public class NotaService extends AbstractService<Integer, Nota> {
    public NotaService(NotaFileRepo notaRepo){
        super(notaRepo);
    }
}

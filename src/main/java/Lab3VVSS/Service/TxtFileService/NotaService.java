package Lab3VVSS.Service.TxtFileService;

import Lab3VVSS.Domain.Nota;
import Lab3VVSS.Repository.MemoryRepository.NotaRepo;

public class NotaService {
    private NotaRepo notaRepo;

    public NotaService(NotaRepo _notaRepo) {
        this.notaRepo = _notaRepo;
    }

    public Iterable<Nota> all(){
        return notaRepo.findAll();
    }
}

package cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n01.service;


import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n01.models.FrutaModel;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n01.repository.IFrutaRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FrutaService {
    @Autowired
    IFrutaRepository frutaRepository;


    public FrutaModel addFruta(FrutaModel fruta) {
        return frutaRepository.save(fruta);
    }

    public FrutaModel getFrutaByID(Long id) {
        Optional<FrutaModel> maybeFruta = frutaRepository.findById(id);

        if (maybeFruta.isPresent()) {
            return maybeFruta.get();
        } else {
            throw new ResourceNotFoundException("Fruta with ID " + id + " not found"); // ResourceNotFoundException - это пользовательское исключение, которое вы должны создать
        }
    }


    public FrutaModel updateById(FrutaModel request, Long id) {
        FrutaModel maybeFruta = frutaRepository.findById(id).orElse(null);
        if (maybeFruta != null) {
            maybeFruta.setNombre(request.getNombre());
            maybeFruta.setPesoKilos(request.getPesoKilos());
            frutaRepository.save(maybeFruta);

        }
        return maybeFruta;
    }


    public boolean deleteFruta(Long id) {
        try {
            frutaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<FrutaModel> getAllFrutas() {
        return frutaRepository.findAll();
    }


}

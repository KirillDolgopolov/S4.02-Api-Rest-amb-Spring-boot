package cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n02.services;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n02.models.FrutaModel;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n02.repositories.IFrutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FrutaService {
    @Autowired
    IFrutaRepository frutaRepository;

    public ArrayList<FrutaModel> getFrutas() {
        return (ArrayList<FrutaModel>) frutaRepository.findAll();
    }

    public FrutaModel saveFruta(FrutaModel fruta) {
        return frutaRepository.save(fruta);
    }

    public Optional<FrutaModel> getById(Long id) {
        return frutaRepository.findById(id);
    }

    public FrutaModel updateById(FrutaModel request, Long id) {
        FrutaModel fruta = frutaRepository.findById(id).get();
        fruta.setNombre(request.getNombre());
        fruta.setPesoKilos(request.getPesoKilos());

        return fruta;

    }

    public Boolean deleteFruta(long id) {
        try {
            frutaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

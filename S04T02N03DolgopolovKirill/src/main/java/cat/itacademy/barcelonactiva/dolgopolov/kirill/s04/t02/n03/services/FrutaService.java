package cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n03.services;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n03.models.FrutaModel;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n03.repositories.IFrutaRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Optional<FrutaModel> getById(ObjectId id) {
        return frutaRepository.findById(id);
    }

    public FrutaModel updateById(FrutaModel request, ObjectId id) {
        FrutaModel fruta = frutaRepository.findById(id).orElse(null);
        if (fruta != null) {
            fruta.setNombre(request.getNombre());
            fruta.setPesoKilos(request.getPesoKilos());
            frutaRepository.save(fruta);
        }
        return fruta;
    }


    public boolean deleteFruta(ObjectId id) {
        try {
            frutaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}



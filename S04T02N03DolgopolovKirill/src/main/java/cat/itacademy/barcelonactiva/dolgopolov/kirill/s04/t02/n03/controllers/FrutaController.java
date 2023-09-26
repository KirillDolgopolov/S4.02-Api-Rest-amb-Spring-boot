package cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n03.controllers;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n03.models.FrutaModel;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n03.services.FrutaService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class FrutaController {

    @Autowired
    FrutaService frutaService;

    @GetMapping(value = "/frutas", produces = "application/json")
    public ArrayList<FrutaModel> getFrutas() {
        return this.frutaService.getFrutas();
    }

    @PostMapping(value = "/fruta")
    public FrutaModel saveFruta(@RequestBody FrutaModel fruta) {
        return this.frutaService.saveFruta(fruta);
    }

    @GetMapping(value = "/{id}")
    public Optional<FrutaModel> getFrutaById(@PathVariable("id") String idString) {
        ObjectId id = new ObjectId(idString);
        return this.frutaService.getById(id);
    }

    @PutMapping(value = "/{id}")
    public FrutaModel updateFrutaById(@RequestBody FrutaModel request, @PathVariable("id") String idString) {
        ObjectId id = new ObjectId(idString);
        return this.frutaService.updateById(request, id);
    }


    @DeleteMapping(value = "/{id}")
    public String deliteFrutaById(@PathVariable("id") String idString) {
        ObjectId id = new ObjectId(idString);
        boolean ok = this.frutaService.deleteFruta(id);
        if (ok) {
            return "La fruta con ID " + idString + " se ha eliminado";
        } else return "Error";

    }


}

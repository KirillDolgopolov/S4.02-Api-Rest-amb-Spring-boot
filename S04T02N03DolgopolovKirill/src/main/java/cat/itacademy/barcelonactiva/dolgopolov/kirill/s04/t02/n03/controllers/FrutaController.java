package cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n03.controllers;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n03.models.FrutaModel;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n03.services.FrutaService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class FrutaController {

    @Autowired
    FrutaService frutaService;

    @GetMapping(value = "/frutas", produces = "application/json")
    public ResponseEntity<ArrayList<FrutaModel>> getFrutas() {
        ArrayList<FrutaModel> frutaList = new ArrayList<>(frutaService.getFrutas());
        return new ResponseEntity<>(frutaList, HttpStatus.OK);
    }

    @PostMapping(value = "/fruta")
    public ResponseEntity<FrutaModel> saveFruta(@RequestBody FrutaModel fruta) {
        frutaService.saveFruta(fruta);
        return new ResponseEntity<>(fruta, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<FrutaModel>> getFrutaById(@PathVariable("id") String idString) {
        ObjectId id = new ObjectId(idString);
        Optional<FrutaModel> mayBeFruta = frutaService.getById(id);
        return new ResponseEntity<>(mayBeFruta, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FrutaModel> updateFrutaById(@RequestBody FrutaModel request, @PathVariable("id") String idString) {
        ObjectId id = new ObjectId(idString);
        frutaService.updateById(request, id);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deliteFrutaById(@PathVariable("id") String idString) {
        ObjectId id = new ObjectId(idString);
        boolean ok = this.frutaService.deleteFruta(id);
        if (ok) {
            return new ResponseEntity<>("La fruta con ID " + idString + " se ha eliminado", HttpStatus.OK);
        } else return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);

    }


}

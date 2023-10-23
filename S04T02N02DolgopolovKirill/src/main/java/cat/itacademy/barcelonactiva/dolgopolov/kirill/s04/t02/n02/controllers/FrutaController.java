package cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n02.controllers;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n02.models.FrutaModel;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n02.services.FrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/fruta")

public class FrutaController {


    @Autowired
    private FrutaService frutaService;


    @GetMapping
    public ResponseEntity<ArrayList<FrutaModel>> getFrutas() {
        ArrayList<FrutaModel> listaDeFrutas = new ArrayList<>();
        listaDeFrutas.addAll(frutaService.getFrutas());
        return new ResponseEntity<>(listaDeFrutas, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<FrutaModel> saveFruta(@RequestBody FrutaModel fruta) {
        frutaService.saveFruta(fruta);
        return new ResponseEntity<>(fruta, HttpStatus.CREATED);

    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<FrutaModel>> getByID(@PathVariable("id") Long id) {
        Optional<FrutaModel> fruta = frutaService.getById(id);
        return new ResponseEntity<>(fruta, HttpStatus.OK);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<FrutaModel> updateFrutaById(@RequestBody FrutaModel request, @PathVariable("id") long id) {
        FrutaModel updatedFruta = frutaService.updateById(request, id);
        if (updatedFruta == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedFruta, HttpStatus.OK);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        boolean ok = this.frutaService.deleteFruta(id);

        if (ok) {
            return new ResponseEntity<>("La Fruta con id" + id + "se ha borrado", HttpStatus.OK);
        } else return new ResponseEntity<>("Error en la operación", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}



package cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n01.models.FrutaModel;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n01.service.FrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@Controller
@RequestMapping("/fruta")
public class FrutaController {
    @Autowired
    FrutaService frutaService;


    @PostMapping
    ResponseEntity<FrutaModel> addFruta(@RequestBody FrutaModel fruta) {
        frutaService.addFruta(fruta);
        return new ResponseEntity<>(fruta, HttpStatus.CREATED);
    }


    @GetMapping
    ResponseEntity<List<FrutaModel>> getAllFrutas() {
        List<FrutaModel> list = new ArrayList<>();
        list.addAll(frutaService.getAllFrutas());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<FrutaModel>> getByID(@PathVariable("id") Long id) {
        Optional<FrutaModel> fruta = Optional.ofNullable(frutaService.getFrutaByID(id));
        return new ResponseEntity<>(fruta, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<FrutaModel> updateByID(@RequestBody FrutaModel fruta, @PathVariable("id") Long id) {
        FrutaModel updatedFruta = frutaService.updateById(fruta, id);

        if (updatedFruta == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedFruta, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFruta(@PathVariable("id") Long id) {
        boolean deleted = this.frutaService.deleteFruta(id);
        if (deleted) {
            return new ResponseEntity<>("La fruta ha sido eliminado: " + id, HttpStatus.OK);
        } else return new ResponseEntity<>("Error en la operación", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

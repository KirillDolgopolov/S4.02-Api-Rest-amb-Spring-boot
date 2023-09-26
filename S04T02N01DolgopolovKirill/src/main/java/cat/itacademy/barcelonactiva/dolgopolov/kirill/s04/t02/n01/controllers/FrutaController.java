package cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n01.controllers;


import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n01.models.FrutaModel;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n01.service.FrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
@RequestMapping("/fruta")
public class FrutaController {
    @Autowired
    FrutaService frutaService;


    @PostMapping
    public FrutaModel addFruta(@RequestBody FrutaModel fruta) {
        return this.frutaService.addFruta(fruta);
    }

    @GetMapping
    public List<FrutaModel> getAllFrutas() {
        return this.frutaService.getAllFrutas();
    }

    @GetMapping(path = "/{id}")
    public FrutaModel getByID(@PathVariable("id") Long id) {
        return this.frutaService.getFrutaByID(id);
    }

    @PutMapping(path = "/{id}")
    public FrutaModel updateByID(@RequestBody FrutaModel fruta, @PathVariable("id") Long id) {
        return this.frutaService.updateById(fruta, id);
    }

    @DeleteMapping("/{id}")
    public String deleteFruta(@PathVariable("id") Long id) {
        boolean deleted = this.frutaService.deleteFruta(id);
        if (deleted) {
            return "La fruta ha sido eliminado: " + id;
        } else return "Error de la operacion";
    }

}

package br.com.wa.waproject.controllers;

import br.com.wa.waproject.models.entities.Exame;
import br.com.wa.waproject.models.entities.Laboratorio;
import br.com.wa.waproject.models.repositories.ExameRepository;
import br.com.wa.waproject.models.repositories.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/exames")
public class ExameController {

    @Autowired
    private ExameRepository exameRepository;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    Exame saveExame(Exame exame){
        exameRepository.save(exame);
        return exame;
    }

    @GetMapping
    public Iterable<Exame> getAllExames(){
        return exameRepository.findAll();
    }

    @GetMapping(path = "/name/{partName}")
    public Iterable<Exame> getExameByName(@PathVariable String partName){
        return exameRepository.searchByNameLike(partName);
    }

    @GetMapping("/page/{numberPage}/{qtdePage}")
    public Iterable<Exame> getExamePerPage(@PathVariable int numberPage,@PathVariable int qtdePage){
        if(qtdePage >= 5){
            qtdePage = 5;
        }

        Pageable page = PageRequest.of(numberPage, 2);
        return exameRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public Optional<Exame> findById(@PathVariable int id){
        return exameRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        exameRepository.deleteById(id);
    }
}

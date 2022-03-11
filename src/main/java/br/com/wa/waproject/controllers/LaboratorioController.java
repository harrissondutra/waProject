package br.com.wa.waproject.controllers;

import br.com.wa.waproject.models.entities.Laboratorio;
import br.com.wa.waproject.models.repositories.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/laboratorios")
public class LaboratorioController {

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    Laboratorio saveLaboratorio(Laboratorio laboratorio){
        laboratorioRepository.save(laboratorio);
        return laboratorio;
    }

    @GetMapping
    public Iterable<Laboratorio> getAllLaboratorios(){
        return laboratorioRepository.findAll();
    }

    @GetMapping(path = "/name/{partName}")
    public Iterable<Laboratorio> getLaboratorioByName(@PathVariable String partName){
        return laboratorioRepository.searchByNameLike(partName);
    }

    @GetMapping("/page/{numberPage}/{qtdePage}")
    public Iterable<Laboratorio> getLaboratorioPerPage(@PathVariable int numberPage,@PathVariable int qtdePage){
        if(qtdePage >= 5){
            qtdePage = 5;
        }

        Pageable page = PageRequest.of(numberPage, 2);
        return laboratorioRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public Optional<Laboratorio> findById(@PathVariable int id){
        return laboratorioRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        laboratorioRepository.deleteById(id);
    }
}

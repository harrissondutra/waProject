package br.com.wa.waproject.controllers;

import br.com.wa.waproject.models.entities.Laboratorio;
import br.com.wa.waproject.models.repositories.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/labs")
public class LaboratorioController {

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @GetMapping
    public Iterable<Laboratorio> getAllLabs() {
        return laboratorioRepository.findAll();
    }

    @GetMapping(path = "/name/{partName}")
    public Iterable<Laboratorio> getLabsName(@PathVariable String partName) {
        return laboratorioRepository.searchByNameLike(partName);
    }

    @GetMapping("/page/{numberPage}/{qtdPage}")
    public Iterable<Laboratorio> getLabsPerPage(@PathVariable int numberPage, @PathVariable int qtdPage) {
        if (qtdPage >= 5) {
            qtdPage = 5;
        }
        Pageable page = PageRequest.of(numberPage, 2);
        return laboratorioRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public Optional<Laboratorio> getLabsById(@PathVariable int id) {
        return laboratorioRepository.findById(id);
    }

    @PostMapping
    public @ResponseBody
    Laboratorio insertLabs(@Valid Laboratorio lab) {
        laboratorioRepository.save(lab);
        return lab;
    }

    @PutMapping
    public Laboratorio setLabs(@Valid Laboratorio lab){
        laboratorioRepository.save(lab);
        return lab;
    }

    @DeleteMapping("/{id}")
    public void deleteLabsById(@PathVariable int id) {
        laboratorioRepository.deleteById(id);
    }
}

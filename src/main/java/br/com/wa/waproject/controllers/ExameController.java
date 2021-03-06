package br.com.wa.waproject.controllers;

import br.com.wa.waproject.models.entities.Exame;
import br.com.wa.waproject.models.entities.Laboratorio;
import br.com.wa.waproject.models.repositories.ExameRepository;
import br.com.wa.waproject.models.repositories.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/exames")
public class ExameController {

    @Autowired
    private ExameRepository exameRepository;


    @GetMapping
    public Iterable<Exame> getAllExame() {
        return exameRepository.findAll();
    }

    @GetMapping(path = "/name/{partName}")
    public Iterable<Exame> getExameName(@PathVariable String partName) {
        return exameRepository.searchByNameLike(partName);
    }

    @GetMapping("/page/{numberPage}/{qtdPage}")
    public Iterable<Exame> getExamePerPage(@PathVariable int numberPage, @PathVariable int qtdPage) {
        if (qtdPage >= 5) {
            qtdPage = 5;
        }
        Pageable page = PageRequest.of(numberPage, 2);
        return exameRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public Optional<Exame> getExameById(@PathVariable int id) {
        return exameRepository.findById(id);
    }

    @PostMapping
    public @ResponseBody
    Exame insertExam(@Valid Exame exame) {
        exameRepository.save(exame);
        return exame;
    }

    @PutMapping()
    public Exame setExame(@Valid Exame exame){
       exameRepository.save(exame);
       return exame;
    }

    @DeleteMapping("/{id}")
    public void deleteExameById(@PathVariable int id) {
        exameRepository.deleteById(id);
    }
}

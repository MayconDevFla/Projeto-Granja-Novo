package com.granjacontrol.granjacontrol.rest;

import com.granjacontrol.granjacontrol.model.entity.Ciclo;
import com.granjacontrol.granjacontrol.model.repository.CicloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ciclos")
public class CicloController {

    private final CicloRepository repository;

    @Autowired
    public CicloController(CicloRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Ciclo> consultar(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ciclo salvar( @RequestBody @Valid Ciclo ciclo){
        return repository.save(ciclo);
    }

    @GetMapping("{id}")
    public Ciclo consultarPorId( @PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository
                .findById(id)
                .map( ciclo -> {
                    repository.delete(ciclo);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterar( @PathVariable Integer id, @RequestBody Ciclo cicloAtualizado ){
        repository
                .findById(id)
                .map(ciclo -> {
                    ciclo.setPeso(cicloAtualizado.getPeso());
                    ciclo.setQuantidade(cicloAtualizado.getQuantidade());
                    ciclo.setRaca(cicloAtualizado.getRaca());
                    return repository.save(cicloAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
    }

}

package com.granjacontrol.granjacontrol.rest;

import com.granjacontrol.granjacontrol.exception.UsuarioCadastradoException;
import com.granjacontrol.granjacontrol.model.entity.Usuario;
import javax.validation.Valid;

import com.granjacontrol.granjacontrol.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {


    private final UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){
        try {
            service.salvar(usuario);
        }catch (UsuarioCadastradoException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}

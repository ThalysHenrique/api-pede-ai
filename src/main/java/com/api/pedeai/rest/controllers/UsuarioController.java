package com.api.pedeai.rest.controllers;

import com.api.pedeai.models.Usuario;
import com.api.pedeai.services.impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    @ResponseStatus(CREATED)
    public Usuario salvar(@RequestBody @Valid Usuario usuario){
        String senhaCripto = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCripto);
        return usuarioService.salvar(usuario);
    }
}

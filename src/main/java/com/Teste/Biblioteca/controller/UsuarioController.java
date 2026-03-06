package com.Teste.Biblioteca.controller;

import com.Teste.Biblioteca.dto.UsuarioDTO;
import com.Teste.Biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    public UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public UsuarioDTO criar(@RequestBody UsuarioDTO dto) {
        return service.criarUsuario(dto);
    }

    @GetMapping
    public List<UsuarioDTO> listar() {
        return service.listarUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscar(@PathVariable Long id) {
        return service.BuscaId(id);
    }
}

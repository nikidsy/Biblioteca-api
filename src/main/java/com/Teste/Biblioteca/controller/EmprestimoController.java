package com.Teste.Biblioteca.controller;

import com.Teste.Biblioteca.dto.EmprestimoDTO;
import com.Teste.Biblioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    @PostMapping
    public EmprestimoDTO criar(@RequestBody EmprestimoDTO dto) {
        return service.criarEmprestimo(dto);
    }

    @GetMapping
    public List<EmprestimoDTO> listar() {
        return service.listarEmprestimos();
    }
}

package com.Teste.Biblioteca.controller;

import com.Teste.Biblioteca.dto.CarteiraBibliotecaDTO;
import com.Teste.Biblioteca.dto.UsuarioDTO;
import com.Teste.Biblioteca.service.CarteiraBibliotecaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carteiras")
public class CarteiraBibliotecaController {

    private final CarteiraBibliotecaService service;

    public CarteiraBibliotecaController(CarteiraBibliotecaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CarteiraBibliotecaDTO> criarCarteira (@RequestBody CarteiraBibliotecaDTO dto) {
        CarteiraBibliotecaDTO carteira = service.criarCarteira(dto);

        return ResponseEntity.ok(carteira);
    }
}

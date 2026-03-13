package com.Teste.Biblioteca.controller;

import com.Teste.Biblioteca.dto.CarteiraBibliotecaDTO;
import com.Teste.Biblioteca.service.CarteiraBibliotecaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
        public ResponseEntity<?> criarCarteira(@Valid @RequestBody CarteiraBibliotecaDTO dto) {
            CarteiraBibliotecaDTO carteira = service.criarCarteira(dto);

            if(carteira == null){
                return ResponseEntity.badRequest().body("Usuário não encontrado para gerar carteira");
            }

            return ResponseEntity.status(201).body(carteira);
        }
    }
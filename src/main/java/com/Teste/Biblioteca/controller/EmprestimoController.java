package com.Teste.Biblioteca.controller;

import com.Teste.Biblioteca.dto.EmprestimoDTO;
import com.Teste.Biblioteca.service.EmprestimoService;
import org.springframework.http.ResponseEntity;
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
        public ResponseEntity<?> criar(@RequestBody EmprestimoDTO dto) {
            EmprestimoDTO emprestimo = service.criarEmprestimo(dto);

            if(emprestimo == null){
                return ResponseEntity.badRequest().body("Usuário não encontrado para registrar empréstimo");
            }

            return ResponseEntity.status(201).body(emprestimo);
        }

        @GetMapping
        public ResponseEntity<List<EmprestimoDTO>> listar() {
            return ResponseEntity.ok(service.listarEmprestimos());
        }

        @GetMapping("/usuario/{id}")
        public ResponseEntity<List<EmprestimoDTO>> listarPorUsuario(@PathVariable Long id){
            List<EmprestimoDTO> lista = service.lisarPorUsuario(id);

            return ResponseEntity.ok(lista);
        }
    }
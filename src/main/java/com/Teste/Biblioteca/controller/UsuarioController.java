package com.Teste.Biblioteca.controller;

import com.Teste.Biblioteca.dto.UsuarioDTO;
import com.Teste.Biblioteca.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

        private final UsuarioService service;

        public UsuarioController(UsuarioService service) {
            this.service = service;
        }

        @PostMapping
        public ResponseEntity<?> criarUsuario(@RequestBody UsuarioDTO dto) {
            UsuarioDTO usuario = service.criarUsuario(dto);
            return ResponseEntity.status(201).body(usuario);
        }

        @GetMapping
        public ResponseEntity<List<UsuarioDTO>> listar() {
            return ResponseEntity.ok(service.listarUsuarios());
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> buscar(@PathVariable Long id) {
            UsuarioDTO usuario = service.BuscaId(id);

            if(usuario == null){
                return ResponseEntity.status(404).body("Usuário não encontrado");
            }

            return ResponseEntity.ok(usuario);
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody UsuarioDTO dto){
            UsuarioDTO usuario = service.atualizarUsuario(id, dto);

            if(usuario == null){
                return ResponseEntity.status(404).body("Usuário não encontrado para atualização");
            }

            return ResponseEntity.ok(usuario);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deletar(@PathVariable Long id){

            UsuarioDTO usuario = service.BuscaId(id);

            if(usuario == null){
                return ResponseEntity.status(404).body("Usuário não encontrado para exclusão");
            }

            service.deletarUsuario(id);
            return ResponseEntity.status(204).body("Usuário deletado com sucesso");
        }
    }

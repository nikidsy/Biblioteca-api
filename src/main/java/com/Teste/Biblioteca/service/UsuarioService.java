package com.Teste.Biblioteca.service;

import com.Teste.Biblioteca.dto.UsuarioDTO;
import com.Teste.Biblioteca.entities.Usuario;
import com.Teste.Biblioteca.repositories.UsuarioRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO criarUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        usuario = usuarioRepository.save(usuario);

        dto.setId(usuario.getId());
        return dto;
    }

    public List<UsuarioDTO> listarUsuarios(){

        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> lista = new ArrayList<>();

        for (Usuario u : usuarios){
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(u.getId());
            dto.setNome(u.getNome());
            dto.setEmail(u.getEmail());
            lista.add(dto);
        }

        return lista;
    }

    public UsuarioDTO BuscaIdUsuario(Long id) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isEmpty()) {
            return null;
        }

        Usuario u = usuarioOptional.get();

        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(u.getId());
        dto.setNome(u.getNome());
        dto.setEmail(u.getEmail());

        return dto;
    }

    public UsuarioDTO atualizarUsuario(Long id, UsuarioDTO dto) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isEmpty()){
            return null;
        }

        Usuario usuario = usuarioOptional.get();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario = usuarioRepository.save(usuario);

        return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }

    public  void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}

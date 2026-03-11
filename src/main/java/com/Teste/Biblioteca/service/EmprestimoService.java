package com.Teste.Biblioteca.service;

import com.Teste.Biblioteca.dto.EmprestimoDTO;
import com.Teste.Biblioteca.entities.Emprestimo;
import com.Teste.Biblioteca.entities.Usuario;
import com.Teste.Biblioteca.repositories.EmprestimoRepository;
import com.Teste.Biblioteca.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    private EmprestimoRepository emprestimoRepository;
    private UsuarioRepository usuarioRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, UsuarioRepository usuarioRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public EmprestimoDTO criarEmprestimo(EmprestimoDTO dto) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(dto.getUsuarioId());

        if (usuarioOptional.isEmpty()) {
            return null;
        }

        Usuario usuario = usuarioOptional.get();
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucao(LocalDate.now().plusDays(7));

        emprestimo = emprestimoRepository.save(emprestimo);
        dto.setId(emprestimo.getId());
        dto.setDataEmprestimo(emprestimo.getDataEmprestimo());
        dto.setDataDevolucao(emprestimo.getDataDevolucao());

        return dto;
    }

    public List<EmprestimoDTO> listarEmprestimos() {
        List<Emprestimo> emprestimos = emprestimoRepository.findAll();
        List<EmprestimoDTO> lista = new ArrayList<>();

        for (Emprestimo e : emprestimos) {
            EmprestimoDTO dto = new EmprestimoDTO();
            dto.setId(e.getId());
            dto.setDataEmprestimo(e.getDataEmprestimo());
            dto.setDataDevolucao(e.getDataDevolucao());
            dto.setUsuarioId(e.getUsuario().getId());
            lista.add(dto);
        }

        return lista;
    }

    public List<EmprestimoDTO> lisarPorUsuario(Long usuarioId){
        List<Emprestimo> emprestimos = emprestimoRepository.findByUsuarioId(usuarioId);
        List<EmprestimoDTO> lista = new ArrayList<>();

        for(Emprestimo e : emprestimos){
            EmprestimoDTO dto = new EmprestimoDTO();
            dto.setId(e.getId());
            dto.setDataEmprestimo(e.getDataEmprestimo());
            dto.setDataDevolucao(e.getDataDevolucao());
            dto.setUsuarioId(e.getUsuario().getId());

            lista.add(dto);
        }

        return lista;
    }
}

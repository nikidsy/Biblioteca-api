package com.Teste.Biblioteca.service;

import com.Teste.Biblioteca.dto.CarteiraBibliotecaDTO;
import com.Teste.Biblioteca.dto.UsuarioDTO;
import com.Teste.Biblioteca.entities.CarteiraBiblioteca;
import com.Teste.Biblioteca.entities.Usuario;
import com.Teste.Biblioteca.repositories.CarteiraBibliotecaRepository;
import com.Teste.Biblioteca.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CarteiraBibliotecaService {

    private final CarteiraBibliotecaRepository carteiraBibliotecaRepository;
    private final UsuarioRepository usuarioRepository;

    public CarteiraBibliotecaService(CarteiraBibliotecaRepository carteiraBibliotecaRepository,
                                     UsuarioRepository usuarioRepository) {
        this.carteiraBibliotecaRepository = carteiraBibliotecaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public CarteiraBibliotecaDTO criarCarteira(CarteiraBibliotecaDTO dto) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(dto.getUsuarioId());

        if (usuarioOptional.isEmpty()) {
            return null;
        }

        Usuario usuario = usuarioOptional.get();

        if (usuario.getCarteiraBiblioteca() != null) {
            CarteiraBiblioteca existente = usuario.getCarteiraBiblioteca();
            dto.setNumeroCarteira(existente.getNumeroCarteira());
            dto.setDataEmissao(existente.getDataEmissao());
            dto.setIsValid(existente.isValid());
            dto.setUsuarioId(usuario.getId());

            return dto;
        }

        CarteiraBiblioteca carteira = new CarteiraBiblioteca();
        carteira.setUsuario(usuario);
        carteira.setNumeroCarteira(usuario.getId());
        carteira.setDataEmissao(LocalDate.now());
        carteira.setValid(true);

        carteira = carteiraBibliotecaRepository.save(carteira);

        usuario.setCarteiraBiblioteca(carteira);

        CarteiraBibliotecaDTO resposta = new CarteiraBibliotecaDTO();
        resposta.setNumeroCarteira(carteira.getNumeroCarteira());
        resposta.setDataEmissao(carteira.getDataEmissao());
        resposta.setIsValid(carteira.isValid());
        resposta.setUsuarioId(usuario.getId());

        return resposta;
    }
}

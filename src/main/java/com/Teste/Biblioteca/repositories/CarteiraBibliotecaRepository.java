package com.Teste.Biblioteca.repositories;

import com.Teste.Biblioteca.entities.CarteiraBiblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarteiraBibliotecaRepository extends JpaRepository<CarteiraBiblioteca, Long> {
}

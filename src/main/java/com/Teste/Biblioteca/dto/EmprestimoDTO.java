package com.Teste.Biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoDTO {

    private Long id;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private Long usuarioId;
}

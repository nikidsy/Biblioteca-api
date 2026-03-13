package com.Teste.Biblioteca.dto;

import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "A data de empréstimo é obrigatória")
    private LocalDate dataEmprestimo;

    @NotNull(message = "A data de devolução é obrigatória")
    private LocalDate dataDevolucao;

    @NotNull(message = "O usuário é obrigatório")
    private Long usuarioId;
}

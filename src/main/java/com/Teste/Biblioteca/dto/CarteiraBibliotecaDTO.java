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
public class CarteiraBibliotecaDTO {

    private Long numeroCarteira;

    @NotNull(message = "A data de emissão é obrigatória")
    private LocalDate dataEmissao;

    @NotNull(message = "O status da carteira é obrigatório")
    private Boolean isValid;

    @NotNull(message = "O usuário é obrigatório")
    private Long usuarioId;
}

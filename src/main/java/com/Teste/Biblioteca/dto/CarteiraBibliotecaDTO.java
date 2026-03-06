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
public class CarteiraBibliotecaDTO {

    private Long numeroCarteira;
    private LocalDate dataEmissao;
    private Boolean isValid;
    private Long usuarioId;
}

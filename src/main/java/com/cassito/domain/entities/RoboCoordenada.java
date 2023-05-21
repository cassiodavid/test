package com.cassito.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class RoboCoordenada {

    private Integer x;

    private Integer y;

    private String posicao;

    private String entrada;

    private String saida;

}

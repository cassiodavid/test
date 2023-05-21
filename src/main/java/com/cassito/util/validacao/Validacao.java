package com.cassito.util.validacao;

public class Validacao {

    public static Boolean validarEntradaPost(String post){
        if (post.matches("[MRL]+")) {
            return true;
        } else {
            throw new IllegalArgumentException("Posição inválida. Apenas as letras M, R ou L são permitidas.");
        }
    }

    public static Boolean rangeCordenadaValidacaoMax5x5(Integer xs, Integer ys){
        validarCordenadasMaximas<Integer, Integer>
                valid = (x,y) -> x > 5 || x < -5 || y > 5 || y < -5;
        if (!valid.testMax5x5(xs, ys)){
            return true;
        } else {
            throw new IllegalArgumentException("coordenadas x ou y sao maiores que o range permitido retorno");
        }

    }

}

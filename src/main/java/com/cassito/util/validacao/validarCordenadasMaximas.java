package com.cassito.util.validacao;

@FunctionalInterface
public interface validarCordenadasMaximas<T, G> {
    Boolean testMax5x5(T t, G g);
}

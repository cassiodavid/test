package com.cassito.exception;

import com.cassito.expection.RoboCoordenadaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class exceptionsTest {

    @Test
    public void whenOfferExceptionIsCalled_ShouldBeReturnThrow() {
        Throwable exception = assertThrows(RoboCoordenadaException.class, () -> {
            throw new RoboCoordenadaException("Posição inválida. Apenas as letras M, R ou L são permitidas.");
        });
        assertEquals("Posição inválida. Apenas as letras M, R ou L são permitidas.", exception.getMessage());
    }


    @Test
    public void whenOfferExceptionIsCalled_ShouldBeReturnThrows() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("coordenadas x ou y sao maiores que o range permitido retorno");
        });
        assertEquals("coordenadas x ou y sao maiores que o range permitido retorno", exception.getMessage());
    }
}

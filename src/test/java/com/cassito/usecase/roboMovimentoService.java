package com.cassito.usecase;

import com.cassito.domain.entities.RoboCoordenada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.cassito.util.mocks.RoboCoordenadaMock.roboCoordenadaMockMML;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class roboMovimentoService {

    @Mock
    private RoboCoordenadaUseCase roboCoordenadaUseCase;

    @BeforeEach
    void setup(){
        when(roboCoordenadaUseCase.calculcarCoordenadas(any())).thenReturn(roboCoordenadaMockMML());
    }

    @Test
    void testRetonoSucessoComandosRoboImput(){
        RoboCoordenada resul = roboCoordenadaUseCase.calculcarCoordenadas("MML");
        assertEquals(resul.getSaida(), "(0,2,W)");
    }


}

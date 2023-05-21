package com.cassito.controller;

import com.cassito.usecase.RoboCoordenadaUseCase;
import main.openapi.openapi.model.RoboCoordenadaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static com.cassito.util.mocks.RoboCoordenadaMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class apiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private ApiController apiController;

    @Mock
    private RoboCoordenadaUseCase roboCoordenadaUseCase;

    @BeforeEach
    void setup(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    void post_succesComandosMML(){

        when(roboCoordenadaUseCase.calculcarCoordenadas(any())).thenReturn(roboCoordenadaMockMML());
        ResponseEntity<RoboCoordenadaDTO> response = apiController.getMovimentacoes("MML");
        assertEquals(response.getBody().getSaida(), "(0,2,W)");
    }

    @Test
    void post_SuccesComandosMMR(){

        when(roboCoordenadaUseCase.calculcarCoordenadas(any())).thenReturn(roboCoordenadaMockMMR());
        ResponseEntity<RoboCoordenadaDTO> response = apiController.getMovimentacoes("MMR");
        assertEquals(response.getBody().getSaida(), "(0,2,E)");
    }

    @Test
    void post_SuccesComandosMMRMMRMM(){

        when(roboCoordenadaUseCase.calculcarCoordenadas(any())).thenReturn(roboCoordenadaMockMMRMMRMM());
        ResponseEntity<RoboCoordenadaDTO> response = apiController.getMovimentacoes("MMR");
        assertEquals(response.getBody().getSaida(), "(2,0,S)");
    }

    @Test
    void post_invalidosComandosDeEntrada(){
        String entradasDiferentesdeMouRouL = "AAA";
        assertThrows(IllegalArgumentException.class, () -> apiController.getMovimentacoes(entradasDiferentesdeMouRouL));
    }

}

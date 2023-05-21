package com.cassito.controller;

import com.cassito.controller.mapper.ApiControllerMapper;
import com.cassito.domain.entities.RoboCoordenada;
import com.cassito.usecase.RoboCoordenadaUseCase;
import lombok.AllArgsConstructor;
import main.openapi.api.RestApi;
import main.openapi.openapi.model.RoboCoordenadaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.cassito.util.validacao.Validacao.validarEntradaPost;

@RestController
@RequestMapping
@AllArgsConstructor
public class ApiController implements RestApi {

    private RoboCoordenadaUseCase roboCoordenadaUseCase;
    @Override
    public ResponseEntity<RoboCoordenadaDTO> getMovimentacoes(String movimentos) {
        validarEntradaPost(movimentos);
        RoboCoordenada roboCordenada = roboCoordenadaUseCase.calculcarCoordenadas(movimentos);
        return ResponseEntity.ok(ApiControllerMapper.INSTANCE.map(roboCordenada));
    }

}

package com.cassito.usecase.impl;

import com.cassito.domain.entities.RoboCoordenada;
import com.cassito.domain.enuns.DirecaoEnum;
import com.cassito.usecase.RoboCoordenadaUseCase;
import org.springframework.stereotype.Component;

import static com.cassito.util.validacao.Validacao.rangeCordenadaValidacaoMax5x5;

@Component
public class RoboCoordenadaUseCaseImpl implements RoboCoordenadaUseCase {

    @Override
    public RoboCoordenada calculcarCoordenadas(String comandos) {
        int x = 0, y = 0;
        int direcao = 0; // 0 - NORTH, 1 - EAST, 2 - SOUTH, 3 - WEST
        for (int i = 0; i < comandos.length(); i++) {
            switch (comandos.charAt(i)) {
                case 'R':
                    direcao = (direcao + 1) % 4;
                    break;
                case 'L':
                    direcao = (direcao + 3) % 4; // não da pra fazer Div com numeros negativos
                    break;
                case 'M':
                    int passo = 1;
                    switch (direcao) {
                        case 0:
                            y += passo;
                            break;
                        case 1:
                            x += passo;
                            break;
                        case 2:
                            y -= passo;
                            break;
                        case 3:
                            x -= passo;
                            break;
                    }
                    break;
            }
        }
        rangeCordenadaValidacaoMax5x5(x, y);
        DirecaoEnum direction = DirecaoEnum.getByValue(direcao);
       return new RoboCoordenada(x,y,direction.getKey(),comandos,"("+x+","+y+","+direction.getKey().charAt(0)+")");
    }

}

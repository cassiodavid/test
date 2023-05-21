package com.cassito.util.mocks;

import com.cassito.domain.entities.RoboCoordenada;
import com.cassito.domain.enuns.DirecaoEnum;

public class RoboCoordenadaMock {

    public static RoboCoordenada roboCoordenadaMockMML(){
        return new RoboCoordenada(
                0,
                2,
                DirecaoEnum.WEST.getKey(),
                "MMR",
                "(0,2,W)"
        );
    }

    public static RoboCoordenada roboCoordenadaMockMMR(){
        return new RoboCoordenada(
                0,
                2,
                DirecaoEnum.EAST.getKey(),
                "MMR",
                "(0,2,E)"
        );
    }

    public static RoboCoordenada roboCoordenadaMockMMRMMRMM(){
        return new RoboCoordenada(
                2,
                0,
                DirecaoEnum.SOUTH.getKey(),
                "MMRMMRMM",
                "(2,0,S)"
        );

    }

    public static RoboCoordenada roboCoordenadaMockError(){
        return new RoboCoordenada(
                6,
                6,
                DirecaoEnum.SOUTH.getKey(),
                "MMRMMRMM",
                "(2,0,S)"
        );

    }





}

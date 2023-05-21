package com.cassito.domain.enuns;

public enum DirecaoEnum {

    NORTH("NORTH", 0),
    EAST("EAST", 1),
    SOUTH("SOUTH", 2),
    WEST("WEST", 3);

    private final String key;
    private final int value;

    private DirecaoEnum(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public static DirecaoEnum getByValue(int value) {
        for (DirecaoEnum direcao : DirecaoEnum.values()) {
            if (direcao.getValue() == value) {
                return direcao;
            }
        }
        throw new IllegalArgumentException("Direção inválida: " + value);
    }
}
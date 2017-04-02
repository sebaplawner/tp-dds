package com.tp.dds.empresa;

public class Cuenta {
    private final String id;
    private final int valor;

    public Cuenta(String id, int valor) {
        this.id = id;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public int getValor() {
        return valor;
    }
}

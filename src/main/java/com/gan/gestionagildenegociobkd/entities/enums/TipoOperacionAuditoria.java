package com.gan.gestionagildenegociobkd.entities.enums;

public enum TipoOperacionAuditoria {

    REGISTRO(1,"Registro"),
    ACUALIZACION(2,"Actualización"),
    ELIMINACION(2,"Eliminación");

    private Integer indice;
    private String valor;

    private TipoOperacionAuditoria(Integer indice, String valor) {
        this.indice = indice;
        this.valor = valor;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}

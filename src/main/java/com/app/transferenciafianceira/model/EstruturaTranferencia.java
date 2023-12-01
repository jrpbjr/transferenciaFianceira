package com.app.transferenciafianceira.model;

import java.io.Serializable;

public class EstruturaTranferencia implements Serializable {

    private static final long serialVersionUID = 887252308487380732L;

    private Integer id;

    public Integer getId() {
        return id;
    }
    public EstruturaTranferencia(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

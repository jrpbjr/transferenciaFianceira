package com.app.transferenciafianceira.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
@MappedSuperclass
public class EstruturaTransferencia implements Serializable {

    private static final long serialVersionUID = 887252308487380732L;
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;

    public EstruturaTransferencia() {

    }

    public Integer getId() {
        return id;
    }
    public EstruturaTransferencia(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

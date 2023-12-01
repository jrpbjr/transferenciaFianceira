package com.app.transferenciafianceira.model.Dto;


import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferenciaDto implements Serializable {

    private static final long serialVersionUID = 1430309725429919536L;

    protected Integer id;
    @NotNull(message = "contaOrigem e obrigatorio.")
    protected String contaOrigem;
    @NotNull(message = "contaDestino e obrigatorio.")
    protected String contaDestino;
    @NotNull(message = "valorTranferencia e obrigatorio.")
    protected BigDecimal valorTranferencia;
    @NotNull(message = "taxa e obrigatorio.")
    protected BigDecimal taxa;

    @NotNull(message = "dataAgentamento e obrigatorio.")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    protected LocalDate dataAgentamento;

    public TransferenciaDto() {
    }

    public TransferenciaDto(Integer id, String contaOrigem, String contaDestino, BigDecimal valorTranferencia, BigDecimal taxa, LocalDate dataAgentamento) {
        super();
        this.id = id;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valorTranferencia = valorTranferencia;
        this.taxa = taxa;
        this.dataAgentamento = dataAgentamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(String contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }

    public BigDecimal getValorTranferencia() {
        return valorTranferencia;
    }

    public void setValorTranferencia(BigDecimal valorTranferencia) {
        this.valorTranferencia = valorTranferencia;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public LocalDate getDataAgentamento() {
        return dataAgentamento;
    }

    public void setDataAgentamento(LocalDate dataAgentamento) {
        this.dataAgentamento = dataAgentamento;
    }

}



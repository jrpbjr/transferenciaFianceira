package com.app.transferenciafianceira.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Tranferencia extends EstruturaTranferencia {

    private static final long serialVersionUID = 8463643755828714711L;
    private String contaOrigem;
    private String contaDestino;
    private BigDecimal valorTranferencia;
    private BigDecimal taxa;
    private BigDecimal dataAgentamento;
    private BigDecimal valorTaxa;

    public Tranferencia(Integer id, String contaOrigem, String contaDestino, BigDecimal valorTranferencia, BigDecimal taxa, BigDecimal dataAgentamento, BigDecimal valorTaxa) {
        super(id);
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valorTranferencia = valorTranferencia;
        this.taxa = taxa;
        this.dataAgentamento = dataAgentamento;
        this.valorTaxa = valorTaxa;
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

    public BigDecimal getDataAgentamento() {
        return dataAgentamento;
    }

    public void setDataAgentamento(BigDecimal dataAgentamento) {
        this.dataAgentamento = dataAgentamento;
    }

    public BigDecimal getValorTaxa() {
        return valorTaxa;
    }

    public void setValorTaxa(BigDecimal valorTaxa) {
        this.valorTaxa = valorTaxa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tranferencia that = (Tranferencia) o;
        return Objects.equals(contaOrigem, that.contaOrigem) && Objects.equals(contaDestino, that.contaDestino) && Objects.equals(valorTranferencia, that.valorTranferencia) && Objects.equals(taxa, that.taxa) && Objects.equals(dataAgentamento, that.dataAgentamento) && Objects.equals(valorTaxa, that.valorTaxa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contaOrigem, contaDestino, valorTranferencia, taxa, dataAgentamento, valorTaxa);
    }

    @Override
    public String toString() {
        return "Tranferencia{" +
                "contaOrigem='" + contaOrigem + '\'' +
                ", contaDestino='" + contaDestino + '\'' +
                ", valorTranferencia=" + valorTranferencia +
                ", taxa=" + taxa +
                ", dataAgentamento=" + dataAgentamento +
                ", valorTaxa=" + valorTaxa +
                '}';
    }
}

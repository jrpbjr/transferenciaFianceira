package com.app.transferenciafianceira.model;

import com.app.transferenciafianceira.model.Dto.TransferenciaDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity (name = "transferencia")
public class TransferenciaModel extends EstruturaTransferencia {

    private static final long serialVersionUID = 8463643755828714711L;
    @Column(name = "conta_origem")
    private String contaOrigem;
    @Column(name = "conta_destino")
    private String contaDestino;
    @Column(name = "valor_transferencia")
    private BigDecimal valorTranferencia;
    @Column(name = "taxa")
    private BigDecimal taxa;
    @Column(name = "data_agentamento")
    private LocalDate dataAgentamento;
    @Column(name = "valor_taxa")
    private BigDecimal valorTaxa;

    public TransferenciaModel(Integer id) {
        super();
    }
    public TransferenciaModel() {
        super();
    }

    public TransferenciaModel( String contaOrigem, String contaDestino, BigDecimal valorTranferencia, BigDecimal taxa, LocalDate dataAgentamento, BigDecimal valorTaxa) {
        super();
        this.id = id;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valorTranferencia = valorTranferencia;
        this.taxa = taxa;
        this.dataAgentamento = dataAgentamento;
        this.valorTaxa = valorTaxa;
    }

    public TransferenciaModel(TransferenciaDto transferenciaDto) {
        super();
        this.contaOrigem = transferenciaDto.getContaOrigem();
        this.contaDestino = transferenciaDto.getContaDestino();
        this.valorTranferencia = transferenciaDto.getValorTranferencia();
        this.taxa = transferenciaDto.getTaxa();
        this.dataAgentamento = transferenciaDto.getDataAgentamento();
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
        TransferenciaModel that = (TransferenciaModel) o;
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

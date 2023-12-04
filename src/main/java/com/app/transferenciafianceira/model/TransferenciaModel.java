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
    private BigDecimal valorTransferencia;
    @Column(name = "taxa")
    private BigDecimal taxa;
    @Column(name = "data_agentamento")
    private LocalDate dataAgentamento;
    public TransferenciaModel(Integer id) {
        super();
    }
    public TransferenciaModel() {
        super();
    }

    public TransferenciaModel( String contaOrigem, String contaDestino, BigDecimal valorTransferencia, BigDecimal taxa, LocalDate dataAgentamentoa) {
        super();
        this.id = id;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valorTransferencia = valorTransferencia;
        this.taxa = taxa;
        this.dataAgentamento = dataAgentamento;
    }

    public TransferenciaModel(TransferenciaDto transferenciaDto) {
        super();
        this.contaOrigem = transferenciaDto.getContaOrigem();
        this.contaDestino = transferenciaDto.getContaDestino();
        this.valorTransferencia = transferenciaDto.getValorTransferencia();
        this.dataAgentamento = transferenciaDto.getDataAgendamento();
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

    public BigDecimal getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(BigDecimal valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
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




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferenciaModel that = (TransferenciaModel) o;
        return Objects.equals(contaOrigem, that.contaOrigem) && Objects.equals(contaDestino, that.contaDestino) && Objects.equals(valorTransferencia, that.valorTransferencia) && Objects.equals(taxa, that.taxa) && Objects.equals(dataAgentamento, that.dataAgentamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contaOrigem, contaDestino, valorTransferencia, taxa, dataAgentamento);
    }

    @Override
    public String toString() {
        return "Tranferencia{" +
                "contaOrigem='" + contaOrigem + '\'' +
                ", contaDestino='" + contaDestino + '\'' +
                ", valorTranferencia=" + valorTransferencia +
                ", taxa=" + taxa +
                ", dataAgentamento=" + dataAgentamento +
                '}';
    }
}

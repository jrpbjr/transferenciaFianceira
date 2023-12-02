package com.app.transferenciafianceira.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.app.transferenciafianceira.exception.NegocioException;
import com.app.transferenciafianceira.model.TransferenciaModel;
import com.app.transferenciafianceira.repositories.TransferenciaRepository;
import com.app.transferenciafianceira.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Override
    public BigDecimal calcularTaxa(TransferenciaModel transferenciaModel) throws NegocioException {
        Double diferencaDeDias = calcularDiferencaDeDias(LocalDate.now(), transferenciaModel.getDataAgentamento());

        BigDecimal taxa =  new BigDecimal("0.0");

        //
        BigDecimal TaxacaoZero = new BigDecimal("2.5");
        //BigDecimal TaxacaoEntreUmEDez = new BigDecimal("0.0");
        BigDecimal TaxacaoEntreOnzeEVinte = new BigDecimal("8.2");
        BigDecimal TaxacaoEntreVinteEUmETrinta = new BigDecimal("6.9");
        BigDecimal TaxacaoEntreTrintaEUmEQuarenta = new BigDecimal("4.7");
        BigDecimal TaxacaoEntreQuarentaEUmECincoenta = new BigDecimal("1.7");

        // Taxa entre 0 dias
        if(diferencaDeDias == 0){
            System.out.println("Zero");
            taxa = (transferenciaModel.getValorTranferencia().multiply(TaxacaoZero).add(new BigDecimal("3.0")));
            transferenciaModel.setTaxa(taxa);
            System.out.println(taxa.setScale(1));
        } else if(diferencaDeDias >= 1 && diferencaDeDias <= 10){
            System.out.println("Entre 1 e 10");
            taxa = (transferenciaModel.getValorTranferencia().add(new BigDecimal("12.0")));
            transferenciaModel.setTaxa(taxa);
        } else if(diferencaDeDias >= 11 && diferencaDeDias <= 20){
            System.out.println("Entre 11 e 20");
            taxa = (transferenciaModel.getValorTranferencia().multiply(TaxacaoEntreOnzeEVinte));
            transferenciaModel.setTaxa(taxa);
        } else if(diferencaDeDias >= 21 && diferencaDeDias <= 30){
            System.out.println("Entre 21 e 30");
            taxa = (transferenciaModel.getValorTranferencia().multiply(TaxacaoEntreVinteEUmETrinta));
            transferenciaModel.setTaxa(taxa);
        }else if(diferencaDeDias >= 31 && diferencaDeDias <= 40){
            System.out.println("Entre 31 e 40");
            taxa = (transferenciaModel.getValorTranferencia().multiply(TaxacaoEntreTrintaEUmEQuarenta));
            transferenciaModel.setTaxa(taxa);
        }else if(diferencaDeDias >= 41 && diferencaDeDias <= 50){
            System.out.println("Entre 41 e 50");
            taxa = (transferenciaModel.getValorTranferencia().multiply(TaxacaoEntreQuarentaEUmECincoenta));
            transferenciaModel.setTaxa(taxa);
        } else {
            transferenciaModel.setTaxa(taxa);
            System.out.println("Maior que 50 Exception");
            throw new NegocioException("Não ha taxa aplicavel para esta transferência");
        }
        return taxa.setScale(1);
    }

    @Override
    public TransferenciaModel salvarTransferencia(TransferenciaModel transferenciaModel) throws NegocioException  {
        this.validar(transferenciaModel);
        transferenciaModel.setId(null);
        return transferenciaRepository.save(transferenciaModel);
    }

    private void validar(TransferenciaModel transferenciaModel) throws NegocioException{
        this.validarTaxa(transferenciaModel);
    }

    private void validarTaxa(TransferenciaModel transferenciaModel) throws NegocioException{
        if (transferenciaModel.getTaxa().compareTo(BigDecimal.ZERO) < 0) {
            throw new NegocioException("Não ha taxa aplicavel para esta transferência");
        }
    }

    private Double calcularDiferencaDeDias(LocalDate dataMenor, LocalDate dataMaior) {
        Period periodo = Period.between(dataMenor, dataMaior);
        Double diff = (double) (periodo.getDays() + (periodo.getMonths() * 30) + (periodo.getYears() * 365));
        return diff;
    }

}

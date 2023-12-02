package com.app.transferenciafianceira.service;

import com.app.transferenciafianceira.exception.NegocioException;
import com.app.transferenciafianceira.model.TransferenciaModel;

import java.math.BigDecimal;

public interface TransferenciaService {

    public BigDecimal calcularTaxa(TransferenciaModel transferenciaModel) throws NegocioException;

    public TransferenciaModel salvarTransferencia(TransferenciaModel transferenciaModel) throws NegocioException;

}


package com.app.transferenciafianceira.controller;

import com.app.transferenciafianceira.exception.NegocioException;
import com.app.transferenciafianceira.model.Dto.TransferenciaDto;
import com.app.transferenciafianceira.model.TransferenciaModel;
import com.app.transferenciafianceira.service.TransferenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @PostMapping("/salvarTransferencia")
    public ResponseEntity<TransferenciaDto> salvarTransferencia(@Valid @RequestBody TransferenciaDto transferenciaDto) throws NegocioException {

        TransferenciaModel transferenciaModel = new TransferenciaModel(transferenciaDto);
        this.transferenciaService.salvarTransferencia(transferenciaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transferenciaModel.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}

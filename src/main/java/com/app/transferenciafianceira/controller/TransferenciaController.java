package com.app.transferenciafianceira.controller;

import com.app.transferenciafianceira.exception.NegocioException;
import com.app.transferenciafianceira.exception.ResourceNotFoundException;
import com.app.transferenciafianceira.model.Dto.TransferenciaDto;
import com.app.transferenciafianceira.model.TransferenciaModel;
import com.app.transferenciafianceira.repositories.TransferenciaRepository;
import com.app.transferenciafianceira.service.TransferenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.print.Pageable;
import java.net.URI;
import java.util.*;

@RestController
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;
    @Autowired
    private TransferenciaRepository transferenciaRepository;


    @PostMapping("/salvarTransferencia")
    public ResponseEntity<TransferenciaDto> salvarTransferencia(@Valid @RequestBody TransferenciaDto transferenciaDto) throws NegocioException {

        TransferenciaModel transferenciaModel = new TransferenciaModel(transferenciaDto);
        this.transferenciaService.salvarTransferencia(transferenciaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transferenciaModel.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/consultarTransferencias")
    public ResponseEntity<Map<String, Object>> getAllTransferencias(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        try{
            List<TransferenciaModel> transferenciaModelList = new ArrayList<TransferenciaModel>();
            PageRequest paging =  PageRequest.of(page, size);

            Page<TransferenciaModel> pageTuts;

            pageTuts = transferenciaRepository.findAll(paging);

            transferenciaModelList = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();

            response.put("transferencias", transferenciaModelList);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (ResourceNotFoundException e) {

           return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

        }
    }

}

package com.app.transferenciafianceira.repositories;

import com.app.transferenciafianceira.model.TransferenciaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TransferenciaRepository extends JpaRepository<TransferenciaModel, Integer> {

    Page<TransferenciaModel> findByDataAgentamento(LocalDate dataAgentamento,Pageable pageable);
    Page<TransferenciaModel> findByid (Integer id, Pageable pageable);


}

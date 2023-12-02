package com.app.transferenciafianceira.repositories;

import com.app.transferenciafianceira.model.TransferenciaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<TransferenciaModel, Integer> {

}

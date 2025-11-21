package com.estudotecnicojava.javasqltec.repository;

import com.estudotecnicojava.javasqltec.entity.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LancamentosRepository extends JpaRepository<Lancamento, Long> {
    List<Lancamento> findByContaId(Long contaId);


}

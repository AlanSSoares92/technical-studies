package com.estudotecnicojava.javasqltec.service;


import com.estudotecnicojava.javasqltec.entity.Conta;
import com.estudotecnicojava.javasqltec.entity.Lancamento;
import com.estudotecnicojava.javasqltec.exception.ContaNaoEncontradaException;
import com.estudotecnicojava.javasqltec.repository.ContaRepository;
import com.estudotecnicojava.javasqltec.repository.LancamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired private final ContaRepository contaRepository;
    @Autowired private final LancamentosRepository lancamentoRepository;

    public ContaService(ContaRepository contaRepository,
                        LancamentosRepository lancamentoRepository) {
        this.contaRepository = contaRepository;
        this.lancamentoRepository = lancamentoRepository;
    }

    public List<Long> buscarIdsLancamentosDaConta(String numeroConta) {

        Conta conta = contaRepository.findByNumero(numeroConta)
                .orElseThrow(() -> new ContaNaoEncontradaException(numeroConta));

        return lancamentoRepository.findByContaId(conta.getId())
                .stream()
                .map(Lancamento::getId)
                .toList();
    }
}

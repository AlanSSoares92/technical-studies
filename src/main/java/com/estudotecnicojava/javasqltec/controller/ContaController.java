package com.estudotecnicojava.javasqltec.controller;

import com.estudotecnicojava.javasqltec.service.ContaService;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping("/{numero}/lancamentos")
    public ResponseEntity<List<Long>> buscarIdsLancamentos(@PathVariable
@Pattern(regexp = "\\d{8}", message = "Número da conta deve ter 8 dígitos") //opcional para regras direto no path
                                                               String numero) {
        return ResponseEntity.ok(contaService.buscarIdsLancamentosDaConta(numero));
    }
}

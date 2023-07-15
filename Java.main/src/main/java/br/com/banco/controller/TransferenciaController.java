package br.com.banco.controller;

import br.com.banco.DTO.TransferenciaDTO;
import br.com.banco.service.ContaService;
import br.com.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/transferencias")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @GetMapping("/byContaId")
    public ResponseEntity<List<TransferenciaDTO>> findAllByContaId(@Param("id") Long contaId) {
        List<TransferenciaDTO> transferencias = transferenciaService.findAllByConta(contaId).stream()
                .map(TransferenciaDTO::fromTransferencia)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(transferencias);
    }

    @GetMapping
    public ResponseEntity<List<TransferenciaDTO>> findAll() {
        List<TransferenciaDTO> transferencias = transferenciaService.findAll().stream()
                .map(TransferenciaDTO::fromTransferencia)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(transferencias);
    }

    @GetMapping("/byTempo")
    public ResponseEntity<List<TransferenciaDTO>> findBetweenDate(
            @Param("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @Param("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<TransferenciaDTO> transferencias = transferenciaService.findAllBeetwenDate(startDate, endDate).stream()
                .map(TransferenciaDTO::fromTransferencia)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(transferencias);
    }

    @GetMapping("/byNome")
    public ResponseEntity<List<TransferenciaDTO>> findByName(@Param("operatorName") String operatorName) {
        List<TransferenciaDTO> transferencias = transferenciaService.findByName(operatorName).stream()
                .map(TransferenciaDTO::fromTransferencia)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(transferencias);
    }
}

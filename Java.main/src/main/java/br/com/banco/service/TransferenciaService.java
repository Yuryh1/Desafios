package br.com.banco.service;

import br.com.banco.Entities.Transferencia;
import br.com.banco.Repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<Transferencia> findAllByConta(Long conta_id){
        return transferenciaRepository.findAllTransferencia(conta_id);
    }

    public List<Transferencia> findAll() {
        return transferenciaRepository.findAll();
    }

    public List<Transferencia> findAllBeetwenDate(LocalDate startDate, LocalDate endDate) {

        return transferenciaRepository.findAllBeetwenDate(startDate, endDate);
    }

    public List<Transferencia> findByName(String operatorName) {
        return transferenciaRepository.findByNomeOperadorTransacao(operatorName);
    }
}

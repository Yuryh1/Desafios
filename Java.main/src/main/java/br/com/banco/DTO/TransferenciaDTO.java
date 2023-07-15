package br.com.banco.DTO;

import br.com.banco.Entities.Enum.Tipos;
import br.com.banco.Entities.Transferencia;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferenciaDTO {
    private Long id;

    private LocalDateTime dataTransferencia;
    private BigDecimal valor;
    private String tipo;
    private String getNomeOperadorTransacao;

    public TransferenciaDTO(Long id, LocalDateTime dataTransferencia, BigDecimal valor, Tipos tipo, String nomeOperadorTransacao) {
    }

    public static TransferenciaDTO fromTransferencia(Transferencia transferencia) {
        return new TransferenciaDTO(
                transferencia.getId(),
                transferencia.getDataTransferencia(),
                transferencia.getValor(),
                transferencia.getTipo(),
                transferencia.getNomeOperadorTransacao()
        );
    }
}



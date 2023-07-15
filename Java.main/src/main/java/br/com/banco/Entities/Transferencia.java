package br.com.banco.Entities;

import br.com.banco.Entities.Enum.Tipos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "transferencia")
public class Transferencia {


    @Id
    private Long id;

    //    @NotNull
    @Column(name = "data_transferencia")
    private LocalDateTime dataTransferencia;

    //    @NotNull
    @Column(name = "valor", precision = 20, scale = 2)
    private BigDecimal valor;

    //    @NotNull
    @Column(name = "tipo")
    @Enumerated(value = EnumType.STRING)
    private Tipos tipo;

    //    @NotNull
    @Column(name = "nome_operador_transacao", length = 50)
    private String nomeOperadorTransacao;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

}
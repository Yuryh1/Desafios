package br.com.banco.DTO;

import br.com.banco.Entities.Conta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaDTO {
    private Long idConta;
    private String nomeResponsavel;

    public  static ContaDTO fromConta(Conta conta){
        return new ContaDTO(conta.getId_conta(), conta.getNomeResponsavel());

}



}
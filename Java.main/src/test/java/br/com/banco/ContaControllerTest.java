package br.com.banco;

import br.com.banco.DTO.ContaDTO;
import br.com.banco.Entities.Conta;
import br.com.banco.controller.ContaController;
import br.com.banco.service.ContaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class ContaControllerTest {
    @Mock
    private ContaService contaService;

    @InjectMocks
    private ContaController contaController;
    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);

    }
    @Test
    public void testFindAll(){
        Conta conta1 = new Conta(1L, "João",null);
        Conta conta2 = new Conta(2L, "Maria",null);
        List<Conta>contas = Arrays.asList(conta1,conta2);

        when(contaService.findAll()).thenReturn(contas);

        ResponseEntity<List<ContaDTO>> response = contaController.findAll();

        assertEquals(200, response.getStatusCodeValue());
        List<ContaDTO> contasDTO = response.getBody();
        assertEquals(2, contasDTO.size());
        assertEquals(conta1.getId_conta(),contasDTO.get(0).getIdConta());
        assertEquals(conta1.getNomeResponsavel(),contasDTO.get(0).getNomeResponsavel());
        assertEquals(conta2.getId_conta(),contasDTO.get(1).getIdConta());
        assertEquals(conta2.getNomeResponsavel(),contasDTO.get(1).getNomeResponsavel());



    }


}

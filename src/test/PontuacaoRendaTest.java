package test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.desafio.model.Familia;
import br.com.desafio.service.impl.PontuacaoRenda;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PontuacaoRendaTest {
    @Test
    public void testCalcularPontos_rendaMenorIgualA900_retorna5() {
        Familia familia = new Familia("A", 900, new ArrayList<>());

        PontuacaoRenda pontuacaoRenda = new PontuacaoRenda();
        int pontos = pontuacaoRenda.calcularPontos(familia);

        assertEquals(5, pontos);
    }

    @Test
    public void testCalcularPontos_rendaMenorIgualA1500_retorna3() {
        Familia familia = new Familia("B", 1500, new ArrayList<>());

        PontuacaoRenda pontuacaoRenda = new PontuacaoRenda();
        int pontos = pontuacaoRenda.calcularPontos(familia);

        assertEquals(3, pontos);
    }

    @Test
    public void testCalcularPontos_rendaMaior1500_retorna0() {
        Familia familia = new Familia("C", 1501, new ArrayList<>());

        PontuacaoRenda pontuacaoRenda = new PontuacaoRenda();
        int pontos = pontuacaoRenda.calcularPontos(familia);

        assertEquals(0, pontos);
    }
}

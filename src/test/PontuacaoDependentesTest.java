package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.desafio.model.Dependente;
import br.com.desafio.model.Familia;
import br.com.desafio.service.impl.PontuacaoDependentes;

public class PontuacaoDependentesTest {
    private Familia familia;
    private PontuacaoDependentes pontuacaoDependentes;
    private List<Dependente> dependentes;

    @Before
    public void setUp() {
        dependentes = new ArrayList<>();
        pontuacaoDependentes = new PontuacaoDependentes();
    }

    @Test
    public void testarCalculoComTresDependentes() {
        dependentes.add(new Dependente(16));
        dependentes.add(new Dependente(15));
        dependentes.add(new Dependente(12));
        familia = new Familia("A", 1000, dependentes);

        int pontos = pontuacaoDependentes.calcularPontos(familia);
        assertEquals(3, pontos);
    }

    @Test
    public void testarCalculoComDoisDependentes() {
        dependentes.add(new Dependente(16));
        dependentes.add(new Dependente(15));
        familia = new Familia("B",1000, dependentes);

        int pontos = pontuacaoDependentes.calcularPontos(familia);
        assertEquals(2, pontos);
    }

    @Test
    public void testarCalculoComUmDependente() {
        dependentes.add(new Dependente(16));
        familia = new Familia("C", 1000, dependentes);

        int pontos = pontuacaoDependentes.calcularPontos(familia);
        assertEquals(2, pontos);
    }

    @Test
    public void testarCalculoSemDependentes() {
        familia = new Familia("D", 1000, dependentes);

        int pontos = pontuacaoDependentes.calcularPontos(familia);
        assertEquals(0, pontos);
    }
}

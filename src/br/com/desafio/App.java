package br.com.desafio;

import br.com.desafio.model.Dependente;
import br.com.desafio.model.Familia;
import br.com.desafio.service.impl.PontuacaoDependentes;
import br.com.desafio.service.impl.PontuacaoRenda;
import br.com.desafio.service.interfaces.ICalculoPontuacao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String[] args) {
        List<Familia> familias = new ArrayList<>();
        List<ICalculoPontuacao> calculoPontuacoes = new ArrayList<>();

        calculoPontuacoes.add(new PontuacaoRenda());
        calculoPontuacoes.add(new PontuacaoDependentes());

        // Adicionar as famílias e seus dados de renda e dependentes
        List<Dependente> dependentesFamilia1 = new ArrayList<>();
        dependentesFamilia1.add(new Dependente(5));
        dependentesFamilia1.add(new Dependente(15));
        dependentesFamilia1.add(new Dependente(25));

        List<Dependente> dependentesFamilia2 = new ArrayList<>();
        dependentesFamilia2.add(new Dependente(10));
        dependentesFamilia2.add(new Dependente(20));

        List<Dependente> dependentesFamilia3 = new ArrayList<>();
        dependentesFamilia3.add(new Dependente(23));

        List<Dependente> dependentesFamilia4 = new ArrayList<>();
        dependentesFamilia4.add(new Dependente(5));
        dependentesFamilia4.add(new Dependente(15));
        dependentesFamilia4.add(new Dependente(25));
        dependentesFamilia4.add(new Dependente(2));

        familias.add(new Familia("A", 800, dependentesFamilia1));
        familias.add(new Familia("B", 1000, dependentesFamilia2));
        familias.add(new Familia("C", 1200, dependentesFamilia3));
        familias.add(new Familia("D", 900, dependentesFamilia4));

        // Executar o cáculo da pontuação para cada família
        familias.forEach(f -> {
            AtomicInteger pontos = new AtomicInteger();
            calculoPontuacoes.forEach(c -> {
                pontos.addAndGet(c.calcularPontos(f));
            });
            f.setPontos(pontos.get());
        });

        Collections.sort(familias, Comparator.comparingInt(Familia::getPontos).reversed());

        familias.forEach(l -> {
            System.out.println("Família " + l.nome + ": " + l.pontos + " pontos\n");
        });
    }
}

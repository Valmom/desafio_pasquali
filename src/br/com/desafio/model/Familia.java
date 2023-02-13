package br.com.desafio.model;

import java.util.*;

public class Familia {
    public String nome;
    public long renda;
    public List<Dependente> dependentes;
    public int pontos;

    public Familia(String nome, int renda, List<Dependente> dependentes) {
        this.nome = nome;
        this.renda = renda;
        this.dependentes = dependentes;
    }

    public long getRenda() {
        return renda;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}

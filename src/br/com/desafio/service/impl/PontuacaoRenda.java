package br.com.desafio.service.impl;

import br.com.desafio.model.Familia;
import br.com.desafio.service.interfaces.ICalculoPontuacao;

public class PontuacaoRenda implements ICalculoPontuacao {
    @Override
    public int calcularPontos(Familia familia) {
        if (familia.getRenda() <= 900) {
            return 5;
        } else if (familia.getRenda() <= 1500) {
            return 3;
        }
        return 0;
    }
}

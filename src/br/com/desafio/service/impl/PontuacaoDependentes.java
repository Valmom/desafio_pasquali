package br.com.desafio.service.impl;

import br.com.desafio.model.Familia;
import br.com.desafio.service.interfaces.ICalculoPontuacao;

public class PontuacaoDependentes implements ICalculoPontuacao {
    @Override
    public int calcularPontos(Familia familia) {
        int dependentesMenores = familia.dependentes.stream().filter(s -> s.idade < 18).toArray().length;

        if (dependentesMenores >= 3) {
            return 3;
        } else if (dependentesMenores >= 1) {
            return 2;
        }
        return 0;
    }
}

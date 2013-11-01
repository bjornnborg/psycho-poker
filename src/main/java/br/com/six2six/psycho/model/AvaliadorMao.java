package br.com.six2six.psycho.model;

import br.com.six2six.psycho.model.mao.Mao;

public interface AvaliadorMao extends Comparable<AvaliadorMao> {

	DadosAvaliacaoJogo getDadosAvaliacao(Mao mao);
	int getPeso();
	
}

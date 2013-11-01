package br.com.six2six.psycho.model.mao;


import static br.com.six2six.psycho.model.mao.Jogo.PAR;
import static br.com.six2six.psycho.model.mao.Mao.comQuantidade;

import java.util.ArrayList;
import java.util.List;

import br.com.six2six.psycho.model.AvaliadorMao;
import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorPar implements AvaliadorMao {
	
	@Override
	public DadosAvaliacaoJogo getDadosAvaliacao(Mao mao) {
		boolean matches = false;
		List<Carta> cartasJogo = new ArrayList<Carta>();
		if (mao.possui(4).gruposDeValor()) {
			matches = true;
			cartasJogo = mao.cartas().doGrupo(comQuantidade(2));			
		}
		return new DadosAvaliacaoJogo(PAR, matches, cartasJogo);
	}

	@Override
	public int getPeso() {
		return 2;
	}

	@Override
	public int compareTo(AvaliadorMao o) {
		return this.getPeso() - o.getPeso();
	}	

}

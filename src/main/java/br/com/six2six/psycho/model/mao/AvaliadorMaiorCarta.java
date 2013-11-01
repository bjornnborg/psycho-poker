package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.MAIOR_CARTA;

import java.util.ArrayList;
import java.util.List;

import br.com.six2six.psycho.model.AvaliadorMao;
import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorMaiorCarta implements AvaliadorMao {
	
	@Override
	public DadosAvaliacaoJogo getDadosAvaliacao(Mao mao) {
		boolean matches = mao.possui(5).gruposDeValor();
		List<Carta> cartasJogo = new ArrayList<Carta>();
		if (matches) {
			cartasJogo.add(mao.cartas().maior());
		}
		
		return new DadosAvaliacaoJogo(MAIOR_CARTA, matches, cartasJogo);
	}

	@Override
	public int getPeso() {
		return 1;
	}

	@Override
	public int compareTo(AvaliadorMao o) {
		return this.getPeso() - o.getPeso();
	}	

}

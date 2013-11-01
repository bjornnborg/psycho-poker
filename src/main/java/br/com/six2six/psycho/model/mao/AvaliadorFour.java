package br.com.six2six.psycho.model.mao;


import static br.com.six2six.psycho.model.mao.Jogo.FOUR;
import static br.com.six2six.psycho.model.mao.Mao.comQuantidade;

import java.util.ArrayList;
import java.util.List;

import br.com.six2six.psycho.model.AvaliadorMao;
import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorFour implements AvaliadorMao {

	@Override
	public DadosAvaliacaoJogo getDadosAvaliacao(Mao mao) {
		boolean matches = false;
		List<Carta> cartasJogo = new ArrayList<Carta>();
		if (mao.possui(2).gruposDeValor() && mao.possui(4).cartasEmAlgumGrupo()) {
			matches = true;
			cartasJogo = mao.cartas().doGrupo(comQuantidade(4));			
		}
		return new DadosAvaliacaoJogo(FOUR, matches, cartasJogo);
	}
	

}

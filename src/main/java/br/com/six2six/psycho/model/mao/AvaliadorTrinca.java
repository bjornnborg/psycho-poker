package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.TRINCA;
import static br.com.six2six.psycho.model.mao.Mao.comQuantidade;

import java.util.ArrayList;
import java.util.List;

import br.com.six2six.psycho.model.AvaliadorMao;
import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorTrinca implements AvaliadorMao {

	@Override
	public DadosAvaliacaoJogo getDadosAvaliacao(Mao mao) {
		boolean matches = false;
		List<Carta> cartasJogo = new ArrayList<Carta>();
		if (mao.possui(3).gruposDeValor() && mao.possui(3).cartasEmAlgumGrupo()) {
			matches = true;
			cartasJogo = mao.cartas().doGrupo(comQuantidade(3));
		}
		return new DadosAvaliacaoJogo(TRINCA, matches, cartasJogo);
	}

}

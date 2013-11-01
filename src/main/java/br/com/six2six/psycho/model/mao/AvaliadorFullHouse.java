package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.FULL_HOUSE;

import java.util.ArrayList;
import java.util.List;

import br.com.six2six.psycho.model.AvaliadorMao;
import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorFullHouse implements AvaliadorMao {

	@Override
	public DadosAvaliacaoJogo getDadosAvaliacao(Mao mao) {
		boolean matches = false;
		List<Carta> cartasJogo = new ArrayList<Carta>();
		
		if (mao.possui(2).gruposDeValor() && mao.possui(3).cartasEmAlgumGrupo()) {
			matches = true;
			cartasJogo = mao.cartas().todas();
		}
		
		if (matches) {
			cartasJogo = mao.cartas().todas();
		}
		
		return new DadosAvaliacaoJogo(FULL_HOUSE, matches, cartasJogo);
	}
	

}

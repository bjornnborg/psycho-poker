package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.SEQUENCIA_NUMERICA_NAIPE;

import java.util.ArrayList;
import java.util.List;

import br.com.six2six.psycho.model.AvaliadorMao;
import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorSequenciaNumericaNaipe implements AvaliadorMao {
	
	private AvaliadorSequenciaNumerica sequenciaNumerica = new AvaliadorSequenciaNumerica();
	private AvaliadorSequenciaNaipe sequenciaNaipe = new AvaliadorSequenciaNaipe();

	@Override
	public DadosAvaliacaoJogo getDadosAvaliacao(Mao mao) {
		List<Carta> cartasJogo = new ArrayList<Carta>();
		boolean matches = sequenciaNaipe.getDadosAvaliacao(mao).fazJogo() && sequenciaNumerica.getDadosAvaliacao(mao).fazJogo();
		if (matches) {
			cartasJogo = mao.cartas().todas();
		}

		return new DadosAvaliacaoJogo(SEQUENCIA_NUMERICA_NAIPE, matches, cartasJogo);
	}
	

}

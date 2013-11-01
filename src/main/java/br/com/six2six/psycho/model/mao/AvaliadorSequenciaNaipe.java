package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.SEQUENCIA_NAIPE;

import java.util.ArrayList;
import java.util.List;

import br.com.six2six.psycho.model.AvaliadorMao;
import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorSequenciaNaipe implements AvaliadorMao {

	@Override
	public DadosAvaliacaoJogo getDadosAvaliacao(Mao mao) {
		List<Carta> cartasJogo = new ArrayList<Carta>();
		mao.possui(5).cartasDistintas();
		
		boolean matches = mao.possui().todasCartasMesmoNaipe();
		if (matches) {
			cartasJogo = mao.getCartas();
		}
		return new DadosAvaliacaoJogo(SEQUENCIA_NAIPE, matches, cartasJogo);
	}
	

}

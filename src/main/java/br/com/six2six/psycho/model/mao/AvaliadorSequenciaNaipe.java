package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.SEQUENCIA_NAIPE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.six2six.psycho.model.AvaliadorMao;
import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;
import br.com.six2six.psycho.model.Naipe;
import br.com.six2six.psycho.model.mao.util.AgrupadorHelper;

public class AvaliadorSequenciaNaipe implements AvaliadorMao {

	@Override
	public DadosAvaliacaoJogo getDadosAvaliacao(Mao mao) {
		Map<Naipe, List<Carta>> agrupadoPorValorFace = AgrupadorHelper.agruparPorNaipe(mao);
		boolean matches = agrupadoPorValorFace.keySet().size() == 1;
		List<Carta> cartasJogo = new ArrayList<Carta>();
		
		if (matches) {
			cartasJogo = mao.getCartas();
		}
		return new DadosAvaliacaoJogo(SEQUENCIA_NAIPE, matches, cartasJogo);
	}
	

}

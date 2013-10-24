package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.MAIOR_CARTA;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.six2six.psycho.model.AvaliadorMao;
import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;
import br.com.six2six.psycho.model.ValorFace;
import br.com.six2six.psycho.model.mao.util.AgrupadorHelper;

public class AvaliadorMaiorCarta implements AvaliadorMao {
	
	@Override
	public DadosAvaliacaoJogo getDadosAvaliacao(Mao mao) {
		Map<ValorFace, List<Carta>> agrupadoPorValorFace = AgrupadorHelper.agruparPorValorFace(mao);
		boolean matches = agrupadoPorValorFace.keySet().size() == 5;
		List<Carta> cartasJogo = new ArrayList<Carta>();
		if (matches) {
			cartasJogo.add(mao.getCartas().get(mao.getCartas().size()-1));
		}
		
		return new DadosAvaliacaoJogo(MAIOR_CARTA, matches, cartasJogo);
	}

	

}

package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.FULL_HOUSE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.six2six.psycho.model.AvaliadorMao;
import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;
import br.com.six2six.psycho.model.ValorFace;
import br.com.six2six.psycho.model.mao.util.AgrupadorHelper;

public class AvaliadorFullHouse implements AvaliadorMao {

	@Override
	public DadosAvaliacaoJogo getDadosAvaliacao(Mao mao) {
		Map<ValorFace, List<Carta>> agrupadoPorValorFace = AgrupadorHelper.agruparPorValorFace(mao);
		boolean matches = false;
		List<Carta> cartasJogo = new ArrayList<Carta>();
		
		for(ValorFace valor : agrupadoPorValorFace.keySet()) {
			if (agrupadoPorValorFace.get(valor).size() == 3) {
				matches = true;
				break;
			}
		}
		
		if (matches) {
			cartasJogo = mao.getCartas();
		}
		
		return new DadosAvaliacaoJogo(FULL_HOUSE, matches, cartasJogo);
	}
	

}
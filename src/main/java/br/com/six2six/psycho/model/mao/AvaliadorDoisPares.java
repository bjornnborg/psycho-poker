package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.DOIS_PARES;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.six2six.psycho.model.AvaliadorMao;
import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;
import br.com.six2six.psycho.model.ValorFace;
import br.com.six2six.psycho.model.mao.util.AgrupadorHelper;

public class AvaliadorDoisPares implements AvaliadorMao {

	@Override
	public DadosAvaliacaoJogo getDadosAvaliacao(Mao mao) {
		Map<ValorFace, List<Carta>> agrupadoPorValorFace = AgrupadorHelper.agruparPorValorFace(mao);
		boolean matches = false;
		List<Carta> cartasJogo = new ArrayList<Carta>();
		if (agrupadoPorValorFace.keySet().size() == 3) {
			for(ValorFace valorFace : agrupadoPorValorFace.keySet()) {
				if (agrupadoPorValorFace.get(valorFace).size() != 2) {
					continue;
				}
				matches = true;
				cartasJogo.addAll(agrupadoPorValorFace.get(valorFace));
			}
		}
		return new DadosAvaliacaoJogo(DOIS_PARES, matches, cartasJogo);
	}

}

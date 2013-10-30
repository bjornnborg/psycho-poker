package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.ValorFace.As;
import static br.com.six2six.psycho.model.mao.Jogo.SEQUENCIA_NUMERICA;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.six2six.psycho.model.AvaliadorMao;
import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;
import br.com.six2six.psycho.model.ValorFace;
import br.com.six2six.psycho.model.mao.util.AgrupadorHelper;

public class AvaliadorSequenciaNumerica implements AvaliadorMao {

	@Override
	public DadosAvaliacaoJogo getDadosAvaliacao(Mao mao) {
		Map<ValorFace, List<Carta>> agrupadoPorValorFace = AgrupadorHelper.agruparPorValorFace(mao);
		boolean matches = false;
		List<Carta> cartasJogo = new ArrayList<Carta>();
		if (agrupadoPorValorFace.keySet().size() == 5) {
			int gap = mao.getCartas().get(4).getValorFace().getPeso() - mao.getCartas().get(0).getValorFace().getPeso();
			matches = gap == (mao.getCartas().size() - 1);
			
			if (!matches && As == mao.getCartas().get(4).getValorFace()) {
				gap = mao.getCartas().get(3).getValorFace().getPeso() - mao.getCartas().get(0).getValorFace().getPeso();
				matches = gap == (mao.getCartas().size() - 2);
				
				if (matches) {
					int pesoProvisorioAs = 1;
					matches = (mao.getCartas().get(0).getValorFace().getPeso() - pesoProvisorioAs) == 1;
				}
			}
			
		}
		if (matches) {
			cartasJogo = mao.getCartas();
		}
		return new DadosAvaliacaoJogo(SEQUENCIA_NUMERICA, matches, cartasJogo);
	}
	

}

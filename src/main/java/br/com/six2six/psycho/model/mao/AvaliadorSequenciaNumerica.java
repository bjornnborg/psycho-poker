package br.com.six2six.psycho.model.mao;

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
		boolean fazSequencia = false;
		List<Carta> cartasJogo = new ArrayList<Carta>();
		if (possuiCincoCartasDistintas(mao)) {
			fazSequencia = diferencaUltimaCartaPrimeiraIndicaSequencia(mao);
			
			if (!fazSequencia && mao.temAsComoMaiorCarta()) {
				if (diferencaPenultimaCartaPrimeiraIndicaSequencia(mao)) {
					int pesoProvisorioAs = 1;
					fazSequencia = (mao.getCartas().get(0).getValorFace().getPeso() - pesoProvisorioAs) == 1;
				}
			}
			
		}
		if (fazSequencia) {
			cartasJogo = mao.getCartas();
		}
		return new DadosAvaliacaoJogo(SEQUENCIA_NUMERICA, fazSequencia, cartasJogo);
	}
	
	private boolean possuiCincoCartasDistintas(Mao mao) {
		Map<ValorFace, List<Carta>> agrupadoPorValorFace = AgrupadorHelper.agruparPorValorFace(mao);
		return agrupadoPorValorFace.keySet().size() == 5;
	}
	
	private boolean diferencaUltimaCartaPrimeiraIndicaSequencia(Mao mao) {
		return calcularGap(mao, mao.getCartas().size()-1) == (mao.getCartas().size() - 1);
	}
	
	private boolean diferencaPenultimaCartaPrimeiraIndicaSequencia(Mao mao) {
		return calcularGap(mao, mao.getCartas().size()-2) == (mao.getCartas().size() - 2);
	}	
	
	private int calcularGap(Mao mao, int indiceUltimaCarta) {
		return mao.getCartas().get(indiceUltimaCarta).getValorFace().getPeso() - mao.getCartas().get(0).getValorFace().getPeso();
	}
	

}

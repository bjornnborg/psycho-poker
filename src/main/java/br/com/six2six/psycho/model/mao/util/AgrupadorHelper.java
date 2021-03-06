package br.com.six2six.psycho.model.mao.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.Naipe;
import br.com.six2six.psycho.model.ValorFace;
import br.com.six2six.psycho.model.mao.Mao;

public class AgrupadorHelper {

	public static Map<ValorFace, List<Carta>> agruparPorValorFace(List<Carta> cartas) {
		Map<ValorFace, List<Carta>> cartasAgrupadas = new TreeMap<ValorFace, List<Carta>>(); 
		for(Carta carta : cartas) {
			List<Carta> cartasDoGrupo = cartasAgrupadas.get(carta.getValorFace());
			if (cartasDoGrupo == null) {
				cartasDoGrupo = new ArrayList<Carta>();
				cartasAgrupadas.put(carta.getValorFace(), cartasDoGrupo);
			}
			cartasDoGrupo.add(carta);
		}
		return cartasAgrupadas;
	}
	
	public static Map<Naipe, List<Carta>> agruparPorNaipe(List<Carta> cartas) {
		Map<Naipe, List<Carta>> cartasAgrupadas = new TreeMap<Naipe, List<Carta>>(); 
		for(Carta carta : cartas) {
			List<Carta> cartasDoGrupo = cartasAgrupadas.get(carta.getNaipe());
			if (cartasDoGrupo == null) {
				cartasDoGrupo = new ArrayList<Carta>();
				cartasAgrupadas.put(carta.getNaipe(), cartasDoGrupo);
			}
			cartasDoGrupo.add(carta);
		}
		return cartasAgrupadas;
	}
	
}

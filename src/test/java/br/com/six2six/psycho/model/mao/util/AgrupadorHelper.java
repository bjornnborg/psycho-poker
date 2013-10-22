package br.com.six2six.psycho.model.mao.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.Mao;
import br.com.six2six.psycho.model.Naipe;
import br.com.six2six.psycho.model.ValorFace;

public class AgrupadorHelper {

	public static Map<ValorFace, List<Carta>> agruparPorValorFace(Mao mao) {
		Map<ValorFace, List<Carta>> cartasAgrupadas = new HashMap<ValorFace, List<Carta>>(); 
		for(Carta carta : mao.getCartas()) {
			List<Carta> cartas = cartasAgrupadas.get(carta.getValorFace());
			if (cartas == null) {
				cartas = new ArrayList<Carta>();
				cartasAgrupadas.put(carta.getValorFace(), cartas);
			}
			cartas.add(carta);
		}
		return cartasAgrupadas;
	}
	
	public static Map<Naipe, List<Carta>> agruparPorNaipe(Mao mao) {
		Map<Naipe, List<Carta>> cartasAgrupadas = new HashMap<Naipe, List<Carta>>(); 
		for(Carta carta : mao.getCartas()) {
			List<Carta> cartas = cartasAgrupadas.get(carta.getNaipe());
			if (cartas == null) {
				cartas = new ArrayList<Carta>();
				cartasAgrupadas.put(carta.getNaipe(), cartas);
			}
			cartas.add(carta);
		}
		return cartasAgrupadas;
	}
	
}
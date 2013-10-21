package br.com.six2six.psycho.model;

import static br.com.six2six.psycho.model.Naipe.Copas;
import static br.com.six2six.psycho.model.Naipe.Espadas;
import static br.com.six2six.psycho.model.Naipe.Ouros;
import static br.com.six2six.psycho.model.Naipe.Paus;
import static br.com.six2six.psycho.model.ValorFace.As;
import static br.com.six2six.psycho.model.ValorFace.Dois;
import static br.com.six2six.psycho.model.ValorFace.Quatro;
import static br.com.six2six.psycho.model.ValorFace.Sete;
import static br.com.six2six.psycho.model.ValorFace.Tres;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class CartaTest {

	@Test
	public void exibirNomeCorreto() {
		Carta asDeCopas = new Carta(As, Copas);
		assertEquals("Ás de Copas", asDeCopas.toString());
	}
	
	@Test
	public void criarFromStringValida() {
		Carta carta = Carta.from("7H");
		assertEquals(Sete, carta.getValorFace());
		assertEquals(Copas, carta.getNaipe());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void criarFromStringInvalida() {
		Carta.from("7U");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void criarSemNaipe() {
		new Carta(As, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void criarSemValor() {
		new Carta(null, Copas);
	}
	
	@Test
	public void ordenarPorValorDeFace() {
		
		@SuppressWarnings("serial")
		List<Carta> cartas = new ArrayList<Carta>(){{
			add(new Carta(Quatro, Paus));
			add(new Carta(As, Copas));
			add(new Carta(Tres, Espadas));
			add(new Carta(Dois, Ouros));
		}};
		
		Collections.sort(cartas);
		
		assertEquals(Dois, cartas.get(0).getValorFace());
		assertEquals(Tres, cartas.get(1).getValorFace());
		assertEquals(Quatro, cartas.get(2).getValorFace());
		assertEquals(As, cartas.get(3).getValorFace());
	}
	
}

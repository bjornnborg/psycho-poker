package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.Naipe.Copas;
import static br.com.six2six.psycho.model.Naipe.Paus;
import static br.com.six2six.psycho.model.ValorFace.As;
import static br.com.six2six.psycho.model.ValorFace.Cinco;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.Monte;

public class MonteTest {

	@Test
	public void deveTrocarCartaPelaPrimeiraDoMonte() {
		Monte monte = Monte.from("AH", "5C", "3D", "3S", "8H");
		List<Carta> novasCartas = monte.trocar(1);
		assertEquals(As, novasCartas.get(0).getValorFace());
		assertEquals(Copas, novasCartas.get(0).getNaipe());
	}
	
	@Test
	public void deveTrocarSequencialmente() {
		Monte monte = Monte.from("AH", "5C", "3D", "3S", "8H");
		
		List<Carta> cartas = monte.trocar(2);
		
		assertEquals(2, cartas.size());
		assertEquals(As, cartas.get(0).getValorFace());
		assertEquals(Copas, cartas.get(0).getNaipe());
		assertEquals(Cinco, cartas.get(1).getValorFace());
		assertEquals(Paus, cartas.get(1).getNaipe());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveCriarMonteMenosCincoCartas() {
		Monte.from("AH", "5C", "3D", "3S");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveCriarMonteMaisCincoCartas() {
		Monte.from("AH", "5C", "3D", "3S", "8H", "JS");
	}
	
}

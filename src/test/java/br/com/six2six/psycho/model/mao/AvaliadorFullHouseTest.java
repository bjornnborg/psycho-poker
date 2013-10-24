package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.FULL_HOUSE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorFullHouseTest {
	
	@Test
	public void deveIdentificarFullHouse() {
		AvaliadorFullHouse fullHouse = new AvaliadorFullHouse();
		DadosAvaliacaoJogo dadosAvaliacao = fullHouse.getDadosAvaliacao(new Mao(Carta.from("3S", "8S", "3C", "8H", "3D")));
		assertEquals(FULL_HOUSE, dadosAvaliacao.getJogo());
		assertTrue(dadosAvaliacao.fazJogo());
		assertEquals(5, dadosAvaliacao.getCartasJogo().size());
	}
	
	@Test
	public void naoDeveIdentificarSequencia() {
		AvaliadorFullHouse fullHouse = new AvaliadorFullHouse();
		DadosAvaliacaoJogo dadosAvaliacao = fullHouse.getDadosAvaliacao(new Mao(Carta.from("3S", "8S", "3C", "8H", "JD")));
		assertEquals(FULL_HOUSE, dadosAvaliacao.getJogo());
		assertFalse(dadosAvaliacao.fazJogo());
		assertEquals(0, dadosAvaliacao.getCartasJogo().size());
	}
	
	@Test
	public void naoDeveIdentificarFourComoFullHand() {
		AvaliadorFullHouse fullHouse = new AvaliadorFullHouse();
		DadosAvaliacaoJogo dadosAvaliacao = fullHouse.getDadosAvaliacao(new Mao(Carta.from("3S", "3D", "3C", "3H", "JD")));
		assertEquals(FULL_HOUSE, dadosAvaliacao.getJogo());
		assertFalse(dadosAvaliacao.fazJogo());
		assertEquals(0, dadosAvaliacao.getCartasJogo().size());
	}	

}

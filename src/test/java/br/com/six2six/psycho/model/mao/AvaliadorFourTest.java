package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.FOUR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorFourTest {
	
	@Test
	public void deveIdentificarFour() {
		AvaliadorFour four = new AvaliadorFour();
		DadosAvaliacaoJogo dadosAvaliacao = four.getDadosAvaliacao(new Mao(Carta.from("3S", "8S", "3C", "3H", "3D")));
		assertEquals(FOUR, dadosAvaliacao.getJogo());
		assertTrue(dadosAvaliacao.fazJogo());
		assertEquals(4, dadosAvaliacao.getCartasJogo().size());
	}
	
	@Test
	public void naoDeveIdentificarSequencia() {
		AvaliadorFour four = new AvaliadorFour();
		DadosAvaliacaoJogo dadosAvaliacao = four.getDadosAvaliacao(new Mao(Carta.from("3S", "8S", "3C", "5H", "3D")));
		assertEquals(FOUR, dadosAvaliacao.getJogo());
		assertFalse(dadosAvaliacao.fazJogo());
		assertEquals(0, dadosAvaliacao.getCartasJogo().size());
	}
	
	@Test
	public void naoDeveIdentificarFullHouseComoFour() {
		AvaliadorFour four = new AvaliadorFour();
		DadosAvaliacaoJogo dadosAvaliacao = four.getDadosAvaliacao(new Mao(Carta.from("3S", "3D", "3C", "JS", "JD")));
		assertEquals(FOUR, dadosAvaliacao.getJogo());
		assertFalse(dadosAvaliacao.fazJogo());
		assertEquals(0, dadosAvaliacao.getCartasJogo().size());
	}	

}

package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.TRINCA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorTrincaTest {

	@Test
	public void deveIdentificarTrinca() {
		AvaliadorTrinca par = new AvaliadorTrinca();
		DadosAvaliacaoJogo dadosAvaliacao = par.getDadosAvaliacao(new Mao(Carta.from("3S", "4H", "5D", "4D", "4S")));
		assertEquals(TRINCA, dadosAvaliacao.getJogo());
		assertTrue(dadosAvaliacao.fazJogo());
		assertEquals(Carta.from("4H"), dadosAvaliacao.getCartasJogo().get(0));
		assertEquals(Carta.from("4D"), dadosAvaliacao.getCartasJogo().get(1));
		assertEquals(Carta.from("4S"), dadosAvaliacao.getCartasJogo().get(2));
	}	
	
	@Test
	public void naoDeveIdentificarFullHouseComoTrinca() {
		AvaliadorTrinca par = new AvaliadorTrinca();
		DadosAvaliacaoJogo dadosAvaliacao = par.getDadosAvaliacao(new Mao(Carta.from("3S", "3H", "4C", "4D", "4S")));
		assertEquals(TRINCA, dadosAvaliacao.getJogo());
		assertFalse(dadosAvaliacao.fazJogo());
		assertEquals(0, dadosAvaliacao.getCartasJogo().size());
	}	
}

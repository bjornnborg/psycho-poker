package br.com.six2six.psycho.model.mao;


import static br.com.six2six.psycho.model.mao.Jogo.PAR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorParTest {
	
	@Test
	public void deveIdentificarPar() {
		AvaliadorPar par = new AvaliadorPar();
		DadosAvaliacaoJogo dadosAvaliacao = par.getDadosAvaliacao(new Mao(Carta.from("3S", "4H", "5D", "4D", "AC")));
		assertEquals(PAR, dadosAvaliacao.getJogo());
		assertTrue(dadosAvaliacao.fazJogo());
		assertEquals(Carta.from("4H"), dadosAvaliacao.getCartasJogo().get(0));
		assertEquals(Carta.from("4D"), dadosAvaliacao.getCartasJogo().get(1));
	}
	
	@Test
	public void naoDeveIdentificarDoisParesComoPar() {
		AvaliadorPar par = new AvaliadorPar();
		DadosAvaliacaoJogo dadosAvaliacao = par.getDadosAvaliacao(new Mao(Carta.from("3S", "4H", "5D", "4D", "5C")));
		assertEquals(PAR, dadosAvaliacao.getJogo());
		assertFalse(dadosAvaliacao.fazJogo());
		assertEquals(0, dadosAvaliacao.getCartasJogo().size());
	}
	
	@Test
	public void naoDeveIdentificarTrincaComoPar() {
		AvaliadorPar par = new AvaliadorPar();
		DadosAvaliacaoJogo dadosAvaliacao = par.getDadosAvaliacao(new Mao(Carta.from("4S", "4H", "5D", "4D", "5C")));
		assertEquals(PAR, dadosAvaliacao.getJogo());
		assertFalse(dadosAvaliacao.fazJogo());
		assertEquals(0, dadosAvaliacao.getCartasJogo().size());
	}	
	
	@Test
	public void naoDeveIdentificarFourComoPar() {
		AvaliadorPar par = new AvaliadorPar();
		DadosAvaliacaoJogo dadosAvaliacao = par.getDadosAvaliacao(new Mao(Carta.from("3S", "4H", "4C", "4D", "4S")));
		assertEquals(PAR, dadosAvaliacao.getJogo());
		assertFalse(dadosAvaliacao.fazJogo());
		assertEquals(0, dadosAvaliacao.getCartasJogo().size());
	}

}

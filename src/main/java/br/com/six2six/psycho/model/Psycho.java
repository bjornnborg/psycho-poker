package br.com.six2six.psycho.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.six2six.psycho.model.mao.AvaliadorDoisPares;
import br.com.six2six.psycho.model.mao.AvaliadorFour;
import br.com.six2six.psycho.model.mao.AvaliadorFullHouse;
import br.com.six2six.psycho.model.mao.AvaliadorMaiorCarta;
import br.com.six2six.psycho.model.mao.AvaliadorPar;
import br.com.six2six.psycho.model.mao.AvaliadorSequenciaNaipe;
import br.com.six2six.psycho.model.mao.AvaliadorSequenciaNumerica;
import br.com.six2six.psycho.model.mao.AvaliadorSequenciaNumericaNaipe;
import br.com.six2six.psycho.model.mao.AvaliadorTrinca;
import br.com.six2six.psycho.model.mao.Mao;
import br.com.six2six.psycho.model.util.CollectionUtil;

public class Psycho {
	
	private List<AvaliadorMao> avalidadoresMao = new ArrayList<AvaliadorMao>();
	
	public Psycho() {
		this.avalidadoresMao.add(new AvaliadorMaiorCarta());
		this.avalidadoresMao.add(new AvaliadorPar());
		this.avalidadoresMao.add(new AvaliadorDoisPares());
		this.avalidadoresMao.add(new AvaliadorTrinca());
		this.avalidadoresMao.add(new AvaliadorSequenciaNumerica());
		this.avalidadoresMao.add(new AvaliadorSequenciaNaipe());
		this.avalidadoresMao.add(new AvaliadorFullHouse());
		this.avalidadoresMao.add(new AvaliadorFour());
		this.avalidadoresMao.add(new AvaliadorSequenciaNumericaNaipe());
		Collections.sort(this.avalidadoresMao, Collections.reverseOrder());
	}



	public DadosAvaliacaoJogo descobrirMaiorJogo(Mao mao, Monte monte) {
		DadosAvaliacaoJogo maiorJogo = null;
		
		for(int quantidadeTrocas = 0; quantidadeTrocas <= 5; quantidadeTrocas++) {
			List<List<Carta>> combinacoes = CollectionUtil.combinar(mao.cartas().todas(), 5 - quantidadeTrocas);
			if (combinacoes.size() == 0) {
				combinacoes.add(new ArrayList<Carta>(mao.cartas().todas()));
			}
			for (List<Carta> cartasCombinacao : combinacoes) {
				if (quantidadeTrocas == 5) {
					cartasCombinacao.clear();
				}
				cartasCombinacao.addAll(monte.trocar(quantidadeTrocas));
				
				Mao maoTemp = new Mao(cartasCombinacao);
				DadosAvaliacaoJogo dadosAvaliacao = this.avaliarMao(maoTemp);
				if (maiorJogo == null || dadosAvaliacao.maiorQue(maiorJogo)) {
					maiorJogo = dadosAvaliacao;
				}
			}
		}
		
		System.out.println(String.format("Mão %s - Monte: %s - Cartas do melhor jogo: %s - Jogo: %s", mao, monte, maiorJogo.getCartasJogo(), maiorJogo.getJogo()));
		return maiorJogo;
	}

	private DadosAvaliacaoJogo avaliarMao(Mao mao) {
		DadosAvaliacaoJogo maiorJogo = null;
		for(AvaliadorMao avaliador : avalidadoresMao) {
			DadosAvaliacaoJogo dadosAvaliacao = avaliador.getDadosAvaliacao(mao);
			if (dadosAvaliacao.fazJogo()) {
				maiorJogo = dadosAvaliacao;
			}
		}
		return maiorJogo;
	}
	
}
 
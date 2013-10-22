package br.com.six2six.psycho.model.mao.util;

import static br.com.six2six.psycho.model.ValorFace.As;
import static br.com.six2six.psycho.model.ValorFace.Cinco;
import static br.com.six2six.psycho.model.ValorFace.Oito;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.Mao;
import br.com.six2six.psycho.model.ValorFace;

public class AgrupadorHelperTest {

	@Test
	public void agruparPorValorFace() {
		Map<ValorFace, List<Carta>> agruparPorValorFace = AgrupadorHelper.agruparPorValorFace(new Mao(Carta.from("AS", "8H", "5D", "8S", "AC")));
		assertEquals(3, agruparPorValorFace.keySet().size());
		assertEquals(2, agruparPorValorFace.get(As).size());
		assertEquals(2, agruparPorValorFace.get(Oito).size());
		assertEquals(1, agruparPorValorFace.get(Cinco).size());
	}
}

package br.com.six2six.psycho.model.mao;

import org.junit.Test;

public class MaoTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveCriarMaoMenosCincoCartas() {
		Mao.from("AH", "5C", "3D", "3S");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveCriarMaoMaisCincoCartas() {
		Mao.from("AH", "5C", "3D", "3S", "8H", "JS");
	}	

}

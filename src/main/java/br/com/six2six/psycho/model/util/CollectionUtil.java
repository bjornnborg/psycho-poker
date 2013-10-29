package br.com.six2six.psycho.model.util;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtil {
	
	public static <T> List<List<T>> combinar(List<T> lista, int posicoes) {
		List<List<T>> resultado = new ArrayList<List<T>>();
		
		if (posicoes == lista.size()) {
			resultado.add(lista);
			return resultado;
		}
		
		if (posicoes == 0) {
			resultado.add(new ArrayList<T>());
			return resultado;
		}
		
		for(int quantidadeElementos = 0; quantidadeElementos < lista.size() - posicoes; quantidadeElementos++) {
			for(int j = 0; j < lista.size(); j++) {
				List<T> combinados = new ArrayList<T>();
				for(int k = 0; k < lista.size(); k++) {
					if (j != k) {
						combinados.add(lista.get(k));
					}
				}
				resultado.add(combinados);
			}
		}
		
		return resultado;
	}

}

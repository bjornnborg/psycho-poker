package br.com.six2six.psycho.model.util;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtil {
	
	public static <T> List<List<T>> combinar(List<T> lista, int posicoes) {
		List<List<T>> resultado = new ArrayList<List<T>>();
		
		for(int j = 0; j < lista.size(); j++) {
			
			if (posicoes == 1) {
				List<T> list = new ArrayList<T>();
				list.add(lista.get(j));
				resultado.add(list);
			}
			
			List<T> sublista = lista.subList(j+1, lista.size());
			List<List<T>> listaCombinada = combinar(sublista, posicoes-1);
			
			for(int i = 0; i < listaCombinada.size(); i++) {
				List<T> asList = new ArrayList<T>();
				asList.add(0,lista.get(j));
				asList.addAll(listaCombinada.get(i));
				resultado.add(asList);
			}
			
		}
		
		return resultado;
	}
	
}

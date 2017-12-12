package dao;

import java.util.ArrayList;

import entity.Vagao;

public final class ArrayListVagao {
		static ArrayList <Vagao> vagoesdisponiveis;
		private static ArrayListVagao instance = null;
		private ArrayListVagao(ArrayList<Vagao> vagoes) {}
		public static ArrayListVagao getInstance() {
		if (instance==null) {
		
		instance = new ArrayListVagao(vagoesdisponiveis);
		}
		return instance;
		}
		public static ArrayList<Vagao> getVagoesdisponiveis() {
			return vagoesdisponiveis;
		}
		public static void setVagoesdisponiveis(ArrayList<Vagao> vagoesdisponiveis) {
			ArrayListVagao.vagoesdisponiveis = vagoesdisponiveis;
		}
		public static void setInstance(ArrayListVagao instance) {
			ArrayListVagao.instance = instance;
		}
		public void add(Vagao vagao) {
			vagoesdisponiveis.add(vagao);
			
		}
		
		}

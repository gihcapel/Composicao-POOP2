package dao;

import java.util.ArrayList;

import entity.Locomotiva;

public final class ArrayListLocomotiva {
		static ArrayList <Locomotiva> locomotivasdisponiveis;
		private static ArrayListLocomotiva instance = null;
		private ArrayListLocomotiva(ArrayList<Locomotiva> locomotivas) {}
		public static ArrayListLocomotiva getInstance() {
		if (instance==null) {
		
		instance = new ArrayListLocomotiva(locomotivasdisponiveis);
		}
		return instance;
		}
		public static ArrayList<Locomotiva> getLocomotivasdisponiveis() {
			return locomotivasdisponiveis;
		}
		public static void setLocomotivasdisponiveis(ArrayList<Locomotiva> locomotivasdisponiveis) {
			ArrayListLocomotiva.locomotivasdisponiveis = locomotivasdisponiveis;
		}
		public static void setInstance(ArrayListLocomotiva instance) {
			ArrayListLocomotiva.instance = instance;
		}
		public void add(Locomotiva locomotiva) {
			locomotivasdisponiveis.add(locomotiva);
			
		}
		
		}
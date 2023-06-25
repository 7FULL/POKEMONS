package controllers;

import java.util.Iterator;

public class LobbieManager {

	private static int[] personas = new int[] {0,0,0};
	
	public static String unirseAUnLobbie() {
			for (int i = 0; i < personas.length; i++) {
				if (personas[i] < 2) {
					personas[i]++;
					return String.valueOf(i);
				}
			}
			
			return "-1";
	}
	
	public static void borrarLobbie(int x) {
		personas[x] = 0;
	}
	
	public static void borrarTodos() {
		for (int i = 0; i < personas.length; i++) {
			personas[i] = 0;
		}
	}
}

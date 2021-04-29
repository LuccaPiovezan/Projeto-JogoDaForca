package br.com.softblue.jogoDaForca.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.softblue.jogoDaForca.Game.GameException;
import br.com.softblue.jogoDaForca.utils.RandomUtils;

public abstract class Dictionary {

	private static Dictionary instance;

	public static Dictionary getInstance() {
		// if(instance == null) {
		// instance = new Dictionary();
		// }
		return instance;
	}

	public abstract Word nextWord();
	
	public abstract String getName();
}

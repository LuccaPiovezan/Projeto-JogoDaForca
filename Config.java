package br.com.softblue.jogoDaForca.core;

import java.io.IOException;
import java.util.Properties;

public class Config {

	private static Properties props = new Properties();
	
	static{
		try {
			props.load(Config.class.getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String get(String name) {
		return props.getProperty(name);
	}
}

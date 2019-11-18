package controller;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
	private static ResourceBundle resource;
	public static void init(String l1, String l2) {
		Locale.setDefault(new Locale(l1, l2));
		resource = ResourceBundle.getBundle("language/language", Locale.getDefault());
	}
	public static String get(String key) {
		return resource.getString(key);
	}
	
}

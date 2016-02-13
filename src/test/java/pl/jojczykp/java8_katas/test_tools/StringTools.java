package pl.jojczykp.java8_katas.test_tools;

public final class StringTools {

	private StringTools() {
	}

	public static String longerOf(String s1, String s2) {
		return s1.length() >= s2.length() ? s1 : s2;
	}

}

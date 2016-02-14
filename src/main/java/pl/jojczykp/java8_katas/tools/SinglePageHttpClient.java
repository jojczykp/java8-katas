package pl.jojczykp.java8_katas.tools;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public final class SinglePageHttpClient {

	private static final String BEGINNING_OF_THE_INPUT = "\\A";

	private SinglePageHttpClient() {
	}

	public static String blockingReadPage(String url) {
		try {
			return new Scanner(new URL(url).openConnection().getInputStream())
							.useDelimiter(BEGINNING_OF_THE_INPUT).next();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}

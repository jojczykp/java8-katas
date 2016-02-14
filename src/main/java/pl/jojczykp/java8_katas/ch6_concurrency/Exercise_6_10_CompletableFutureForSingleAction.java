package pl.jojczykp.java8_katas.ch6_concurrency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.concurrent.TimeUnit.SECONDS;
import static pl.jojczykp.java8_katas.tools.SinglePageHttpClient.blockingReadPage;


public class Exercise_6_10_CompletableFutureForSingleAction {

	private static final Pattern A_HREF_URL_PATTERN = Pattern.compile("<a\\s+href\\s*=\\s*(\\S*)\\s*>");
	private static final int TIMEOUT_SEC = 3;

	public List<String> getAllLinksFrom(String url)
			throws IOException, ExecutionException, InterruptedException, TimeoutException {
		return CompletableFuture.supplyAsync(() ->
				blockingReadPage(url))
				.thenApply(this::getLinks)
				.get(TIMEOUT_SEC, SECONDS);
	}

	List<String> getLinks(String s) {
		List<String> result = new ArrayList<>();
		Matcher matcher = A_HREF_URL_PATTERN.matcher(s);
		while (matcher.find()) {
			result.add(unquoteIfNeeded(matcher.group(1)));
		}

		return result;
	}

	private static String unquoteIfNeeded(String str) {
		return str.replaceAll("^\"|^'|\"$|'$", "");
	}

}

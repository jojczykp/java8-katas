package pl.jojczykp.java8_katas.ch6_concurrency;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.jojczykp.java8_katas.test_tools.SinglePageHttpServer;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class Exercise_6_10_CompletableFutureForHttpTest {

	private static final int PORT = 12345;

	private SinglePageHttpServer server;
	private Exercise_6_10_CompletableFutureForHttp testee =
									new Exercise_6_10_CompletableFutureForHttp();

	@Before
	public void setupHttpServer() {
		server = SinglePageHttpServer.newRunningInstance(PORT,
				"<html><head/><body>\n" +
				"    Some text <a href=\"http://link1.to.page\">link to page</a>\n" +
				"    <p>Some text <a href='http://link2.to.page'>link to page</a></p>\n" +
				"    <span>Some text <a href  = http://link3.to.page >link to page</a></span>\n" +
				"</body></html>");
	}

	@Test
	public void shouldGetPageAndReturnLinks() throws Exception {
		List<String> result = testee.getAllLinksFrom("http://localhost:" + PORT + "/");

		assertThat(result, containsInAnyOrder(
				"http://link1.to.page",
				"http://link2.to.page",
				"http://link3.to.page"));
	}

	@After
	public void shutdownHttpServer() {
		if (server != null) {
			server.stop();
		}
	}

}

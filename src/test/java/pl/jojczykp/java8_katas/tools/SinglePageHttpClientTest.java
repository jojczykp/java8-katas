package pl.jojczykp.java8_katas.tools;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.jojczykp.java8_katas.test_tools.SinglePageHttpServer;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static pl.jojczykp.java8_katas.tools.SinglePageHttpClient.blockingReadPage;


public class SinglePageHttpClientTest {

	private static final int PORT = 54321;
	private static final String PAGE = "<html><head/>Page!<body/></html>";

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private SinglePageHttpServer server;

	@Test
	public void shouldReadPage() {
		server = SinglePageHttpServer.newRunningInstance(PORT, PAGE);

		String page = blockingReadPage("http://localhost:" + PORT);

		assertThat(page, is(equalTo(PAGE)));
	}

	@Test
	public void shouldWrapException() {
		thrown.expect(RuntimeException.class);
		thrown.expectCause(instanceOf(MalformedURLException.class));

		blockingReadPage("malformedUrl");
	}

	@After
	public void stopServerIfCreated() {
		if (server != null) {
			server.stop();
		}
	}

}

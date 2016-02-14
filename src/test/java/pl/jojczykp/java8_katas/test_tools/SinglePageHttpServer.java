package pl.jojczykp.java8_katas.test_tools;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public final class SinglePageHttpServer {

	private static final int IMMEDIATELY = 0;
	private static final int SHUTDOWN_POOL_TIMEOUT_SECS = 10;
	private static final int HTTP_OK = 200;

	private HttpServer server;

	private SinglePageHttpServer(int port, String page) throws IOException {
		server = HttpServer.create(new InetSocketAddress(port), 0);
		server.createContext("/", requestHandler(page));
		server.setExecutor(null);
	}

	public static SinglePageHttpServer newRunningInstance(int port, String page) {
		try {
			SinglePageHttpServer instance = new SinglePageHttpServer(port, page);
			instance.start();

			return instance;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void start() {
		server.start();
	}

	public void stop() {
		server.stop(IMMEDIATELY);
		ForkJoinPool.commonPool().awaitQuiescence(SHUTDOWN_POOL_TIMEOUT_SECS, TimeUnit.SECONDS);
	}

	private HttpHandler requestHandler(String page) {
		return httpExchange -> {
			try {
				httpExchange.sendResponseHeaders(HTTP_OK, page.length());
				httpExchange.getResponseBody().write(page.getBytes());
			} finally {
				httpExchange.close();
			}
		};
	}

}

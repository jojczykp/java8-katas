package pl.jojczykp.java8_katas.ch1_streams;

import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class Exercise3Test {

	private Exercise3 testee = new Exercise3();

	@Test
	public void shouldListFilesByExtension() throws URISyntaxException {
		String root = getClass().getResource("/").toURI().getPath();
		File dir = new File(root + Paths.get("ch1_streams", "ex3"));

		Iterable<String> files = testee.listFilesByExtensionIn(dir, "abc");

		assertThat(files, containsInAnyOrder("file1.abc", "file2.abc"));
	}

}
